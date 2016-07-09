package com.genie.restaurent.searchengine.service.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.genie.restaurent.searchengine.model.Menu;
import com.genie.restaurent.searchengine.model.RestaurantMenus;

public class RestaurantMenuExtractor implements ResultSetExtractor<RestaurantMenus>{

	public RestaurantMenus extractData(ResultSet rs) throws SQLException, DataAccessException {
		RestaurantMenus restaurantMenus = new RestaurantMenus();
		List<Menu> menus = new ArrayList<Menu>();
		while (rs.next()) {
			restaurantMenus.setRestaurantId(rs.getInt("RESTAURANT_ID"));
			restaurantMenus.setRestaurantName(rs.getString("RESTAURANT_NAME"));
			restaurantMenus.setCuisineId(rs.getInt("CUISINE_ID"));
			restaurantMenus.setCuisineName(rs.getString("CUISINE_NAME"));
			Menu menu = new Menu();
			menu.setItemId(rs.getInt("MENU_ITEM_ID"));
			menu.setItemName(rs.getString("MENU_ITEM_NAME"));
			menu.setItemSize(rs.getInt("MENU_ITEM_SIZE"));
			menu.setItemDescription(rs.getString("ITEM_DESCRIPTION"));
			menu.setPrice(rs.getDouble("PRICE"));
			menu.setSpecialNotes(rs.getString("SPECIAL_NOTES"));
			menu.setSpicelevelDefault(rs.getInt("SPICELEVEL_DEFAULT"));
			menu.setIsflagshipItem(rs.getInt("IS_FLAGSHIP_ITEM"));
			menu.setImageURL(rs.getString("IMAGEURL"));
			menu.setIsItemAvailable(rs.getInt("IS_ITEM_AVAILABLE"));
//			menu.setCuisineId(rs.getInt("CUISINE_ID"));
//			menu.setCuisineName(rs.getString("CUISINE_NAME"));
			menu.setCategoryId(rs.getInt("MENU_CATEGORY_ID"));
			menu.setCategoryName(rs.getString("MENU_CATEGORY_NAME"));
//			menu.setCustomerId(rs.getInt("CUST_ID"));
			menu.setLikes(rs.getInt("NUMBER_OF_LIKES"));
			menus.add(menu);
		}
		if (menus != null && menus.size() > 0) {
			restaurantMenus.setMenus(menus);
		} 
		/*else {
			restaurantMenus = null;
		}*/
		return restaurantMenus;
	}

}
