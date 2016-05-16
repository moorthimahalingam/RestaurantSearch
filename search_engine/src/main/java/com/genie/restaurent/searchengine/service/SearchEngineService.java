package com.genie.restaurent.searchengine.service;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;

public interface SearchEngineService {
	
	public NearbyRestaurants retrieveNearByRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException ;
	
	public NearbyRestaurants retrieveNearByRestaurantsByZipCode(String zipCode) throws RestaurantSearchException ;

	public CustomerFavRestaurants seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
