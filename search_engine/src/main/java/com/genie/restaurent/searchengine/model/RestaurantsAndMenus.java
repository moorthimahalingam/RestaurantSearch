package com.genie.restaurent.searchengine.model;

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
public class RestaurantsAndMenus {
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("machinfo")
	private String machinfo;
	@JsonProperty("cuisines")
	private List<Cuisine> cuisines = new ArrayList<Cuisine>();
	@JsonProperty("Restaurants")
	private List<Restaurant> Restaurants = new ArrayList<Restaurant>();
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The customerId
	 */
	@JsonProperty("customer_id")
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 *            The customer_id
	 */
	@JsonProperty("customer_id")
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return The machinfo
	 */
	@JsonProperty("machinfo")
	public String getMachinfo() {
		return machinfo;
	}

	/**
	 * 
	 * @param machinfo
	 *            The machinfo
	 */
	@JsonProperty("machinfo")
	public void setMachinfo(String machinfo) {
		this.machinfo = machinfo;
	}

	/**
	 * 
	 * @return The cuisines
	 */
	@JsonProperty("cuisines")
	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	/**
	 * 
	 * @param cuisines
	 *            The cuisines
	 */
	@JsonProperty("cuisines")
	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	/**
	 * 
	 * @return The Restaurants
	 */
	@JsonProperty("Restaurants")
	public List<Restaurant> getRestaurants() {
		return Restaurants;
	}

	/**
	 * 
	 * @param Restaurants
	 *            The Restaurants
	 */
	@JsonProperty("Restaurants")
	public void setRestaurants(List<Restaurant> Restaurants) {
		this.Restaurants = Restaurants;
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