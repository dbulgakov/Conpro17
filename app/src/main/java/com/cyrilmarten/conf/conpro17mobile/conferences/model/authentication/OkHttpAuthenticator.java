package com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication;

import android.accounts.Account;
import android.accounts.AccountManager;

import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by bulgakov on 01/05/2017.
 */

	public class OkHttpAuthenticator implements Authenticator {
	@Override
	public Request authenticate(Route route, Response response) throws IOException {
		AccountManager accountManager = AccountManager.get(App.getContext());
		Account[] accounts = accountManager.getAccountsByType(UserAccount.TYPE);

		// no account or already tried
		if (accounts.length == 0 || response.request().header("Authorization") != null) {
			return null;
		}

		Account account = accounts[0];

		try {
			final String token = accountManager.blockingGetAuthToken(account, account.type, false);
			return response.request().newBuilder().addHeader("Authorization", token).build();
		}
		catch (Exception ignored) {
			return null;
		}
	}
}
