package com.cyrilmarten.conf.conpro17mobile.core.view.activities;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.Bundle;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication.UserAccount;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import java.io.IOException;

import static com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication.UserAccount.TYPE;

/**
 * Created by bulgakov on 10.06.17.
 */

public abstract class AuthedActivity<V extends BaseView> extends BaseActivity<V> {
    public AccountManager accountManager;

    @Override
    protected void setupViews(Bundle savedInstanceState) {
        super.setupViews(savedInstanceState);
        accountManager = AccountManager.get(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (!checkAuth()) {
            performAuth();
        }
    }

    protected boolean checkAuth() {
        return accountManager.getAccountsByType(TYPE).length > 0;
    }

    protected void performAuth() {
        accountManager.addAccount(TYPE, UserAccount.TOKEN_FULL_ACCESS, null, null, this, future -> {
            try {
                future.getResult();
            } catch (OperationCanceledException | IOException | AuthenticatorException ignored) {
                finish();
            }
        }, null);
    }

    @SuppressWarnings("deprecation")
    protected void logout() {
        Account[] accounts = accountManager.getAccounts();
        for (Account account : accounts) {
            if (account.type.equals(TYPE))
                accountManager.removeAccount(account, null, null);
        }
        performAuth();
    }
}
