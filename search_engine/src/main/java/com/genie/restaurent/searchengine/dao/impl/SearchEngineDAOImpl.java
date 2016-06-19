package com.genie.restaurent.searchengine.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Menu;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;
import com.genie.restaurent.searchengine.model.Reviews;
import com.genie.restaurent.searchengine.service.util.RestaurantResultExtractor;

@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Resource
	private DataSource gogenieDataSource;

	@PostConstruct
	private void setupJdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(gogenieDataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(gogenieDataSource);
	}

	public NearbyRestaurants retrieveRestaurantsByLocation(Double latitude, Double longitude)
			throws RestaurantSearchException {
		/**
		 * Call the stored proc to retreive near by restaurants and menus in
		 * each restaurant. This will be mainly used for Menu search from the
		 * search bar.
		 */
		// Call the stored proc to retrieve this..
		SqlParameterSource inputParam = new MapSqlParameterSource().addValue("mylat", latitude)
				.addValue("mylon", longitude).addValue("dist", 3);

		namedParameterJdbcTemplate.query("{call get_restaurant_and_menus_by_dist(:mylat, :mylon, :dist)}", inputParam,
				new RestaurantResultExtractor());

		// Load the data into elastic search

		// Call another stored proc to retrieve only near by restaurants,
		// cuisine

		NearbyRestaurants nearbyRestaurants = (NearbyRestaurants) namedParameterJdbcTemplate.query(
				"{call get_restaurant_by_distance (:mylat, :mylon, :dist)}", inputParam,
				new ResultSetExtractor<Object>() {

					public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
						return null;
					}
				});

		return nearbyRestaurants;
	}

	/**
	 * This method is mainly useful if front end couldn't identify the latitude
	 * and longitude for the input zipcode.
	 * 
	 */
	public NearbyRestaurants retrieveRestaurantsByPostalCode(String postalCode) throws RestaurantSearchException {

		// call the stored proc to get the latitude and longitude for the input
		// postal code.
		List<Double> locationdetails = null;
		NearbyRestaurants nearbyRestaurants = null;
		try {
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
				nearbyRestaurants = retrieveRestaurantsByLocation(latitude, longitude);
			}
		} catch (Exception e) {
			throw new RestaurantSearchException(e, "retrieveRestaurantsByPostalCode");
		}

		return nearbyRestaurants;
	}

	public CustomerFavRestaurants listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		namedParameterJdbcTemplate.query("{call get_cust_fav_restaurant(:cust_id)}",
				new MapSqlParameterSource().addValue("cust_id", customerId), new ResultSetExtractor<Object>() {

					public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
						return null;
					}
				});

		CustomerFavRestaurants customerFavRestaurants = null;
		return customerFavRestaurants;
	}

	public List<Menu> retrieveMenus(Integer restaurantId) throws RestaurantSearchException {
		List<Menu> menus = (List<Menu>)namedParameterJdbcTemplate.query("{call get_restaurant_menu(:restaurantId)}",
				new MapSqlParameterSource().addValue("restaurantId", restaurantId), new ResultSetExtractor<List<Menu>>() {

					public List<Menu> extractData(ResultSet rs) throws SQLException, DataAccessException {
						return null;
					}
				});
		return menus;
	}

	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException {
		List<Reviews> reviews = (List<Reviews>)namedParameterJdbcTemplate.query("{call get_resturant_reviews(:restaurantId)}",
				new MapSqlParameterSource().addValue("restaurantId", restaurantId), new ResultSetExtractor<List<Reviews>>() {

					public List<Reviews> extractData(ResultSet rs) throws SQLException, DataAccessException {
						return null;
					}
				});
		return reviews;
	}
	
	
}
