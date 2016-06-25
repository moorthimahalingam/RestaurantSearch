package com.genie.restaurent.searchengine.service.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.genie.restaurent.searchengine.model.Restaurant;

public class RestaurantsForAMenuExtractor implements ResultSetExtractor<List<Restaurant>> {

	public List<Restaurant> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		while (rs.next()) {
			Restaurant restaurant = new Restaurant();
			restaurant.setRestaurantId(rs.getInt("RESTAURANT_ID"));
			restaurant.setName(rs.getString("RESTAURANT_NAME"));
			restaurant.setLandMark(rs.getString("LANDMARK"));
			restaurant.setRating(rs.getInt("RATING"));
			restaurant.setPricingCategory(rs.getInt("PRICING_CATEGORY"));
			restaurant.setDeliveryFee(rs.getDouble("DELIVERY_FEE"));
			restaurant.setMinimumorder(rs.getDouble("MINIMUM_ORDER_VAL_DELIVERY"));
			restaurant.setWebsite(rs.getString("RESTAURANT_WEBSITE"));
			restaurant.setOpeningTime(rs.getTime("RESTAURANT_OPENINGTIME"));
			restaurant.setClosingTime(rs.getTime("RESTAURANT_CLOSINGTIME"));
			restaurant.setBaseDeliveryTime(rs.getTime("BASE_DELIVERY_TIME"));
			
			restaurants.add(restaurant);
		}
		return restaurants;
	}

}
