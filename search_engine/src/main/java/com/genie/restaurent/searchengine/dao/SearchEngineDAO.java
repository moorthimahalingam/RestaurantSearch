package com.genie.restaurent.searchengine.dao;

import java.util.List;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.MenuItemLikeDetail;
import com.genie.restaurent.searchengine.model.Restaurant;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;

public interface SearchEngineDAO {

	public RestaurantsAndMenus retrieveRestaurantsByLocation(Double latitude, Double longitude, String machinfo, Long customerId)
			throws RestaurantSearchException;

	public RestaurantsAndMenus retrieveRestaurantsByPostalCode(String postalCode, String machinfo, Long customerId)
			throws RestaurantSearchException;

	public CustomerFavRestaurants listCustomerFavRestaurants(Long customerId) throws RestaurantSearchException;

	public RestaurantMenus retrieveMenusForARestaurant(Long restaurantId) throws RestaurantSearchException;

	public List<Restaurant> retrieveRestaurantsForAMenu(Double latitude, Double longitude, String menuItemName)
			throws RestaurantSearchException;

	public List<Reviews> retrieveReviews(Long restaurantId) throws RestaurantSearchException;
	
	public String retrieveRestaurantActiveFlag(Long restaurantId) throws RestaurantSearchException;
	
	public List<MenuItemLikeDetail> retrieveLikesCount(Long restaurantId) throws RestaurantSearchException;

}
