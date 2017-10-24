package com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.Model;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ConferenceDataMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ConferenceFeedItemMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ProfileDataMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations.ConferenceFeedPresenterImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations.ConferencePresenterImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations.ProfilePresenterImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations.UserAuthPresenterImpl;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ConferenceFeedPresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ConferencePresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ProfilePresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.UserAuthPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bulgakov on 27/04/2017.
 * Last updated 17:03 27/04/2017 by bulgakov
 */

@Module
public class PresenterModule {
	@Provides
	@Inject
	public ConferenceFeedPresenter provideConferenceFeedPresenter(Model model, ConferenceFeedItemMapper conferenceFeedItemMapper) {
		return new ConferenceFeedPresenterImpl(model, conferenceFeedItemMapper);
	}
	@Provides
	@Inject
	public ConferencePresenter provideConferencePresenter(Model model, ConferenceDataMapper conferenceDataMapper) {
		return new ConferencePresenterImpl(model,
                conferenceDataMapper);
	}
	@Provides
	@Inject
	public ProfilePresenter provideProfilePresenter(Model model, ProfileDataMapper mapper) {
		return new ProfilePresenterImpl(model,
				mapper);
	}

	@Provides
	@Inject
	public UserAuthPresenter provideUserAuthPresenter(Model model) {
		return new UserAuthPresenterImpl(model);
	}
}
