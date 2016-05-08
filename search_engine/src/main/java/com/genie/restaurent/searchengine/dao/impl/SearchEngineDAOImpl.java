package com.genie.restaurent.searchengine.dao.impl;

import org.springframework.stereotype.Repository;

import com.genie.restaurent.searchengine.dao.SearchEngineDAO;
import com.genie.restaurent.searchengine.exception.RestaurantSearchException;
import com.genie.restaurent.searchengine.model.RestaurantSearchRequest;

@Repository
public class SearchEngineDAOImpl implements SearchEngineDAO {


	public String listCustomerFavRestaurants(Integer customerId) throws RestaurantSearchException {
		return "Success";
	}

	public String retrieveRestaurantsByLocation(Double latitude, Double longitude) throws RestaurantSearchException {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieveRestaurantsByPostalCode(String PostalCode) throws RestaurantSearchException {
		// TODO Auto-generated method stub
		return null;
	}

}
