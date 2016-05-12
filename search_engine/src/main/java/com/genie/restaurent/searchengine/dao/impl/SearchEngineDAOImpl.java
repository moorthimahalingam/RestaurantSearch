package com.genie.restaurent.searchengine.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;

@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	SimpleJdbcCall jdbcCall;

	public String listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		return "Success";
	}

	public NearbyRestaurants retrieveRestaurantsByLocation(Double latitude, Double longitude)
			throws RestaurantSearchException {
		/**
		 * Call the stored proc to retreive near by restaurants and menus in
		 * each restaurant. This will be mainly used for Menu search from the
		 * search bar.
		 */
		// Call the stored proc to retrieve this..
		SqlParameterSource inputParam = new MapSqlParameterSource().addValue("latitude",latitude)
				.addValue("longitude", longitude);
		Map<String, Object> nearbyRestaurantsAndMenus = jdbcCall.withProcedureName("stored proc name").execute(inputParam);
		// Load the data into elastic search
		
		// Call another stored proc to retrieve only near by restaurants, cuisine
		Map<String, Object> nearbyRestaurantsData = jdbcCall.withProcedureName("Stored Proc name").execute(inputParam);
		
		NearbyRestaurants nearbyRestaurants = null;
		return nearbyRestaurants;
	}

	/**
	 * This method is mainly useful if front end couldn't identify the latitude
	 * and longitude for the input zipcode.
	 * 
	 */
	public NearbyRestaurants retrieveRestaurantsByPostalCode(String PostalCode) throws RestaurantSearchException {

		// call the stored proc to get the latitude and longitude for the input postal code.
		NearbyRestaurants nearbyRestaurants = null;
		try {
			Map<String, Object> location = jdbcCall.execute(new MapSqlParameterSource().addValue("zipcode", "ADFD123"));
			Double latitude = (Double)location.get("latitude");
			Double longitude = (Double)location.get("longitude");
			nearbyRestaurants = retrieveRestaurantsByLocation(latitude, longitude);
			
		} catch (Exception e) {
			throw new RestaurantSearchException(e, "retrieveRestaurantsByPostalCode");
		}
		return nearbyRestaurants;
	}

}
