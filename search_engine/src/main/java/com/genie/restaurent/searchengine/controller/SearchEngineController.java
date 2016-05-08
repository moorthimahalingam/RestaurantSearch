package com.genie.restaurent.searchengine.controller;

import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@RestController
public class SearchEngineController {

	@Inject
	SearchEngineService searchEngineService;
	
	RestaurantSearchRequest request = new RestaurantSearchRequest();
	
	@RequestMapping(value="/location" , method= RequestMethod.GET)
	public String searchNearByRestaurantsByLocation(@RequestParam(value="latitude") Double latitude,
			@RequestParam(value="longtitude") Double longtitude) throws RestaurantSearchException {
		String response = searchEngineService.retrieveNearByRestaurantsByLocation(latitude, longtitude);
		return response;
	}

	
	@RequestMapping(value="/zipcode" , method=RequestMethod.GET)
	public String searchRestaurantsByZipCode(@RequestParam (value="zipcode") String zipcode) throws RestaurantSearchException {
		String response = searchEngineService.retrieveNearByRestaurantsByZipCode(zipcode);
		return response;
	}

	@RequestMapping(value="/fav_restaurant" , method=RequestMethod.GET)
	public String listFavRestaurantForCustomer(
			@RequestParam(value="customerId") String customerId) throws RestaurantSearchException {
		String response = searchEngineService.seachCustomerFavRestaurants(new Integer(customerId));
		return response;
		
	}
	
	@RequestMapping(value="/populateMenus" , method=RequestMethod.GET)
	public String retrieveMenusList(@RequestParam(value="searchText") String searchText) throws RestaurantSearchException {
		return null;
	}
	

	@RequestMapping(value="/restaurantMenu" , method=RequestMethod.GET)
	public String retrieveAllAvailableMenusForTheRestaurant(@RequestParam(value="restaurantId") Integer restaurantId) throws RestaurantSearchException {
		return null;
	}
	
	
	@RequestMapping(value="/restaurantsForAMenu" , method=RequestMethod.GET)
	public String retrieveAllRestaurantForAMenu(@RequestParam(value="menuName") String menuName) throws RestaurantSearchException {
		return null;
	}
	
	@ExceptionHandler(RestaurantSearchException.class)
	public String exceptionHandler(RestaurantSearchException exception) {
		return "Failed";
	}
}
