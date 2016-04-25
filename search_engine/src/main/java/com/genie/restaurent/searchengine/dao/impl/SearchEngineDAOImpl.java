package com.genie.restaurent.searchengine.dao.impl;

import org.springframework.stereotype.Repository;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;

@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {

	public String Searchrestaurants(RestaurantSearchRequest request) throws RestaurantSearchException {
		return "Success";
	}

	public String listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		return "Success";
	}

}
