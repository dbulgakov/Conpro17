package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tetawex on 31.05.2017.
 */

public class ConferenceDataResponse {
    @SerializedName("TheConferencepostResult")
    @Expose
    private ConferenceDataUnmapped conferenceData;

    public ConferenceDataResponse(ConferenceDataUnmapped conferenceData) {
        this.conferenceData = conferenceData;
    }

    public ConferenceDataUnmapped getConferenceData() {
        return conferenceData;
    }

    public void setConferenceData(ConferenceDataUnmapped conferenceData) {
        this.conferenceData = conferenceData;
    }
}
