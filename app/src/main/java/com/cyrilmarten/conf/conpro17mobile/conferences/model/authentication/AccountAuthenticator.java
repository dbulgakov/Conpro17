package com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.UserAuthActivity;

/**
 * Created by bulgakov on 01/05/2017.
 */

public class AccountAuthenticator extends AbstractAccountAuthenticator {
	private final Context context;

	public AccountAuthenticator(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public Bundle editProperties(
		AccountAuthenticatorResponse response, String accountType) {
		return null;
	}

	@Override
	public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {
		return getNavigateToLoginIntent(response, accountType);
	}

	@Override
	public Bundle confirmCredentials(
		AccountAuthenticatorResponse response,
		Account account,
		Bundle options) throws NetworkErrorException {
		return null;
	}

	@Override
	public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
		final AccountManager accountManager = AccountManager.get(App.getContext());
		String authToken = accountManager.peekAuthToken(account, authTokenType);

		Bundle result = new Bundle();

		if (!TextUtils.isEmpty(authToken)) {
			// got response, saving it
			result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
			result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
			result.putString(AccountManager.KEY_AUTHTOKEN, authToken);
		} else {
			// got no authToken, navigating to login
			result = getNavigateToLoginIntent(response, authTokenType);
		}
		return result;
	}

	private Bundle getNavigateToLoginIntent(AccountAuthenticatorResponse response, String accountType) {
		final Intent intent = new Intent(context, UserAuthActivity.class);
		final Bundle bundle = new Bundle();
		intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
		intent.putExtra(UserAuthActivity.LOGIN_ACTIVITY_TOKEN, accountType);
		bundle.putParcelable(AccountManager.KEY_INTENT, intent);
		return bundle;
	}

	@Override
	public String getAuthTokenLabel(String authTokenType) {
		return null;
	}

	@Override
	public Bundle updateCredentials(
		AccountAuthenticatorResponse response,
		Account account,
		String authTokenType,
		Bundle options) throws NetworkErrorException {
		return null;
	}

	@Override
	public Bundle hasFeatures(
		AccountAuthenticatorResponse response,
		Account account,
		String[] features) throws NetworkErrorException {
		return null;
	}
}
