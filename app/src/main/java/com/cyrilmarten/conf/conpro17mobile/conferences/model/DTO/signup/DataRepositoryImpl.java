package com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ConferenceFeedResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.data.ProfileDataResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.DataRepository;

import io.reactivex.Observable;

/**
 * Created by bulgakov on 27/04/2017.
 */

public class DataRepositoryImpl implements DataRepository{

	final DataRepository dataRepository;

	public DataRepositoryImpl(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@Override
	public Observable<SignUpResponse> userSignUp(String userEmail, String userPassword) {
		return dataRepository.userSignUp(userEmail, userPassword);
	}

	@Override
	public Observable<ConferenceFeedResponse> getConferenceFeed(int offset) {
		return dataRepository.getConferenceFeed(offset);
	}

	@Override
	public Observable<ConferenceDataResponse> getConferenceData(int id) {
		return dataRepository.getConferenceData(id);
	}

	@Override
	public Observable<ProfileDataResponse> getProfileData(int id) {
		return dataRepository.getProfileData(id);
	}
}
