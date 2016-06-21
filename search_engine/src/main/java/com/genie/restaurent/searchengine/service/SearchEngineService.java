package com.genie.restaurent.searchengine.service;

import java.util.List;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;

public interface SearchEngineService {
	
	public RestaurantsAndMenus retrieveNearByRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException ;
	
	public RestaurantsAndMenus retrieveNearByRestaurantsByZipCode(String zipCode) throws RestaurantSearchException ;

	public CustomerFavRestaurants seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
	
	public RestaurantMenus retrieveARestaurantMenus(Integer restaurantId) throws RestaurantSearchException;
	
	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException;
}
