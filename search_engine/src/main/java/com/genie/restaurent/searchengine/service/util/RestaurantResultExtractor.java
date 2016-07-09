package com.genie.restaurent.searchengine.service.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.genie.restaurent.searchengine.model.Cuisine;
import com.genie.restaurent.searchengine.model.Menu;
import com.genie.restaurent.searchengine.model.Restaurant;
import com.genie.restaurent.searchengine.model.RestaurantsAndMenus;


public class RestaurantResultExtractor implements ResultSetExtractor<RestaurantsAndMenus> {

	public RestaurantsAndMenus extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		List<Cuisine> cuisines = new ArrayList<Cuisine>();
		while (rs.next()) {
			Restaurant restaurant = new Restaurant();
			Cuisine cuisine = new Cuisine();
			restaurant.setRestaurantId(rs.getInt("RESTAURANT_ID"));
			restaurant.setName(rs.getString("RESTAURANT_NAME"));
			cuisine.setCuisineId(rs.getInt("CUISINE_ID"));
			cuisine.setName(rs.getString("CUISINE_NAME"));
			restaurant.setCuisineId(rs.getInt("CUISINE_ID"));
			restaurant.setCuisineName(rs.getString("CUISINE_NAME"));
			restaurant.setRating(rs.getInt("RATING"));
			restaurant.setPricingCategory(rs.getInt("PRICING_CATEGORY"));
			restaurant.setDeliveryFee(rs.getDouble("DELIVERY_FEE"));
			restaurant.setDistance(rs.getDouble("DISTANCE"));
			restaurant.setMinimumorder(rs.getDouble("MINIMUM_ORDER_VAL_DELIVERY"));
			restaurant.setWebsite(rs.getString("RESTAURANT_WEBSITE"));
			restaurant.setOpeningTime(rs.getTime("RESTAURANT_OPENINGTIME"));
			restaurant.setClosingTime(rs.getTime("RESTAURANT_CLOSINGTIME"));
			restaurant.setBaseDeliveryTime(rs.getTime("BASE_DELIVERY_TIME"));
			String menuItems = rs.getString("MENU_ITEMS");
			if (menuItems != null && menuItems.trim().length() > 0) {
				List <Menu> restaurantMenus = new ArrayList<Menu>();
				List<String> menulist = Arrays.asList(rs.getString("MENU_ITEMS").split(","));
				for (String menu : menulist) {
					Menu restaurantMenu = new Menu();
					List<String> menuDetails = Arrays.asList(menu.split(":"));
					restaurantMenu.setItemId(Integer.getInteger(menuDetails.get(0)));
					restaurantMenu.setItemName(menuDetails.get(1));
					restaurantMenus.add(restaurantMenu);
					restaurantMenu = null;
				}
				restaurant.setMenus(restaurantMenus);
			}
			restaurants.add(restaurant);
			cuisines.add(cuisine);
		}
		RestaurantsAndMenus restaurantsAndMenus = null;
		if (restaurants != null && restaurants.size() > 0) {
			restaurantsAndMenus = new RestaurantsAndMenus();
			restaurantsAndMenus.setCuisines(cuisines);
			restaurantsAndMenus.setRestaurants(restaurants);
		}
		return restaurantsAndMenus;
	}
	
}

