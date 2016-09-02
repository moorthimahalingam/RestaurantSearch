package com.genie.restaurent.searchengine.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.MenuItemLikeDetail;
import com.genie.restaurent.searchengine.model.Restaurant;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@Named
public class SearchEngineServiceImpl implements SearchEngineService {

	Logger logger = LoggerFactory.getLogger(SearchEngineServiceImpl.class);

	@Inject
	SearchEngineDAO searchEngineDAO;

	public CustomerFavRestaurants searchCustomerFavRestaurants(Long customerId) throws RestaurantSearchException {
		logger.debug("Entering into searchCustomerFavRestaurants ");
		CustomerFavRestaurants response = searchEngineDAO.listCustomerFavRestaurants(customerId);
		logger.debug("Exiting from searchCustomerFavRestaurants ");
		return response;
	}

	public RestaurantsAndMenus retrieveNearByRestaurantsByLocation(Double latitude, Double longitude, String machinfo, Long customerId)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveNearByRestaurantsByLocation ");
		RestaurantsAndMenus nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByLocation(latitude, longitude,
				machinfo, customerId);
		logger.debug("Exiting from retrieveNearByRestaurantsByLocation ");
		return nearbyRestaurants;
	}

	public RestaurantsAndMenus retrieveNearByRestaurantsByZipCode(String zipCode, String machinfo, Long customerId)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveNearByRestaurantsByZipCode ");
		RestaurantsAndMenus nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByPostalCode(zipCode, machinfo, customerId);
		logger.debug("Exiting from retrieveNearByRestaurantsByZipCode ");
		return nearbyRestaurants;
	}

	public RestaurantMenus retrieveARestaurantMenus(Long restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveARestaurantMenus ");
		RestaurantMenus menus = searchEngineDAO.retrieveMenusForARestaurant(restaurantId);
		logger.debug("Exiting from retrieveARestaurantMenus ");
		return menus;
	}

	public List<Restaurant> retrieveRestaurantsForAMenu(Double latitude, Double longitude, String menuItemName)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveRestaurantsForAMenu ");
		List<Restaurant> restaurants = searchEngineDAO.retrieveRestaurantsForAMenu(latitude, longitude,menuItemName);
		logger.debug("Exiting from retrieveRestaurantsForAMenu ");
		return restaurants;
	}

	public List<Reviews> retrieveReviews(Long restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveReviews");
		List<Reviews> reviews = searchEngineDAO.retrieveReviews(restaurantId);
		logger.debug("Exiting from retrieveReviews");
		return reviews;
	}

	public String retrieveRestaurantActiveFlag(Long restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveRestaurantActiveFlag");
		String flag = searchEngineDAO.retrieveRestaurantActiveFlag(restaurantId);
		logger.debug("Exiting from retrieveRestaurantActiveFlag");
		return flag;
	}

	public List<MenuItemLikeDetail> retrieveLikesCount(Long restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveRestaurantActiveFlag");
		List<MenuItemLikeDetail> menuLikesCount = searchEngineDAO.retrieveLikesCount(restaurantId);
		logger.debug("Exiting from retrieveRestaurantActiveFlag");
		return menuLikesCount;
	}
	
	

}
