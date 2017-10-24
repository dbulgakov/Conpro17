package com.cyrilmarten.conf.conpro17mobile.conferences.model;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpResponse;

import io.reactivex.Observable;

public interface DataRepository {
    Observable<SignUpResponse> userSignUp(String userEmail, String userPassword);

    Observable<ConferenceFeedResponse> getConferenceFeed(int offset);

    Observable<ConferenceDataResponse> getConferenceData(int id);

    Observable<ProfileDataResponse> getProfileData(int id);
}
