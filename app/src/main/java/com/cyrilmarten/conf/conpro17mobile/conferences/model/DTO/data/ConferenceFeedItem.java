package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tetawex on 02.03.2017.
 * Last updated 18:31 02.03.2017
 */

public class ConferenceFeedItem {
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String title;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("logo")
	@Expose
	private String imageUrl;
	@SerializedName("address")
	@Expose
	private String location;
	@SerializedName("start_date")
	@Expose
	private String dateTime;

	public ConferenceFeedItem(Integer id, String title, String description, String imageUrl, String location, String dateTime) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
		this.location = location;
		this.dateTime = dateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
