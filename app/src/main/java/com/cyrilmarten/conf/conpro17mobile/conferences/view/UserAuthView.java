package com.cyrilmarten.conf.conpro17mobile.conferences.view;

import android.os.Bundle;

import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

/**
 * Created by bulgakov on 30/04/2017.
 */

public interface UserAuthView extends BaseView{
	void navigateToLoginFragment();
	void navigateToRegisterFragment();
	void navigateToMainActivity(Bundle userInfoBundle);
}
