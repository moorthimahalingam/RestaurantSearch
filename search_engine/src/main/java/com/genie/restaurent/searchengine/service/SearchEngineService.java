package com.genie.restaurent.searchengine.service;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;

public interface SearchEngineService {
	
	public String retrieveNearByRestaurantsByLocation(Double latitude, Double longitude);
	
	public String retrieveNearByRestaurantsByZipCode(String zipCode);

	public String seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
