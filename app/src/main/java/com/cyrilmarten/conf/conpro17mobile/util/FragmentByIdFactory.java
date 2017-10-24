package com.cyrilmarten.conf.conpro17mobile.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.ConferenceFeedFragment;

import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.ConferenceFeedFragment.CONFERENCE_FEED_FRAGMENT_TAG;

/**
 * Created by tetawex on 20.04.17.
 */

public class FragmentByIdFactory {
    public static Fragment generateFragmentForId(String fragmentTag, FragmentManager fragmentManager){
		Fragment fragment = getExistingFragment(fragmentTag, fragmentManager);
		if (fragment == null) {
			fragment = getNewFragment(fragmentTag, fragmentManager);
		}
        return fragment;

    }

    private static Fragment getNewFragment(String fragmentTag, FragmentManager fragmentManager) {
		// TODO if -> case if possible
		if (fragmentTag.equals(CONFERENCE_FEED_FRAGMENT_TAG)) {
			return ConferenceFeedFragment.newInstance();
		}
		return null;
    }

    private static Fragment getExistingFragment(String fragmentTag, FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(fragmentTag);
    }
}
