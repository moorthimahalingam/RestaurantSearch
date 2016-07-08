package com.genie.restaurent.searchengine.service;

import java.util.List;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Restaurant;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;

public interface SearchEngineService {

	public RestaurantsAndMenus retrieveNearByRestaurantsByLocation(Double latitude, Double longitude, String machinfo, Long customerId)
			throws RestaurantSearchException;

	public RestaurantsAndMenus retrieveNearByRestaurantsByZipCode(String zipCode, String machinfo, Long customerId)
			throws RestaurantSearchException;

	public CustomerFavRestaurants searchCustomerFavRestaurants(Long customerId) throws RestaurantSearchException;

	public RestaurantMenus retrieveARestaurantMenus(Long restaurantId) throws RestaurantSearchException;

	public List<Restaurant> retrieveRestaurantsForAMenu(Double latitude, Double longitude, String menuItemName)
			throws RestaurantSearchException;

	public List<Reviews> retrieveReviews(Long restaurantId) throws RestaurantSearchException;
}
