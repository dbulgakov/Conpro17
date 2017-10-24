package com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication;

import android.accounts.Account;
import android.os.Parcel;

/**
 * Created by bulgakov on 01/05/2017.
 */

public class UserAccount extends Account {
	public UserAccount(String name) {
		super(name, TYPE);
	}

	public static final String TYPE = "com.cyrilmarten.conf.conpro17mobile";

	public static final String TOKEN_FULL_ACCESS = "com.cyrilmarten.conf.conpro17mobile.TOKEN_FULL_ACCESS";

	public static final String KEY_PASSWORD = "com.cyrilmarten.conf.conpro17mobile.KEY_PASSWORD";

	public UserAccount(Parcel in) {
		super(in);
	}
}
