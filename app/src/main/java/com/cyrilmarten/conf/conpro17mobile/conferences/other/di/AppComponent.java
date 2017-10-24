package com.cyrilmarten.conf.conpro17mobile.conferences.other.di;

import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules.MappersModule;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules.ModelModule;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules.PresenterModule;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.ConferenceActivity;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.ProfileActivity;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.ConferenceFeedFragment;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class, ModelModule.class, PresenterModule.class, MappersModule.class})
@Singleton
public interface AppComponent {
	void inject(ConferenceFeedFragment conferenceFeedFragment);

	void inject(ConferenceActivity conferenceBaseView);

	void inject(ProfileActivity profileBaseView);

	void inject(UserAuthFragment userAuthFragment);
}
