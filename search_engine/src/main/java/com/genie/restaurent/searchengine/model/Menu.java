package com.genie.restaurent.searchengine.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties (ignoreUnknown=true)
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("item_id")
	private Integer itemId;
	@JsonProperty("item_name")
	private String itemName;
	@JsonProperty("item_size")
	private Integer itemSize;
	@JsonProperty("item_description")
	private String itemDescription;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("special_notes")
	private String specialNotes;
	@JsonProperty("spicelevel_default")
	private Integer spicelevelDefault;
	@JsonProperty("isflagship_item")
	private Integer isflagshipItem;
	@JsonProperty("imageURL")
	private String imageURL;
	@JsonProperty("category_id")
	private Integer categoryId;
	@JsonProperty("category_name")
	private String categoryName;
	@JsonProperty("customer_id")
	private Integer customerId;
	@JsonProperty("is_item_available")
	private Integer isItemAvailable;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonProperty("cuisine_name")
	private String cuisineName;
	@JsonProperty("is_liked")
	private String isLiked;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The itemId
	 */
	@JsonProperty("item_id")
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * 
	 * @param itemId
	 *            The item_id
	 */
	@JsonProperty("item_id")
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * 
	 * @return The itemName
	 */
	@JsonProperty("item_name")
	public String getItemName() {
		return itemName;
	}

	/**
	 * 
	 * @param itemName
	 *            The item_name
	 */
	@JsonProperty("item_name")
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 
	 * @return The itemSize
	 */
	@JsonProperty("item_size")
	public Integer getItemSize() {
		return itemSize;
	}

	/**
	 * 
	 * @param itemSize
	 *            The item_size
	 */
	@JsonProperty("item_size")
	public void setItemSize(Integer itemSize) {
		this.itemSize = itemSize;
	}

	/**
	 * 
	 * @return The itemDescription
	 */
	@JsonProperty("item_description")
	public String getItemDescription() {
		return itemDescription;
	}

	/**
	 * 
	 * @param itemDescription
	 *            The item_description
	 */
	@JsonProperty("item_description")
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
	 * @return The specialNotes
	 */
	@JsonProperty("special_notes")
	public String getSpecialNotes() {
		return specialNotes;
	}

	/**
	 * 
	 * @param specialNotes
	 *            The special_notes
	 */
	@JsonProperty("special_notes")
	public void setSpecialNotes(String specialNotes) {
		this.specialNotes = specialNotes;
	}

	/**
	 * 
	 * @return The spicelevelDefault
	 */
	@JsonProperty("spicelevel_default")
	public Integer getSpicelevelDefault() {
		return spicelevelDefault;
	}

	/**
	 * 
	 * @param spicelevelDefault
	 *            The spicelevel_default
	 */
	@JsonProperty("spicelevel_default")
	public void setSpicelevelDefault(Integer spicelevelDefault) {
		this.spicelevelDefault = spicelevelDefault;
	}

	/**
	 * 
	 * @return The isflagshipItem
	 */
	@JsonProperty("isflagship_item")
	public Integer getIsflagshipItem() {
		return isflagshipItem;
	}

	/**
	 * 
	 * @param isflagshipItem
	 *            The isflagship_item
	 */
	@JsonProperty("isflagship_item")
	public void setIsflagshipItem(Integer isflagshipItem) {
		this.isflagshipItem = isflagshipItem;
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
	 * @return The categoryId
	 */
	@JsonProperty("category_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 
	 * @param categoryId
	 *            The category_id
	 */
	@JsonProperty("category_id")
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 
	 * @return The categoryName
	 */
	@JsonProperty("category_name")
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * 
	 * @param categoryName
	 *            The category_name
	 */
	@JsonProperty("category_name")
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 
	 * @return The customerId
	 */
	@JsonProperty("customer_id")
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 *            The customer_id
	 */
	@JsonProperty("customer_id")
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return The isItemAvailable
	 */
	@JsonProperty("is_item_available")
	public Integer getIsItemAvailable() {
		return isItemAvailable;
	}

	/**
	 * 
	 * @param isItemAvailable
	 *            The is_item_available
	 */
	@JsonProperty("is_item_available")
	public void setIsItemAvailable(Integer isItemAvailable) {
		this.isItemAvailable = isItemAvailable;
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
	 * @return The isLiked
	 */
	@JsonProperty("is_liked")
	public String getIsLiked() {
		return isLiked;
	}

	/**
	 * 
	 * @param isLiked
	 *            The is_liked
	 */
	@JsonProperty("is_liked")
	public void setIsLiked(String isLiked) {
		this.isLiked = isLiked;
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