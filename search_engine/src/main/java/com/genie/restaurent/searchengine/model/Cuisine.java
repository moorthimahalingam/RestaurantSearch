package com.genie.restaurent.searchengine.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Cuisine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5418097327624474905L;
	@JsonProperty("name")
	private String name;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}