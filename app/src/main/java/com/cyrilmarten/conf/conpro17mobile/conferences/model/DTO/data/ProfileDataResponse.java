package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tetawex on 31.05.2017.
 */

public class ProfileDataResponse {
    @SerializedName("UserpostResult")
    @Expose
    private ProfileDataUnmapped data;

    public ProfileDataResponse(ProfileDataUnmapped data) {
        this.data = data;
    }

    public ProfileDataUnmapped getData() {
        return data;
    }

    public void setData(ProfileDataUnmapped data) {
        this.data = data;
    }
}
