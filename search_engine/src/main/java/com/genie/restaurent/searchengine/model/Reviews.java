package com.genie.restaurent.searchengine.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Reviews implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("customer_review_id")
	private Integer customerReviewId;
	@JsonProperty("cust_id")
	private Integer custId;
	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("order_id")
	private Integer orderId;
	@JsonProperty("review_title")
	private String reviewTitle;
	@JsonProperty("review_desc")
	private String reviewDesc;
	@JsonProperty("rating")
	private Integer rating;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The customerReviewId
	 */
	@JsonProperty("customer_review_id")
	public Integer getCustomerReviewId() {
		return customerReviewId;
	}

	/**
	 * 
	 * @param customerReviewId
	 *            The customer_review_id
	 */
	@JsonProperty("customer_review_id")
	public void setCustomerReviewId(Integer customerReviewId) {
		this.customerReviewId = customerReviewId;
	}

	/**
	 * 
	 * @return The custId
	 */
	@JsonProperty("cust_id")
	public Integer getCustId() {
		return custId;
	}

	/**
	 * 
	 * @param custId
	 *            The cust_id
	 */
	@JsonProperty("cust_id")
	public void setCustId(Integer custId) {
		this.custId = custId;
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
	 * @return The orderId
	 */
	@JsonProperty("order_id")
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId
	 *            The order_id
	 */
	@JsonProperty("order_id")
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 
	 * @return The reviewTitle
	 */
	@JsonProperty("review_title")
	public String getReviewTitle() {
		return reviewTitle;
	}

	/**
	 * 
	 * @param reviewTitle
	 *            The review_title
	 */
	@JsonProperty("review_title")
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	/**
	 * 
	 * @return The reviewDesc
	 */
	@JsonProperty("review_desc")
	public String getReviewDesc() {
		return reviewDesc;
	}

	/**
	 * 
	 * @param reviewDesc
	 *            The review_desc
	 */
	@JsonProperty("review_desc")
	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}