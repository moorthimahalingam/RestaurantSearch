package com.genie.restaurent.searchengine.dao;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;

public interface SearchEngineDAO {

	public String retrieveRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException;

	public String retrieveRestaurantsByPostalCode(String PostalCode) throws RestaurantSearchException;

	public String listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException;
}
