package com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.FileItemUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.LectureItemUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataUnmapped;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceData;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.FileItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.LectureItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ProfileData;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tetawex on 31.05.17.
 */

public class ProfileDataMapper {
    public ProfileData map(ProfileDataUnmapped unmapped) {
        ProfileData data = new ProfileData();
        if (unmapped != null) {
            data.setId(unmapped.getId());
            data.setName(unmapped.getName()+" "+unmapped.getSurname());
            data.setDescription(unmapped.getDescription());
            data.setImageUrl(unmapped.getImageUrl());
        }
        return data;
    }
}
