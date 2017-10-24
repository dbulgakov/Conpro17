package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces;

import com.cyrilmarten.conf.conpro17mobile.conferences.view.UserAuthView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.Presenter;

/**
 * Created by bulgakov on 30/04/2017.
 */

public interface UserAuthPresenter extends Presenter<UserAuthView> {
	void performAuth(String userEmail, String userPassword);

	void performRegistration();
}
