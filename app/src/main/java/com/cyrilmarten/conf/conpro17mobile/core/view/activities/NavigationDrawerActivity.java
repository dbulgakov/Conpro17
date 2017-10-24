package com.cyrilmarten.conf.conpro17mobile.core.view.activities;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.model.authentication.UserAccount;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.MainActivity;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.activities.ProfileActivity;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.ConferenceFeedFragment;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;
import com.cyrilmarten.conf.conpro17mobile.core.view.drawerRouter.DrawerRouter;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import butterknife.BindView;

import static com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments.ConferenceFeedFragment.CONFERENCE_FEED_FRAGMENT_TAG;

/**
 * Created by bulgakov on 10.06.17.
 */

public abstract class NavigationDrawerActivity<V extends BaseView> extends AuthedActivity<V> {
    public final int ACCOUNT_INFO_ITEM_IDENTIFIER = 1;
    public final int ALL_CONFERENCES_ITEM_IDENTIFIER = 2;
    public final int EXIT_ACCOUNT_ITEM_IDENTIFIER = 3;
    public final int ABOUT_APP_ITEM_IDENTIFIER = 4;
    public final int SETTINGS_ITEM_IDENTIFIER = 5;

    @BindView(R.id.toolbar)
    public
    Toolbar toolbar;

    protected Drawer drawer;

    private DrawerRouter drawerRouter;

    private boolean drawerEnabled = true;

    @Override
    protected void setupViews(Bundle savedInstanceState) {
        super.setupViews(savedInstanceState);
        setSupportActionBar(toolbar);
        setDrawerRouter(drawerTag -> {
            switch (drawerTag) {
                case ACCOUNT_INFO_ITEM_IDENTIFIER: {
                    Intent intent = new Intent(getBaseContext(), ProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt(ProfileActivity.KEY_ID, 0);
                    bundle.putBoolean(ProfileActivity.KEY_HOME_AS_UP_ENABLED, false);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                break;
                case ALL_CONFERENCES_ITEM_IDENTIFIER: {
                    finish();
                }
                break;

                case EXIT_ACCOUNT_ITEM_IDENTIFIER:
                    logout();
                    break;
            }
        });
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (drawerEnabled) {
            initDrawer();
        }
    }

    private void initDrawer() {
        PrimaryDrawerItem account = new PrimaryDrawerItem().withIdentifier(ACCOUNT_INFO_ITEM_IDENTIFIER).withName(R.string.sidebar_item_account_info_string).withIcon(R.drawable.ic_account);
        PrimaryDrawerItem allConferencesItem = new PrimaryDrawerItem().withIdentifier(ALL_CONFERENCES_ITEM_IDENTIFIER).withName(R.string.sidebar_item_conferences_string).withIcon(R.drawable.ic_date);
        SectionDrawerItem categoryOther = new SectionDrawerItem().withName(R.string.sidebar_category_other_string);
        PrimaryDrawerItem settingsItem = new PrimaryDrawerItem().withIdentifier(SETTINGS_ITEM_IDENTIFIER).withName(R.string.sidebar_item_exit_account_string);
        PrimaryDrawerItem exitAccountItem = new PrimaryDrawerItem().withIdentifier(EXIT_ACCOUNT_ITEM_IDENTIFIER).withName(R.string.sidebar_item_exit_account_string);
        PrimaryDrawerItem aboutApp = new PrimaryDrawerItem().withIdentifier(ABOUT_APP_ITEM_IDENTIFIER).withName(R.string.sidebar_item_about_app_string);
        //noinspection ConstantConditions
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(getAccountHeader())
                .withActionBarDrawerToggleAnimated(true)
                .withSelectedItem(2)
                .withDrawerLayout(R.layout.material_drawer)
                .withTranslucentStatusBar(false)
                .withToolbar(toolbar)
                .addDrawerItems(
                        account,
                        allConferencesItem,
                        categoryOther,
                        exitAccountItem,
                        aboutApp)
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        try {
                            InputMethodManager inputMethodManager = (InputMethodManager) NavigationDrawerActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                            //noinspection ConstantConditions
                            inputMethodManager.hideSoftInputFromWindow(NavigationDrawerActivity.this.getCurrentFocus().getWindowToken(), 0);
                        } catch (Exception ignored) {
                        }
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }
                })
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    navigationDrawerItemSelected((int) drawerItem.getIdentifier());
                    return false;
                })
                .build();
    }

    private AccountHeader getAccountHeader() {
        Account[] userAccounts = accountManager.getAccountsByType(UserAccount.TYPE);
        if (userAccounts.length > 0) {
            Account userAccount = userAccounts[0];
            accountManager.getAccountsByType(UserAccount.TYPE);
            return new AccountHeaderBuilder()
                    .withActivity(this)
                    .withHeaderBackground(R.drawable.user_account_background)
                    .withSelectionListEnabledForSingleProfile(false)
                    .addProfiles(new ProfileDrawerItem().withEmail(userAccount.name).withIcon(getResources().getDrawable(R.drawable.ic_progressbar_stub)))
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void navigationDrawerItemSelected(int tag) {
        drawerRouter.route(tag);
    }

    public DrawerRouter getDrawerRouter() {
        return drawerRouter;
    }

    public void setDrawerRouter(DrawerRouter drawerRouter) {
        this.drawerRouter = drawerRouter;
    }

    public boolean isDrawerEnabled() {
        return drawerEnabled;
    }

    public void setDrawerEnabled(boolean drawerEnabled) {
        this.drawerEnabled = drawerEnabled;
    }
}
