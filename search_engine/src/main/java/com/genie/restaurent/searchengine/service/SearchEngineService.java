package com.genie.restaurent.searchengine.service;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;

public interface SearchEngineService {
	
	public NearbyRestaurants retrieveNearByRestaurantsByLocation(Double latitude, Double longitude);
	
	public NearbyRestaurants retrieveNearByRestaurantsByZipCode(String zipCode);

	public String seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
