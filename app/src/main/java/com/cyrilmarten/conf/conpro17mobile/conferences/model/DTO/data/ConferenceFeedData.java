package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tetawex on 29.06.17.
 */

public class ConferenceFeedData {
    @SerializedName("eventlist")
    @Expose
    private List<ConferenceFeedItem> data;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public ConferenceFeedData(List<ConferenceFeedItem> data, Integer offset) {
        this.data = data;
        this.offset = offset;
    }

    public List<ConferenceFeedItem> getData() {
        return data;
    }

    public void setData(List<ConferenceFeedItem> data) {
        this.data = data;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
