package com.genie.restaurent.searchengine.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "zipcode", "city", "state", "cuisine", "longititude", "latitude" })
@JsonIgnoreProperties(ignoreUnknown=true)
public class RestaurantSearchRequest {

	@JsonProperty("zipcode")
	private String zipcode;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("cuisine")
	private String cuisine;
	@JsonProperty("longititude")
	private Double longititude;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The zipcode
	 */
	@JsonProperty("zipcode")
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * 
	 * @param zipcode
	 *            The zipcode
	 */
	@JsonProperty("zipcode")
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * 
	 * @return The city
	 */
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The city
	 */
	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The state
	 */
	@JsonProperty("state")
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *            The state
	 */
	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return The cuisine
	 */
	@JsonProperty("cuisine")
	public String getCuisine() {
		return cuisine;
	}

	/**
	 * 
	 * @param cuisine
	 *            The cuisine
	 */
	@JsonProperty("cuisine")
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	/**
	 * 
	 * @return The longititude
	 */
	@JsonProperty("longititude")
	public Double getLongititude() {
		return longititude;
	}

	/**
	 * 
	 * @param longititude
	 *            The longititude
	 */
	@JsonProperty("longititude")
	public void setLongititude(Double longititude) {
		this.longititude = longititude;
	}

	/**
	 * 
	 * @return The latitude
	 */
	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 
	 * @param latitude
	 *            The latitude
	 */
	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
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