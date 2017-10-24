package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by tetawex on 31.05.17.
 */

public class ConferenceData {
    private Integer id;
    private Integer organizerId;
    private String title;
    private String organizerName;
    private String description;
    private String imageUrl;
    private String location;
    private DateTime dateTime;
    private List<FileItem> attachments;
    private List<LectureItem> lectures;

    public ConferenceData() {
    }

    public ConferenceData(Integer id,
                          Integer organizerId,
                          String organizerName,
                          String title,
                          String description,
                          String imageUrl,
                          String location,
                          DateTime dateTime,
                          List<FileItem> attachments,
                          List<LectureItem> lectures) {
        this.id = id;
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
        this.dateTime = dateTime;
        this.attachments=attachments;
        this.lectures=lectures;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
    public void setAttachments(List<FileItem> attachments) {
        this.attachments = attachments;
    }

    public List<LectureItem> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureItem> lectures) {
        this.lectures = lectures;
    }

    public List<FileItem> getAttachments() {
        return attachments;
    }
}
