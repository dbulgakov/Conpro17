package com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules;

import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ConferenceDataMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ConferenceFeedItemMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ProfileDataMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bulgakov on 06/05/2017.
 * Last updated 17:01 06/05/2017 by bulgakov
 */

@Module
public class MappersModule {
	@Provides
	@Singleton
	public ConferenceFeedItemMapper provideConferenceFeedItemMapper() {
		return new ConferenceFeedItemMapper();
	}
	@Provides
	@Singleton
	public ProfileDataMapper provideProfileDataMapper() {
		return new ProfileDataMapper();
	}
	@Provides
	@Singleton
	public ConferenceDataMapper provideConferenceDataMapper() {
		return new ConferenceDataMapper();
	}
}
