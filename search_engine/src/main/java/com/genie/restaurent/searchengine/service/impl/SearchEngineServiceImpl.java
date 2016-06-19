package com.genie.restaurent.searchengine.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Menu;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;
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

	public NearbyRestaurants retrieveNearByRestaurantsByLocation(Double latitude, Double longitude)
			throws RestaurantSearchException {
		NearbyRestaurants nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByLocation(latitude, longitude);
		return nearbyRestaurants;
	}

	public NearbyRestaurants retrieveNearByRestaurantsByZipCode(String zipCode) throws RestaurantSearchException {
		NearbyRestaurants nearbyRestaurants = searchEngineDAO.retrieveRestaurantsByPostalCode(zipCode);
		return nearbyRestaurants;
	}

	public List<Menu> retrieveMenus(Integer restaurantId) throws RestaurantSearchException {
		List<Menu> menus = searchEngineDAO.retrieveMenus(restaurantId);
		return menus;
	}

	public List<Reviews> retrieveReviews(Integer restaurantId) throws RestaurantSearchException {
		List<Reviews> reviews = searchEngineDAO.retrieveReviews(restaurantId);
		return reviews;
	}

}
