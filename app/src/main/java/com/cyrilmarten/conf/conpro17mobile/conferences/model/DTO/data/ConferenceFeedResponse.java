package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tetawex on 20.04.17.
 */

public class ConferenceFeedResponse {
    @SerializedName("ConferenceListpostResult")
    @Expose
    private ConferenceFeedData conferenceFeedData;
    public ConferenceFeedResponse(ConferenceFeedData conferenceFeedData){
        this.conferenceFeedData=conferenceFeedData;
    }

    public ConferenceFeedData getData() {
        return conferenceFeedData;
    }

    public void setData(ConferenceFeedData conferenceFeedData) {
        this.conferenceFeedData = conferenceFeedData;
    }
}
