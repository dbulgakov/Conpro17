package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by tetawex on 31.05.17.
 */

public class ProfileData {
    private Integer id;
    private String name;
    private String description;
    private String imageUrl;

    public ProfileData() {
    }

    public ProfileData(Integer id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
