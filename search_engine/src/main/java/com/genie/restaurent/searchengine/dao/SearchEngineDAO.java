package com.genie.restaurent.searchengine.dao;

import java.util.List;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Menu;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;
import com.genie.restaurent.searchengine.model.Reviews;

public interface SearchEngineDAO {

	public NearbyRestaurants retrieveRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException;

	public NearbyRestaurants retrieveRestaurantsByPostalCode(String PostalCode) throws RestaurantSearchException;

	public CustomerFavRestaurants listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
	
	public List<Menu> retrieveMenus(Integer restaurantId) throws RestaurantSearchException;
	
	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException;
	
	
}
