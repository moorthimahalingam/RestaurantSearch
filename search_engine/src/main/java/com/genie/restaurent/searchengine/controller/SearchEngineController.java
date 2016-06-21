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
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@RestController
public class SearchEngineController {

	@Inject
	SearchEngineService searchEngineService;

	@RequestMapping(value = "/nearbyRestaurants", method = RequestMethod.GET)
	public RestaurantsAndMenus searchNearByRestaurantsByLocation(@RequestParam(value = "latitude") Double latitude,
			@RequestParam(value = "longtitude") Double longtitude, @RequestParam(value = "machinfo") String machInfo)
			throws RestaurantSearchException {

		RestaurantsAndMenus response = searchEngineService.retrieveNearByRestaurantsByLocation(latitude, longtitude, machInfo);
		return response;
	}

	@RequestMapping(value = "/zipcodeBasedRestaurants", method = RequestMethod.GET)
	public RestaurantsAndMenus searchRestaurantsByZipCode(@RequestParam(value = "zipcode") String zipcode,
			@RequestParam(value = "machinfo") String machInfo) throws RestaurantSearchException {
		RestaurantsAndMenus response = searchEngineService.retrieveNearByRestaurantsByZipCode(zipcode, machInfo);
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

	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public Reviews retrieveReviews(@RequestParam(value = "restaurantId") Integer restaurantId)
			throws RestaurantSearchException {
		return null;
	}

	@ExceptionHandler(RestaurantSearchException.class)
	public String exceptionHandler(RestaurantSearchException exception) {
		return "Failed";
	}
}
