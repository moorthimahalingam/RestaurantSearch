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
	@JsonProperty("restaurant_image_url")
	private String restaurantImageUrl;
	@JsonProperty("subscribtion_code")
	private String subscribtionCode;
	@JsonProperty("minimumorder")
	private Integer minimumorder;
	@JsonProperty("delivery_fee")
	private Double deliveryFee;
	@JsonProperty("restaurant_description")
	private String restaurantDescription;
	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("pricing_category")
	private Integer pricingCategory;
	@JsonProperty("distance")
	private Double distance;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonProperty("cuisine_name")
	private String cuisineName;
	@JsonProperty("menu")
	private List<Menu> menus = new ArrayList<Menu>();
	@JsonProperty("isActive")
	private Integer activeFlag;
	
	@JsonProperty("menu")
	public List<Menu> getMenus() {
		return menus;
	}

	@JsonProperty("menu")
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

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
	 * @return The restaurantImageUrl
	 */
	@JsonProperty("restaurant_image_url")
	public String getRestaurantImageUrl() {
		return restaurantImageUrl;
	}

	/**
	 * 
	 * @param restaurantImageUrl
	 *            The restaurant_image_url
	 */
	@JsonProperty("restaurant_image_url")
	public void setRestaurantImageUrl(String restaurantImageUrl) {
		this.restaurantImageUrl = restaurantImageUrl;
	}

	/**
	 * 
	 * @return The subscribtionCode
	 */
	@JsonProperty("subscribtion_code")
	public String getSubscribtionCode() {
		return subscribtionCode;
	}

	/**
	 * 
	 * @param subscribtionCode
	 *            The subscribtion_code
	 */
	@JsonProperty("subscribtion_code")
	public void setSubscribtionCode(String subscribtionCode) {
		this.subscribtionCode = subscribtionCode;
	}

	/**
	 * 
	 * @return The minimumorder
	 */
	@JsonProperty("minimumorder")
	public Integer getMinimumorder() {
		return minimumorder;
	}

	/**
	 * 
	 * @param minimumorder
	 *            The minimumorder
	 */
	@JsonProperty("minimumorder")
	public void setMinimumorder(Integer minimumorder) {
		this.minimumorder = minimumorder;
	}

	/**
	 * 
	 * @return The deliveryFee
	 */
	@JsonProperty("delivery_fee")
	public Double getDeliveryFee() {
		return deliveryFee;
	}

	/**
	 * 
	 * @param deliveryFee
	 *            The delivery_fee
	 */
	@JsonProperty("delivery_fee")
	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	/**
	 * 
	 * @return The restaurantDescription
	 */
	@JsonProperty("restaurant_description")
	public String getRestaurantDescription() {
		return restaurantDescription;
	}

	/**
	 * 
	 * @param restaurantDescription
	 *            The restaurant_description
	 */
	@JsonProperty("restaurant_description")
	public void setRestaurantDescription(String restaurantDescription) {
		this.restaurantDescription = restaurantDescription;
	}

	/**
	 * 
	 * @return The rating
	 */
	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating
	 *            The rating
	 */
	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	/**
	 * 
	 * @return The pricingCategory
	 */
	@JsonProperty("pricing_category")
	public Integer getPricingCategory() {
		return pricingCategory;
	}

	/**
	 * 
	 * @param pricingCategory
	 *            The pricing_category
	 */
	@JsonProperty("pricing_category")
	public void setPricingCategory(Integer pricingCategory) {
		this.pricingCategory = pricingCategory;
	}

	/**
	 * 
	 * @return The distance
	 */
	@JsonProperty("distance")
	public Double getDistance() {
		return distance;
	}

	/**
	 * 
	 * @param distance
	 *            The distance
	 */
	@JsonProperty("distance")
	public void setDistance(Double distance) {
		this.distance = distance;
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

	@JsonProperty("cuisine_name")
	public String getCuisineName() {
		return cuisineName;
	}

	@JsonProperty("cuisine_name")
	public void setCuisineName(String cuisineName) {
		this.cuisineName = cuisineName;
	}

	@JsonProperty("isActive")
	public Integer getActiveFlag() {
		return activeFlag;
	}

	@JsonProperty("isActive")
	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
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