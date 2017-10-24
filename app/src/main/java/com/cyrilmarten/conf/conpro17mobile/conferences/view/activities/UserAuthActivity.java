package com.cyrilmarten.conf.conpro17mobile.conferences.view.activities;

import android.os.Bundle;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.adapters.pager.ViewPagerAdapter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment;
import com.cyrilmarten.conf.conpro17mobile.core.other.LoginViewPager;
import com.cyrilmarten.conf.conpro17mobile.core.view.activities.AccountAuthenticatorActivity;
import com.cyrilmarten.conf.conpro17mobile.util.SharedPreferencesUtils;

import butterknife.BindView;

import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment.UserAuthFragmentType.INTRO;
import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment.UserAuthFragmentType.LOGIN;

public class UserAuthActivity extends AccountAuthenticatorActivity {

    public static final String LOGIN_ACTIVITY_TOKEN = "LOGIN_ACTIVITY_TOKEN";
    private final static int VIEW_PAGER_FIRST_RUN_POSITION = INTRO;
	private final static int VIEW_PAGER_POSITION = LOGIN;

    @BindView(R.id.view_pager)
    LoginViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

	@Override
	protected int getContentViewResId() {
		return R.layout.activity_login;
	}

	@Override
	protected void setupViews(Bundle savedInstanceState) {
		super.setupViews(savedInstanceState);
		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(viewPagerAdapter);
		viewPager.setCurrentItem(getDefaultViewPagerPosition());
	}

    public void moveToPage(@UserAuthFragment.UserAuthFragmentType int userAuthFragmentType) {
        if (userAuthFragmentType > viewPager.getAdapter().getCount()) {
            throw new IndexOutOfBoundsException("Wrong page number!");
        }

        viewPager.setCurrentItem(userAuthFragmentType);
    }

    private @UserAuthFragment.UserAuthFragmentType int getDefaultViewPagerPosition() {
		return SharedPreferencesUtils.checkIfFirstRun() ? VIEW_PAGER_FIRST_RUN_POSITION : VIEW_PAGER_POSITION;
	}

    @Override
    public void loadData() {

    }
}
