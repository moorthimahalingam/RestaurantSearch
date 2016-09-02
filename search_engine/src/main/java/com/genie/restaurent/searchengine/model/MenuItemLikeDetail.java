package com.genie.restaurent.searchengine.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MenuItemLikeDetail  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("menu_item")
	private Integer menuItemId;
	@JsonProperty("likes")
	private Integer likes;
	
	@JsonProperty("menu_item")
	public Integer getMenuItemId() {
		return this.menuItemId;
	}
	
	@JsonProperty("menu_item")
	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}
	
	@JsonProperty("likes")
	public Integer getLikes() {
		return this.likes;
	}
	
	@JsonProperty("likes")
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	
}
