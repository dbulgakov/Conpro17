package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tetawex on 31.05.17.
 */

public class FileItemUnmapped {
    @SerializedName("file_id")
    @Expose
    private Integer id;
    @SerializedName("file_name")
    @Expose
    private String name;
    @SerializedName("file_description")
    @Expose
    private String description;
    @SerializedName("file_url")
    @Expose
    private String url;

    public FileItemUnmapped(Integer id, String name, String description, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
