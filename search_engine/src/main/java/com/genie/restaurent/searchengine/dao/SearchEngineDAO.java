package com.genie.restaurent.searchengine.dao;

import java.util.List;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;

public interface SearchEngineDAO {

	public RestaurantsAndMenus retrieveRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException;

	public RestaurantsAndMenus retrieveRestaurantsByPostalCode(String PostalCode) throws RestaurantSearchException;

	public CustomerFavRestaurants listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
	
	public RestaurantMenus retrieveMenusForARestaurant(Integer restaurantId) throws RestaurantSearchException;
	
	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException;
	
	
}
