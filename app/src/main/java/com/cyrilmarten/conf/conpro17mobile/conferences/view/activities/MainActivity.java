package com.cyrilmarten.conf.conpro17mobile.conferences.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseActivityView;
import com.cyrilmarten.conf.conpro17mobile.core.view.activities.NavigationDrawerActivity;
import com.cyrilmarten.conf.conpro17mobile.core.view.drawerRouter.DrawerRouter;
import com.cyrilmarten.conf.conpro17mobile.util.FragmentByIdFactory;


import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.ConferenceFeedFragment.CONFERENCE_FEED_FRAGMENT_TAG;

public class MainActivity extends NavigationDrawerActivity<BaseActivityView> implements BaseActivityView {
    public static final String FRAGMENT_TAG="fragment_tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setDrawerRouter(drawerTag -> {
            switch (drawerTag) {
                case ACCOUNT_INFO_ITEM_IDENTIFIER:
                    Intent intent = new Intent(getBaseContext(),ProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt(ProfileActivity.KEY_ID,0);
                    bundle.putBoolean(ProfileActivity.KEY_HOME_AS_UP_ENABLED,true);
                    startActivity(intent);
                    break;
                case ALL_CONFERENCES_ITEM_IDENTIFIER:
                    switchFragment(CONFERENCE_FEED_FRAGMENT_TAG);
                    break;
                case EXIT_ACCOUNT_ITEM_IDENTIFIER:
                    logout();
                    break;
            }
        });
        //Switch to default if there is no fragment specified
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            if(bundle.getString(FRAGMENT_TAG)!=null)
                switchFragment(bundle.getString(FRAGMENT_TAG));
            else
                switchFragment(CONFERENCE_FEED_FRAGMENT_TAG);
        }
        else
            switchFragment(CONFERENCE_FEED_FRAGMENT_TAG);
		makeTranslucentStatusBar();
    }

    @Override
    protected void setupViews(Bundle savedInstanceState) {
        super.setupViews(savedInstanceState);
		toolbar.setTitle(R.string.conferences_all);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void switchFragment(String fragmentTag) {
		FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = FragmentByIdFactory.generateFragmentForId(fragmentTag, fragmentManager);
        fragmentManager.beginTransaction().replace(R.id.content_main, fragment, fragmentTag).commit();
    }

}
