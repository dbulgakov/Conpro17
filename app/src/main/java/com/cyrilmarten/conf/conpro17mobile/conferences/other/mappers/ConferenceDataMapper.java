package com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.FileItemUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.LectureItemUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceData;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.FileItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.LectureItem;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tetawex on 31.05.17.
 */

public class ConferenceDataMapper {
    public ConferenceData map(ConferenceDataUnmapped unmapped) {
        ConferenceData conferenceData = new ConferenceData();
        if (unmapped != null) {
            /*conferenceData.setId(unmapped.getId());
            conferenceData.setTitle(unmapped.getName());
            conferenceData.setDescription(unmapped.getDescription());
            conferenceData.setImageUrl(unmapped.getImageUrl());
            conferenceData.setLocation(unmapped.getLocation());
            conferenceData.setDateTime(new DateTime(unmapped.getDateTime()));
            conferenceData.setOrganizerId(unmapped.getOrganizerId());
            conferenceData.setOrganizerName(unmapped.getOrganizerName());
            conferenceData.setAttachments(mapAttachments(unmapped.getAttachments()));
            conferenceData.setLectures(mapLectures(unmapped.getLectures()));*/
        }
        return conferenceData;
    }
    public List<LectureItem> mapLectures(List<LectureItemUnmapped> unmappedList) {
        List<LectureItem> mappedList=new ArrayList<>();
        for (LectureItemUnmapped unmapped:unmappedList) {
            LectureItem item=new LectureItem();
            if (unmapped != null) {
                item.setId(unmapped.getId());
                item.setName(unmapped.getName());
                item.setDateTimeStart(new DateTime(unmapped.getDateTimeStart()));
                item.setDateTimeEnd(new DateTime(unmapped.getDateTimeEnd()));
                item.setSpeakerName(unmapped.getSpeakerName());
                item.setDescription(unmapped.getDescription());
                item.setImageUrl(unmapped.getImageUrl());
                item.setSpeakerId(unmapped.getSpeakerId());
                mappedList.add(item);
            }
        }
        return mappedList;
    }
    public List<FileItem> mapAttachments(List<FileItemUnmapped> unmappedList) {
        List<FileItem> mappedList=new ArrayList<>();
        for (FileItemUnmapped unmapped:unmappedList) {
            FileItem item=new FileItem();
            if (unmapped != null) {
                item.setId(unmapped.getId());
                item.setDescription(unmapped.getDescription());
                item.setName(unmapped.getName());
                item.setUrl(unmapped.getUrl());
                mappedList.add(item);
            }
        }
        return mappedList;
    }
}
