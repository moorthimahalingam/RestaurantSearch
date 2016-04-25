package com.genie.restaurent.searchengine.service;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;

public interface SearchEngineService {

	public String searchRestaurants(RestaurantSearchRequest request) throws RestaurantSearchException;
	
	public String seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
