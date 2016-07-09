package com.genie.restaurent.searchengine.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.CustomerFavRestaurants;
import com.genie.restaurent.searchengine.model.Restaurant;
import com.genie.restaurent.searchengine.model.RestaurantMenus;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;
import com.genie.restaurent.searchengine.model.Reviews;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@RestController
public class SearchEngineController {

	@Inject
	SearchEngineService searchEngineService;

	Logger logger = LoggerFactory.getLogger(SearchEngineController.class);

	@RequestMapping(value = "/nearbyRestaurants", method = RequestMethod.GET)
	public RestaurantsAndMenus searchNearByRestaurantsByLocation(@RequestParam(value = "latitude") Double latitude,
			@RequestParam(value = "longitude") Double longitude, @RequestParam(value = "machinfo") String machInfo,
			@RequestParam(value = "customer_id", required = false) Long customerId) throws RestaurantSearchException {
		logger.debug("Entering into searchNearByRestaurantsByLocation ()");
		logger.debug("Request received from the machine {} ", machInfo);
		logger.debug("Search restaurants based on lat {} , lon {} ", latitude, longitude);
		RestaurantsAndMenus response = searchEngineService.retrieveNearByRestaurantsByLocation(latitude, longitude,
				machInfo, customerId);
		logger.debug("Restaurans around the lat {} and lon {}  are {}", latitude, longitude, response);
		logger.debug("Exiting from searchNearByRestaurantsByLocation ()");
		return response;
	}

	@RequestMapping(value = "/zipcodeBasedRestaurants", method = RequestMethod.GET)
	public RestaurantsAndMenus searchRestaurantsByZipCode(@RequestParam(value = "zipcode") String zipcode,
			@RequestParam(value = "machinfo") String machInfo, @RequestParam(value = "customer_id") Long customerId)
			throws RestaurantSearchException {
		logger.debug("Entering into searchRestaurantsByZipCode()");
		logger.debug("Request received from the machine {} ", machInfo);
		logger.debug("Search restaurants for the zipcode {}", zipcode);
		RestaurantsAndMenus response = searchEngineService.retrieveNearByRestaurantsByZipCode(zipcode, machInfo,
				customerId);
		logger.debug("Restaurants around the zipcode {} are {}", zipcode, response.toString());
		logger.debug("Exiting from searchRestaurantsByZipCode() ");
		return response;
	}

	@RequestMapping(value = "/fav_restaurant", method = RequestMethod.GET)
	public CustomerFavRestaurants listFavRestaurantForCustomer(@RequestParam(value = "customerId") Long customerId)
			throws RestaurantSearchException {
		logger.debug("Entering into listFavRestaurantForCustomer()");
		logger.debug("Favorite restaurant for the customer {} ", customerId);
		CustomerFavRestaurants favRestaurants = searchEngineService.searchCustomerFavRestaurants(customerId);
		logger.debug("Favorite Restaurants {}", favRestaurants.toString());
		logger.debug("Exiting from listFavRestaurantForCustomer()");
		return favRestaurants;
	}

	@RequestMapping(value = "/restaurantMenu", method = RequestMethod.GET)
	public RestaurantMenus retrieveAllAvailableMenusForTheRestaurant(
			@RequestParam(value = "restaurantId") Long restaurantId) throws RestaurantSearchException {
		logger.debug("Entering into retrieveAllAvailableMenusForTheRestaurant()");
		logger.debug("Before retrieve the menus for the restaurant {}", restaurantId);
		RestaurantMenus restautantMenus = searchEngineService.retrieveARestaurantMenus(restaurantId);
		if (restautantMenus != null) {
			logger.debug("After retrieve the menus for the restaurant {} are {} ", restaurantId,
					restautantMenus.toString());
		}
		logger.debug("Exiting from retrieveAllAvailableMenusForTheRestaurant()");
		return restautantMenus;
	}

	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public List<Reviews> retrieveReviews(@RequestParam(value = "restaurantId") Long restaurantId)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveReviews()");
		logger.debug("Before retrieve the reviews for the restaurant {} ", restaurantId);
		List<Reviews> reviews = searchEngineService.retrieveReviews(restaurantId);
		if (reviews != null && !reviews.isEmpty()) {
			logger.debug("After retrieve the reviews for the restaurant {} are {}", restaurantId, reviews.toString());
		}
		logger.debug("Exiting from retrieveReviews()");
		return reviews;
	}

	@RequestMapping(value = "/restaurantsForAMenu", method = RequestMethod.GET)
	public List<Restaurant> retrieveAllRestaurantsForAMenu(@RequestParam(value = "menuName") String menuName,
			@RequestParam(value = "latitude") Double latitude, @RequestParam(value = "longitude") Double longitude)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveAllRestaurantsForAMenu()");
		List<Restaurant> restaurants = searchEngineService.retrieveRestaurantsForAMenu(latitude, longitude, menuName);
		logger.debug("Exiting from retrieveAllRestaurantsForAMenu()");
		return restaurants;
	}

	@RequestMapping(value = "/populateMenus", method = RequestMethod.GET)
	public String retrieveMenusList(@RequestParam(value = "searchText") String searchText)
			throws RestaurantSearchException {
		logger.debug("Entering into retrieveMenusList()");
		logger.debug("Exiting from retrieveMenusList()");
		return null;
	}

	@ExceptionHandler(RestaurantSearchException.class)
	public String exceptionHandler(RestaurantSearchException exception) {
		return "Failed";
	}
}
