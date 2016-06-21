package com.genie.restaurent.searchengine.dao.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Restaurant;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;
import com.genie.restaurent.searchengine.service.util.RestaurantMenuExtractor;
import com.genie.restaurent.searchengine.service.util.RestaurantResultExtractor;
import com.genie.restaurent.searchengine.service.util.RestaurantReviewsExtractor;

@Named
@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Resource
	private DataSource gogenieDataSource;

	@Resource
	private RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(SearchEngineDAOImpl.class);

	@PostConstruct
	private void setupJdbcTemplate() {
		logger.debug("Entering into setupJdbcTemplate()");
		jdbcTemplate = new JdbcTemplate(gogenieDataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(gogenieDataSource);
		logger.debug("Exiting from setupJdbcTemplate()");
	}

	public RestaurantsAndMenus retrieveRestaurantsByLocation(Double latitude, Double longitude, String machinfo)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveRestaurantsByLocation()");
		/**
		 * Call the stored proc to retreive near by restaurants and menus in
		 * each restaurant. This will be mainly used for Menu search from the
		 * search bar.
		 */
		Integer distance = 10;
		SqlParameterSource inputParam = new MapSqlParameterSource().addValue("mylat", latitude)
				.addValue("mylon", longitude).addValue("dist", distance);
		logger.debug("Before retrieve the restaurants and menus nearby this location lat {} , lon {} and distance {} ",
				latitude, longitude, distance);
		RestaurantsAndMenus restaurantsAndMenus = (RestaurantsAndMenus) namedParameterJdbcTemplate.query(
				"{call get_restaurant_by_distance(:mylat, :mylon, :dist)}", inputParam,
				new RestaurantResultExtractor());

		if (restaurantsAndMenus != null) {
			logger.debug("Retrieved the restaurants and menus nearby this location are {} ",
					restaurantsAndMenus.toString());

			// Load the data into elastic search
			URI elasticSearchURI = null;
			try {
				logger.debug("Before load this restaurants and menu details in elastic search");
				elasticSearchURI = new URI("http:localhost:9200/gogenie/" + machinfo + "/");
				HttpEntity<RestaurantsAndMenus> request = new HttpEntity<RestaurantsAndMenus>(populateHeaders());
				ResponseEntity response = restTemplate.exchange(elasticSearchURI, HttpMethod.POST, request,
						ResponseEntity.class);

				HttpStatus statusCode = response.getStatusCode();
				logger.debug("Status code retured after load the data into elastic search {} ", statusCode.name());
				if (statusCode != null && statusCode.equals(HttpStatus.ACCEPTED)) {
					logger.debug("Before suppress the menu details from each restaurant");
					List<Restaurant> restaurants = restaurantsAndMenus.getRestaurants();
					for (Restaurant restaurant : restaurants) {
						// Menus are not required for UI at initial level
						restaurant.setMenus(null);
					}
					logger.debug("Restaurant details after suppress the menu details are  {} ",
							restaurantsAndMenus.toString());
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

		}

		logger.debug("Exiting from retrieveRestaurantsByLocation()");
		return restaurantsAndMenus;
	}

	private HttpHeaders populateHeaders() {
		logger.debug("Entering into setupJdbcTemplate()");
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("content-Type", "application/json");
		logger.debug("Exiting from setupJdbcTemplate()");
		return headers;
	}

	/**
	 * This method is mainly useful if front end couldn't identify the latitude
	 * and longitude for the input zipcode.
	 * 
	 */
	public RestaurantsAndMenus retrieveRestaurantsByPostalCode(String postalCode, String machinfo)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveRestaurantsByPostalCode()");
		// call the stored proc to get the latitude and longitude for the input
		// postal code.
		List<Double> locationdetails = null;
		RestaurantsAndMenus nearbyRestaurants = null;
		try {
			logger.debug("Before retrieve the latitude and longitude for the zipCode {} ", postalCode);
			locationdetails = jdbcTemplate.queryForObject("select latitude, longitude from restaurant where zipcode=?",
					new Object[] { postalCode }, new RowMapper<List<Double>>() {

						public List<Double> mapRow(ResultSet rs, int rowNum) throws SQLException {
							List<Double> resultList = new ArrayList<Double>();
							resultList.add(rs.getDouble("latitude"));
							resultList.add(rs.getDouble("longitude"));
							return resultList;
						}

					});

			if (locationdetails != null && !locationdetails.isEmpty()) {
				Double latitude = locationdetails.get(0);
				Double longitude = locationdetails.get(1);
				logger.debug("Latitude is {} and longitude is {} for the zipcode ", latitude, longitude, postalCode);
				nearbyRestaurants = retrieveRestaurantsByLocation(latitude, longitude, machinfo);
				logger.debug("Successfully retrieved the nearby restaurants for the above location");

			}
		} catch (Exception e) {
			throw new RestaurantSearchException(e, "retrieveRestaurantsByPostalCode");
		}
		logger.debug("Exiting from retrieveRestaurantsByPostalCode()");
		return nearbyRestaurants;
	}

	public CustomerFavRestaurants listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		logger.debug("Entering into listCustomerFavRestaurants()");

		CustomerFavRestaurants customerFavRestaurants = namedParameterJdbcTemplate.query(
				"{call get_cust_fav_restaurant(:cust_id)}", new MapSqlParameterSource().addValue("cust_id", customerId),
				new ResultSetExtractor<CustomerFavRestaurants>() {

					public CustomerFavRestaurants extractData(ResultSet rs) throws SQLException, DataAccessException {
						return null;
					}
				});
		logger.debug("Exiting from listCustomerFavRestaurants()");
		return customerFavRestaurants;
	}

	public RestaurantMenus retrieveMenusForARestaurant(Integer restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveMenusForARestaurant()");
		MapSqlParameterSource inputParam = new MapSqlParameterSource();
		inputParam.addValue("restaurantId", restaurantId);
		logger.debug("Retrive menus for a restaurant {} ", restaurantId);
		RestaurantMenus menus = (RestaurantMenus) namedParameterJdbcTemplate
				.query("{call get_restaurant_menu(:restaurantId)}", inputParam, new RestaurantMenuExtractor());
		
		if (menus != null) {
			logger.debug("List of available menus in the restaurant {} is  {}", restaurantId, menus.toString());
		}
		
		logger.debug("Exiting from retrieveMenusForARestaurant()");
		return menus;
	}

	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveReviews()");
		
		List<Reviews> reviews = (List<Reviews>) namedParameterJdbcTemplate.query(
				"{call get_resturant_reviews(:restaurantId)}",
				new MapSqlParameterSource().addValue("restaurantId", restaurantId), new RestaurantReviewsExtractor());
		if (reviews != null && !reviews.isEmpty()) {
			logger.debug("Reviews count for the input restaurant id {} is {} " , restaurantId, reviews.size());
		}
		
		logger.debug("Exiting from retrieveReviews()");
		return reviews;
	}

}
