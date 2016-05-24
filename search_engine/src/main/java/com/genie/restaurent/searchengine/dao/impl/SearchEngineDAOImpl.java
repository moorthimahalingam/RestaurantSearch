package com.genie.restaurent.searchengine.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;

@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {

	private JdbcTemplate jdbcTemplate;

	SimpleJdbcCall jdbcCall;

	@Resource
	private DataSource searchEngineDataSource;

	@PostConstruct
	private void setupJdbcTemplate() {
		jdbcTemplate.setDataSource(searchEngineDataSource);
	}

	public NearbyRestaurants retrieveRestaurantsByLocation(Double latitude, Double longitude)
			throws RestaurantSearchException {
		/**
		 * Call the stored proc to retreive near by restaurants and menus in
		 * each restaurant. This will be mainly used for Menu search from the
		 * search bar.
		 */
		// Call the stored proc to retrieve this..
		SqlParameterSource inputParam = new MapSqlParameterSource().addValue("mylat", latitude).addValue("mylon",
				longitude).addValue("dist", 3);
		jdbcCall = new SimpleJdbcCall(jdbcTemplate);

		Map<String, Object> nearbyRestaurantsAndMenus = jdbcCall.withProcedureName("get_restaurant_and_menus_by_dist")
				.execute(inputParam);
		// Load the data into elastic search

		// Call another stored proc to retrieve only near by restaurants,
		// cuisine
		Map<String, Object> nearbyRestaurantsData = jdbcCall.withProcedureName("get_restaurant_by_dist").execute(inputParam);

		NearbyRestaurants nearbyRestaurants = null;
		jdbcCall = null;
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
		
/*		try {
			jdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withProcedureName("retrieveLatitudeAndlongitudeForTheInput zipcode");
			Map<String, Object> location = jdbcCall.execute(new MapSqlParameterSource().addValue("zipcode", postalCode));
			Double latitude = (Double) location.get("latitude");
			Double longitude = (Double) location.get("longitude");
			nearbyRestaurants = retrieveRestaurantsByLocation(latitude, longitude);
			
		} catch (Exception e) {
			throw new RestaurantSearchException(e, "retrieveRestaurantsByPostalCode");
		} */
		return nearbyRestaurants;
	}

	public CustomerFavRestaurants listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("Customer_Fav_Restaurants");
		
		Map<String, Object> dbResults = jdbcCall.execute(new MapSqlParameterSource().addValue("cust_id", customerId)) ;
		CustomerFavRestaurants customerFavRestaurants = null;
		return customerFavRestaurants;
	}
}
