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
	
//	{allpossible} means combination/probablity of zipcode+city+cuisine but this should be always in this sequence
	
	@RequestMapping(value="/search/{allpossible}")
	public String searchRestaurantsByAllPossibleWay(RestaurantSearchRequest request , BindingResult result) throws RestaurantSearchException {
		String response = searchEngineService.searchRestaurants(request);
		return response;
	}
	
	@RequestMapping(value="/searchbyzipcode" , method=RequestMethod.GET)
	public String searchRestaurantsByZipCode(@RequestParam (value="zipcode") String zipcode) throws RestaurantSearchException {
		String response = searchEngineService.searchRestaurants(request);
		return response;
	}
	
	@RequestMapping(value="/searchsbycity" , method=RequestMethod.GET)
	public String searchRestaurantByCity(@RequestParam (value="city") String city) throws RestaurantSearchException {
		String response = searchEngineService.searchRestaurants(request);
		return response;
	}
	
	@RequestMapping(value="/searchbycuisine" , method=RequestMethod.GET)
	public String searchRestaurantsByCuisine(@RequestParam (value="cuisine") String cuisine) throws RestaurantSearchException {
		String response = searchEngineService.searchRestaurants(request);
		return response;
	}
	
	@RequestMapping(value="/searchbylocation" , method=RequestMethod.GET)
	public String searchRestaurantsByLocation(@RequestParam (value="longtitude") String longtitude, 
			@RequestParam (value="latitude") String latitude) throws RestaurantSearchException {
		String response = searchEngineService.searchRestaurants(request);
		return response;
	}
	

	@RequestMapping(value="/fav_restaurant" , method=RequestMethod.GET)
	public String listFavRestaurantForCustomer(
			@RequestParam(value="customerId") String customerId) throws RestaurantSearchException {
		String response = searchEngineService.seachCustomerFavRestaurants(new Integer(customerId));
		return response;
		
	}

	
	@ExceptionHandler(RestaurantSearchException.class)
	public String exceptionHandler(RestaurantSearchException exception) {
		return "Failed";
	}
}
