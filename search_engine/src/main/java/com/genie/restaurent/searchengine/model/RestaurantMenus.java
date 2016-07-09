package com.genie.restaurent.searchengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantMenus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("restaurant_name")
	private String restaurantName;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonProperty("cuisine_name")
	private String cuisineName;
	@JsonProperty("Menus")
	private List<Menu> menus = new ArrayList<Menu>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The restaurantId
	 */
	@JsonProperty("restaurant_id")
	public Integer getRestaurantId() {
		return restaurantId;
	}

	/**
	 * 
	 * @param restaurantId
	 *            The restaurant_id
	 */
	@JsonProperty("restaurant_id")
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * 
	 * @return The restaurantName
	 */
	@JsonProperty("restaurant_name")
	public String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * 
	 * @param restaurantName
	 *            The restaurant_name
	 */
	@JsonProperty("restaurant_name")
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	/**
	 * 
	 * @return The cuisineId
	 */
	@JsonProperty("cuisine_id")
	public Integer getCuisineId() {
		return cuisineId;
	}

	/**
	 * 
	 * @param cuisineId
	 *            The cuisine_id
	 */
	@JsonProperty("cuisine_id")
	public void setCuisineId(Integer cuisineId) {
		this.cuisineId = cuisineId;
	}

	/**
	 * 
	 * @return The cuisineName
	 */
	@JsonProperty("cuisine_name")
	public String getCuisineName() {
		return cuisineName;
	}

	/**
	 * 
	 * @param cuisineName
	 *            The cuisine_name
	 */
	@JsonProperty("cuisine_name")
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	/**
	 * 
	 * @return The menus
	 */
	@JsonProperty("Menus")
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * 
	 * @param menus
	 *            The Menus
	 */
	@JsonProperty("Menus")
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
