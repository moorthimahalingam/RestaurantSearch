package com.genie.restaurent.searchengine.service.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.genie.restaurent.searchengine.model.Reviews;

public class RestaurantReviewsExtractor implements ResultSetExtractor<List<Reviews>> {

	public List<Reviews> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Reviews> reviewsList = new ArrayList<Reviews>();
		while (rs.next()) {
			Reviews reviews = new Reviews();
			reviews.setCustomerReviewId(rs.getInt("CUSTOMER_REVIEW_ID"));
			reviews.setCustId(rs.getInt("CUST_ID"));
			reviews.setRestaurantId(rs.getInt("RESTAURANT_ID"));
			reviews.setOrderId(rs.getInt("ORDER_ID"));
			reviews.setReviewTitle(rs.getString("REVIEW_TITLE"));
			reviews.setReviewDesc(rs.getString("REVIEW_DESC"));
			reviews.setRating(rs.getInt("RATING"));
			reviewsList.add(reviews);
		}
		return reviewsList;
	}

}
