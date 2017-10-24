package com.cyrilmarten.conf.conpro17mobile.conferences.model;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ModelImpl implements Model {

	final DataRepository dataRepository;

	public ModelImpl(DataRepository restRepository) {
		this.dataRepository = restRepository;
	}

	@Override
	public Observable<SignUpResponse> userLogin(String userEmail, String userPassword) {
		return dataRepository
			.userSignUp(userEmail, userPassword);
	}

	@Override
	public Observable<ConferenceFeedResponse> getConferenceFeed(int offset) {
		return dataRepository
			.getConferenceFeed(offset);
	}

	public Observable<ConferenceDataResponse> getConferenceData(int id) {
		return dataRepository
				.getConferenceData(id);
	}
	@Override
	public Observable<ProfileDataResponse> getProfileData(int id) {
		return dataRepository
				.getProfileData(id);
	}
}
