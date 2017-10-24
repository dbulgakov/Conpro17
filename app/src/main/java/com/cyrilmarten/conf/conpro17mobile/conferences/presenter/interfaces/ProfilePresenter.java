package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces;

import com.cyrilmarten.conf.conpro17mobile.conferences.view.ProfileBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.Presenter;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:48 20.04.17
 */

public interface ProfilePresenter extends Presenter<ProfileBaseView> {
	void loadProfileData(int id);
}
