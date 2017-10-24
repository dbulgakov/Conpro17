
package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("TheConferencepostResult")
    @Expose
    private ConferenceDataUnmapped theConferencepostResult;

    public ConferenceDataUnmapped getTheConferencepostResult() {
        return theConferencepostResult;
    }

    public void setTheConferencepostResult(ConferenceDataUnmapped theConferencepostResult) {
        this.theConferencepostResult = theConferencepostResult;
    }

}
