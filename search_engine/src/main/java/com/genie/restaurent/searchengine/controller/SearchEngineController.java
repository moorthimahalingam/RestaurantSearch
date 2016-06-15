package com.genie.restaurent.searchengine.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Menu;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@RestController
public class SearchEngineController {

	@Inject
	SearchEngineService searchEngineService;

	@RequestMapping(value = "/nearbyRestaurants", method = RequestMethod.GET)
	public NearbyRestaurants searchNearByRestaurantsByLocation(@RequestParam(value = "latitude") Double latitude,
			@RequestParam(value = "longtitude") Double longtitude) throws RestaurantSearchException {

		NearbyRestaurants response = searchEngineService.retrieveNearByRestaurantsByLocation(latitude, longtitude);
		return response;
	}

	@RequestMapping(value = "/zipcodeBasedRestaurants", method = RequestMethod.GET)
	public NearbyRestaurants searchRestaurantsByZipCode(@RequestParam(value = "zipcode") String zipcode)
			throws RestaurantSearchException {
		NearbyRestaurants response = searchEngineService.retrieveNearByRestaurantsByZipCode(zipcode);
		return response;
	}

	@RequestMapping(value = "/fav_restaurant", method = RequestMethod.GET)
	public CustomerFavRestaurants listFavRestaurantForCustomer(@RequestParam(value = "customerId") String customerId)
			throws RestaurantSearchException {
		CustomerFavRestaurants favRestaurants = searchEngineService
				.seachCustomerFavRestaurants(new Integer(customerId));
		return favRestaurants;
	}

	@RequestMapping(value = "/populateMenus", method = RequestMethod.GET)
	public String retrieveMenusList(@RequestParam(value = "searchText") String searchText)
			throws RestaurantSearchException {
		return null;
	}

	@RequestMapping(value = "/restaurantMenu", method = RequestMethod.GET)
	public List<Menu> retrieveAllAvailableMenusForTheRestaurant(
			@RequestParam(value = "restaurantId") Integer restaurantId) throws RestaurantSearchException {
		
		return null;
	}

	@RequestMapping(value = "/restaurantsForAMenu", method = RequestMethod.GET)
	public String retrieveAllRestaurantForAMenu(@RequestParam(value = "menuName") String menuName)
			throws RestaurantSearchException {
		return null;
	}

	@ExceptionHandler(RestaurantSearchException.class)
	public String exceptionHandler(RestaurantSearchException exception) {
		return "Failed";
	}
}
