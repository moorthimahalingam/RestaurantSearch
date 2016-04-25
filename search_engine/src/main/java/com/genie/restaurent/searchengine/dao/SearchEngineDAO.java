package com.genie.restaurent.searchengine.dao;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;

public interface SearchEngineDAO {

	public String Searchrestaurants(RestaurantSearchRequest request) throws RestaurantSearchException;
	
	public String listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
