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
	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("menu_id")
	private String menuId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("size")
	private Integer size;
	@JsonProperty("special_notes")
	private String specialNotes;
	@JsonProperty("item_available")
	private String itemAvailable;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonProperty("cuisine_name")
	private String cuisineName;
	@JsonProperty("category_id")
	private Integer categoryId;
	@JsonProperty("category_name")
	private String categoryName;
	@JsonProperty("customer_id")
	private Integer customerId;
	@JsonProperty("is_liked")
	private String liked;
	@JsonProperty("description")
	private String description;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("spiceLevel")
	private String spiceLevel;
	@JsonProperty("imageURL")
	private String imageURL;
	@JsonProperty("default_spicyLevel")
	private String defaultSpicyLevel;
	@JsonProperty("isFlagshipItem")
	private String FlagshipItem;

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

	@JsonProperty("restaurant_id")
	public Integer getRestaurantId() {
		return restaurantId;
	}

	@JsonProperty("restaurant_id")
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	@JsonProperty("size")
	public Integer getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(Integer size) {
		this.size = size;
	}

	@JsonProperty("special_notes")
	public String getSpecialNotes() {
		return specialNotes;
	}
	
	@JsonProperty("special_notes")
	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}

	@JsonProperty("item_available")
	public String getItemAvailable() {
		return itemAvailable;
	}

	@JsonProperty("item_available")
	public void setItemAvailable(String itemAvailable) {
		this.itemAvailable = itemAvailable;
	}

	@JsonProperty("cuisine_id")
	public Integer getCuisineId() {
		return cuisineId;
	}

	@JsonProperty("cuisine_id")
	public void setCuisineId(Integer cuisineId) {
		this.cuisineId = cuisineId;
	}

	@JsonProperty("cuisine_name")
	public String getCuisineName() {
		return cuisineName;
	}

	@JsonProperty("cuisine_name")
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	@JsonProperty("category_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	@JsonProperty("category_id")
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@JsonProperty("category_name")
	public String getCategoryName() {
		return categoryName;
	}

	@JsonProperty("category_name")
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonProperty("customer_id")
	public Integer getCustomerId() {
		return customerId;
	}

	@JsonProperty("customer_id")
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("is_liked")
	public String getLiked() {
		return liked;
	}

	@JsonProperty("is_liked")
	public void setLiked(String liked) {
		this.liked = liked;
	}

	@JsonProperty("default_spicyLevel")
	public String getDefaultSpicyLevel() {
		return defaultSpicyLevel;
	}

	@JsonProperty("default_spicyLevel")
	public void setDefaultSpicyLevel(String defaultSpicyLevel) {
		this.defaultSpicyLevel = defaultSpicyLevel;
	}

	@JsonProperty("isFlagshipItem")
	public String getFlagshipItem() {
		return FlagshipItem;
	}

	@JsonProperty("isFlagshipItem")
	public void setFlagshipItem(String flagshipItem) {
		FlagshipItem = flagshipItem;
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