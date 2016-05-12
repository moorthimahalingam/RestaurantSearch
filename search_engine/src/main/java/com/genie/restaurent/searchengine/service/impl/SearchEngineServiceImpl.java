package com.genie.restaurent.searchengine.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.NearbyRestaurants;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;
import com.genie.restaurent.searchengine.service.SearchEngineService;

@Named
@Service
public class SearchEngineServiceImpl implements SearchEngineService {

	@Inject
	SearchEngineDAO searchEngineDAO;
	

	public String seachCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		String response = searchEngineDAO.listCustomerFavRestaurants(customerId);
		return response;
	}

	public NearbyRestaurants retrieveNearByRestaurantsByLocation(Double latitude, Double longtitude) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public NearbyRestaurants retrieveNearByRestaurantsByZipCode(String zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
