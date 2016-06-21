package com.genie.restaurent.searchengine.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	@Inject
	SearchEngineDAO searchEngineDAO;

	public CustomerFavRestaurants seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		CustomerFavRestaurants response = searchEngineDAO.listCustomerFavRestaurants(customerId);
		return response;
	}

	public RestaurantsAndMenus retrieveNearByRestaurantsByLocation(Double latitude, Double longitude, String machinfo)
			throws RestaurantSearchException {
		RestaurantsAndMenus nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByLocation(latitude, longitude,
				machinfo);
		return nearbyRestaurants;
	}

	public RestaurantsAndMenus retrieveNearByRestaurantsByZipCode(String zipCode, String machinfo)
			throws RestaurantSearchException {
		RestaurantsAndMenus nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByPostalCode(zipCode, machinfo);
		return nearbyRestaurants;
	}

	public RestaurantMenus retrieveARestaurantMenus(Integer restaurantId) throws RestaurantSearchException {
		RestaurantMenus menus = searchEngineDAO.retrieveMenusForARestaurant(restaurantId);
		return menus;
	}

	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException {
		List<Reviews> reviews = searchEngineDAO.retrieveReviews(restaurantId);
		return reviews;
	}

}
