package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations;

import android.accounts.AccountManager;
import android.os.Bundle;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.DTO.signup.SignUpResponse;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.Model;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication.UserAccount;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.UserAuthPresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.UserAuthView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.BasePresenter;
import com.cyrilmarten.conf.conpro17mobile.util.RxUtils;

/**
 * Created by bulgakov on 30/04/2017.
 */

public class UserAuthPresenterImpl extends BasePresenter<UserAuthView> implements UserAuthPresenter {

	final Model model;

	public UserAuthPresenterImpl(Model model) {
		this.model = model;
	}

	@Override
	public void performAuth(String userEmail, String userPassword) {
		compositeDisposable.add(model
			.userLogin(userEmail, userPassword)
			.compose(RxUtils.applySchedulers())
			.compose(RxUtils.applyOpBeforeAndAfter(showLoading, hideLoading))
			.subscribe(signUpResponse -> {
				if (isViewAttached()) {
					view.navigateToMainActivity(saveUserIntoBundle(signUpResponse, userEmail, userPassword));
				}
			}, throwable -> {
				if (isViewAttached()) {
					view.showError(throwable);
				}
			}));
	}

	@Override
	public void performRegistration() {
		// nothing for now
	}


	private Bundle saveUserIntoBundle(SignUpResponse signUpResponse, String userEmail, String userPassword) {
		final AccountManager accountManager = AccountManager.get(App.getContext());
		final Bundle result = new Bundle();
		UserAccount account = new UserAccount(userEmail);

		if (accountManager.addAccountExplicitly(account, userPassword, new Bundle())) {
			result.putString(AccountManager.KEY_ACCOUNT_NAME, account.name);
			result.putString(AccountManager.KEY_ACCOUNT_TYPE, account.type);
			result.putString(AccountManager.KEY_AUTHTOKEN, ""); // token will be here
			accountManager.setAuthToken(account, account.type, ""); // token will be here
		} else {
			result.putString(AccountManager.KEY_ERROR_MESSAGE, "account already exists");
		}
		return result;
	}
}
