package com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by bulgakov on 01/05/2017.
 */

public class AccountAuthenticatorService extends Service{

	private AccountAuthenticator accountAuthenticator;

	@Override
	public void onCreate() {
		super.onCreate();
		accountAuthenticator = new AccountAuthenticator(getApplicationContext());
	}

	@Override
	public IBinder onBind(Intent intent) {
		return accountAuthenticator.getIBinder();
	}
}
