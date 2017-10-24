package com.cyrilmarten.conf.conpro17mobile.conferences.view.adapters.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    // http://stackoverflow.com/questions/7951730/viewpager-and-fragments-whats-the-right-way-to-store-fragments-state - upd
    // ?????

    private final static int FRAGMENTS_NUMBER = 3;

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return UserAuthFragment.newInstance(UserAuthFragment.UserAuthFragmentType.REGISTRATION);
            case 1:
                return UserAuthFragment.newInstance(UserAuthFragment.UserAuthFragmentType.INTRO);
            case 2:
                return UserAuthFragment.newInstance(UserAuthFragment.UserAuthFragmentType.LOGIN);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
         return FRAGMENTS_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Context context = App.getContext();
        switch (position) {
            case 0:
                return context.getString(R.string.registration_fragment_title);
            case 1:
                return context.getString(R.string.app_name);
            case 2:
                return context.getString(R.string.login_fragment_title);
            default:
                return null;
        }
    }
}
