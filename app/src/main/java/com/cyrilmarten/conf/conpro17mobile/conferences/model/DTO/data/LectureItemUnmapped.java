package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by tetawex on 31.05.17.
 */

public class LectureItemUnmapped {
    @SerializedName("report_id")
    @Expose
    private Integer id;
    @SerializedName("...")
    @Expose
    private String imageUrl;
    @SerializedName("report_name")
    @Expose
    private String name;
    @SerializedName("report_description")
    @Expose
    private String description;
    @SerializedName("reporter_name")
    @Expose
    private String speakerName;
    @SerializedName("reporter_userID")
    @Expose
    private Integer speakerId;
    @SerializedName("report_start_date")
    @Expose
    private String dateTimeStart;
    @SerializedName("report_end_date")
    @Expose
    private String dateTimeEnd;

    public LectureItemUnmapped(Integer id,
                               String imageUrl,
                               String name,
                               String description,
                               Integer speakerId,
                               String speakerName,
                               String dateTimeStart,
                               String dateTimeEnd) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
        this.speakerId=speakerId;
        this.speakerName = speakerName;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(String dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public String getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(String dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public Integer getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Integer speakerId) {
        this.speakerId = speakerId;
    }
}
