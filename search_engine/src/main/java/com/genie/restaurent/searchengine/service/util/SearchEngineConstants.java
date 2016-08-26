package com.genie.restaurent.searchengine.service.util;

public interface SearchEngineConstants {
	
	public static final String MY_LATITUDE ="mylat";
	public static final String MY_LONGITUDE ="mylon";
	public static final String DISTANCE = "dist";
	public static final String MACH_INFO = "machinfo";
	public static final String SEARCH_RESTAURANTS_BY_LAT_AND_LON="{call get_restaurant_by_distance(:mylat, :mylon, :dist)}";
	public static final String REST_SEARCH_0001= "REST_SEARCH_0001";
	public static final String REST_SEARCH_0001_DESC= "Error while retrieving restaurants based on the latitude and longitude";
	public static final String ZIPCODE = "zipcode";
	public static final String SEARCH_RESTAURANTS_BY_ZIPCODE = "{call get_zipcode_latlong(:zipcode)}";
	public static final String LATITUDE ="latitude";
	public static final String LONGITUDE ="longitude";
	public static final String REST_SEARCH_0002= "REST_SEARCH_0002";
	public static final String REST_SEARCH_0002_DESC= "Error while retrieving restaurants based on the zipcode";
	public static final String CUST_ID="cust_id";
	public static final String CUSTOMER_ID="customer_id";
	public static final String RETRIEVE_CUST_FAV_RESTAURANT="{call get_cust_fav_restaurant(:cust_id)}";
	public static final String RESTAURANT_ID="restaurantId";
	public static final String RESTAU_ID="restaurant_id";
	public static final String MENU_ITEM = "menuItem";
	public static final String MENU_NAME = "menuName";
	public static final String MENU_SEARCH_VALUE = "menu_search_val";
	public static final String RETRIEVE_RESTAURANT_MENU = "{call get_restaurant_menu(:restaurantId)}";
	public static final String MENU_AVAILABLE_RESTAURANTS = "{call get_restaurants_have_this_menu(:mylat, :mylon, :dist, :menuItem)}";
	public static final String RETRIEVE_RESTAURANT_REVIEWS = "{call get_resturant_reviews(:restaurantId)}";
	public static final String REST_SEARCH_0003= "REST_SEARCH_0003";
	public static final String REST_SEARCH_0003_DESC= "Error while retrieving customer favorite restaurants";
	public static final String REST_SEARCH_0004= "REST_SEARCH_0004";
	public static final String REST_SEARCH_0004_DESC= "Error while retrieving restaurant's menus";
	public static final String REST_SEARCH_0005= "REST_SEARCH_0005";
	public static final String REST_SEARCH_0005_DESC= "Error while retrieving menu available restaurants";
	public static final String REST_SEARCH_0006= "REST_SEARCH_0006";
	public static final String REST_SEARCH_0006_DESC= "Error while retrieving restaurant's reviews ";

	
}
