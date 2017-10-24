package com.cyrilmarten.conf.conpro17mobile.conferences.model;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpResponse;

import io.reactivex.Observable;

/**
 * Created by bulgakov on 27/04/2017.
 * Viciously modified by tetawex on 22/06/2017
 */

public interface Model {
	Observable<SignUpResponse> userLogin(String userEmail, String userPassword);

	Observable<ConferenceFeedResponse> getConferenceFeed(int offset);

	Observable<ConferenceDataResponse> getConferenceData(int id);

	Observable<ProfileDataResponse> getProfileData(int id);
}
