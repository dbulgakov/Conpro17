package com.cyrilmarten.conf.conpro17mobile.core.other;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.UserAuthFragment;

public class LoginViewPager extends ViewPager{
    public LoginViewPager(Context context) {
        super(context);
    }

    public LoginViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @SuppressWarnings("EmptyMethod")
	public void setCurrentItem(@UserAuthFragment.UserAuthFragmentType int item) {
        super.setCurrentItem(item);
    }
}
