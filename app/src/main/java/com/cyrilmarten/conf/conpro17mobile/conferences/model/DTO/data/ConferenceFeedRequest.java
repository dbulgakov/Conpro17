package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tetawex on 02.03.2017.
 */

public class ConferenceFeedRequest {
    @SerializedName("auth_token")
    @Expose
    private String token;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public ConferenceFeedRequest(String token, Integer offset) {
        this.token = token;
        this.offset = offset;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
