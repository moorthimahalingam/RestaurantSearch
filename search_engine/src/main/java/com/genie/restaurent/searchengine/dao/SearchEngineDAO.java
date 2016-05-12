package com.genie.restaurent.searchengine.dao;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;

public interface SearchEngineDAO {

	public NearbyRestaurants retrieveRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException;

	public NearbyRestaurants retrieveRestaurantsByPostalCode(String PostalCode) throws RestaurantSearchException;

	public String listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
