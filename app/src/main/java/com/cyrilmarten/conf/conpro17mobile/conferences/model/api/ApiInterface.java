package com.cyrilmarten.conf.conpro17mobile.conferences.model.api;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("authorization")
    Observable<SignUpResponse> userSignUp(@Body SignUpRequest signUpRequest);

    @POST("conferences")
    Observable<ConferenceFeedResponse> getConferenceFeed(@Body ConferenceFeedRequest request);

    @POST("conference")
    Observable<ConferenceDataResponse> getConferenceData(@Body ConferenceDataRequest request);

    @POST("user")
    Observable<ProfileDataResponse> getProfileData(@Body ProfileDataRequest request);
}
