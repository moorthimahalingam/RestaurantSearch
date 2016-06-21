package com.genie.restaurent.searchengine.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@Named
@Service
public class SearchEngineServiceImpl implements SearchEngineService {

	Logger logger = LoggerFactory.getLogger(SearchEngineServiceImpl.class);

	@Inject
	SearchEngineDAO searchEngineDAO;

	public CustomerFavRestaurants searchCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		logger.debug("Entering into searchCustomerFavRestaurants ");
		CustomerFavRestaurants response = searchEngineDAO.listCustomerFavRestaurants(customerId);
		logger.debug("Exiting from searchCustomerFavRestaurants ");
		return response;
	}

	public RestaurantsAndMenus retrieveNearByRestaurantsByLocation(Double latitude, Double longitude, String machinfo)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveNearByRestaurantsByLocation ");
		RestaurantsAndMenus nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByLocation(latitude, longitude,
				machinfo);
		logger.debug("Exiting from retrieveNearByRestaurantsByLocation ");
		return nearbyRestaurants;
	}

	public RestaurantsAndMenus retrieveNearByRestaurantsByZipCode(String zipCode, String machinfo)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveNearByRestaurantsByZipCode ");
		RestaurantsAndMenus nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByPostalCode(zipCode, machinfo);
		logger.debug("Exiting from retrieveNearByRestaurantsByZipCode ");
		return nearbyRestaurants;
	}

	public RestaurantMenus retrieveARestaurantMenus(Integer restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveARestaurantMenus ");
		RestaurantMenus menus = searchEngineDAO.retrieveMenusForARestaurant(restaurantId);
		logger.debug("Exiting from retrieveARestaurantMenus ");
		return menus;
	}

	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveReviews");
		List<Reviews> reviews = searchEngineDAO.retrieveReviews(restaurantId);
		logger.debug("Exiting from retrieveReviews");
		return reviews;
	}

}
