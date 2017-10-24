package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tetawex on 31.05.2017.
 */

public class ProfileDataRequest {
    @SerializedName("auth_token")
    @Expose
    private String token;
    @SerializedName("id")
    @Expose
    private Integer id;

    public ProfileDataRequest(String token, Integer id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
