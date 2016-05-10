package com.genie.restaurent.searchengine.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3317481274629395792L;
	@JsonProperty("menu_id")
	private String menuId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("spiceLevel")
	private String spiceLevel;
	@JsonProperty("imageURL")
	private String imageURL;
	@JsonProperty("menuCategory")
	private String menuCategory;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The menuId
	 */
	@JsonProperty("menu_id")
	public String getMenuId() {
		return menuId;
	}

	/**
	 * 
	 * @param menuId
	 *            The menu_id
	 */
	@JsonProperty("menu_id")
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

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
	 * @return The description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The price
	 */
	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 *            The price
	 */
	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return The spiceLevel
	 */
	@JsonProperty("spiceLevel")
	public String getSpiceLevel() {
		return spiceLevel;
	}

	/**
	 * 
	 * @param spiceLevel
	 *            The spiceLevel
	 */
	@JsonProperty("spiceLevel")
	public void setSpiceLevel(String spiceLevel) {
		this.spiceLevel = spiceLevel;
	}

	/**
	 * 
	 * @return The imageURL
	 */
	@JsonProperty("imageURL")
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * 
	 * @param imageURL
	 *            The imageURL
	 */
	@JsonProperty("imageURL")
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * 
	 * @return The menuCategory
	 */
	@JsonProperty("menuCategory")
	public String getMenuCategory() {
		return menuCategory;
	}

	/**
	 * 
	 * @param menuCategory
	 *            The menuCategory
	 */
	@JsonProperty("menuCategory")
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
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