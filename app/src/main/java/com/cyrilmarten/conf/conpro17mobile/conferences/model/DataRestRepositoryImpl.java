package com.cyrilmarten.conf.conpro17mobile.conferences.model;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpRequest;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.api.ApiInterface;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceData;

import io.reactivex.Observable;

public class DataRestRepositoryImpl implements DataRepository {
	private final ApiInterface apiInterface;

	public DataRestRepositoryImpl(ApiInterface apiInterface) {
		this.apiInterface = apiInterface;
	}


	@Override
	public Observable<SignUpResponse> userSignUp(String userEmail, String userPassword) {
        return apiInterface
                .userSignUp(new SignUpRequest(userEmail, userPassword));
	}

	@Override
	public Observable<ConferenceFeedResponse> getConferenceFeed(int offset) {
		return apiInterface.getConferenceFeed(new ConferenceFeedRequest(getAuthToken(), offset));
	}

	@Override
	public Observable<ConferenceDataResponse> getConferenceData(int id) {
		return apiInterface.getConferenceData(new ConferenceDataRequest(getAuthToken(), id));
	}

	@Override
	public Observable<ProfileDataResponse> getProfileData(int id) {
		return apiInterface.getProfileData(new ProfileDataRequest(getAuthToken(), id));
	}
	private String getAuthToken(){
		return "UkwM/OAsNIbEH6FJAgOOaVuOeKL1EGz/n6jYE7udOYA=";
	}
}
