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
public class Restaurant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8338887704553977662L;
	@JsonProperty("name")
	private String name;
	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("milesFromCustomerLocation")
	private Double milesFromCustomerLocation;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonProperty("Menus")
	private List<Menu> Menus = new ArrayList<Menu>();
	@JsonProperty("milesfromcurrentlocation")
	private Double milesfromcurrentlocation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

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
	 * @return The milesFromCustomerLocation
	 */
	@JsonProperty("milesFromCustomerLocation")
	public Double getMilesFromCustomerLocation() {
		return milesFromCustomerLocation;
	}

	/**
	 * 
	 * @param milesFromCustomerLocation
	 *            The milesFromCustomerLocation
	 */
	@JsonProperty("milesFromCustomerLocation")
	public void setMilesFromCustomerLocation(Double milesFromCustomerLocation) {
		this.milesFromCustomerLocation = milesFromCustomerLocation;
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
	 * @return The Menus
	 */
	@JsonProperty("Menus")
	public List<Menu> getMenus() {
		return Menus;
	}

	/**
	 * 
	 * @param Menus
	 *            The Menus
	 */
	@JsonProperty("Menus")
	public void setMenus(List<Menu> Menus) {
		this.Menus = Menus;
	}

	/**
	 * 
	 * @return The milesfromcurrentlocation
	 */
	@JsonProperty("milesfromcurrentlocation")
	public Double getMilesfromcurrentlocation() {
		return milesfromcurrentlocation;
	}

	/**
	 * 
	 * @param milesfromcurrentlocation
	 *            The milesfromcurrentlocation
	 */
	@JsonProperty("milesfromcurrentlocation")
	public void setMilesfromcurrentlocation(Double milesfromcurrentlocation) {
		this.milesfromcurrentlocation = milesfromcurrentlocation;
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