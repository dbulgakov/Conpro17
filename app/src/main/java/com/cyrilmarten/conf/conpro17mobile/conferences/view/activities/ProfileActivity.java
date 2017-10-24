package com.cyrilmarten.conf.conpro17mobile.conferences.view.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;
import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ProfileData;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ProfilePresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ProfileBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.view.activities.NavigationDrawerActivity;

import javax.inject.Inject;

import butterknife.BindView;

public class ProfileActivity extends NavigationDrawerActivity<ProfileBaseView> implements ProfileBaseView {
    public static final String KEY_ID="id";
    public static final String KEY_NAME="name";
    public static final String KEY_HOME_AS_UP_ENABLED="home_as_up_enabled";
    @Inject
    ProfilePresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.tv_profile_description)
    TextView tvProfileDescription;

    @BindView(R.id.iv_profile_photo)
    ImageView ivProfilePhoto;

    @BindView(R.id.progressbar_bg)
    View progressbarBackground;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private int id;
    private boolean disableBackPressButton;

    public ProfileActivity() {
        App.getComponent().inject(this);
        setPresenter(presenter);
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        disableBackPressButton = getIntent().getBooleanExtra(KEY_HOME_AS_UP_ENABLED, false);
        setDrawerEnabled(!disableBackPressButton);
        id = getIntent().getIntExtra(KEY_ID, 0);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(disableBackPressButton);
        }
    }

    @Override
    protected void setupViews(Bundle savedInstanceState) {
        super.setupViews(savedInstanceState);
        setSupportActionBar(toolbar);
        collapsingToolbar.setExpandedTitleColor(getResources()
                .getColor(R.color.colorTextPrimaryLight));
        toolbar.setTitle(R.string.loading);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_profile;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void loadData() {
        presenter.loadProfileData(id);
    }

    @Override
    public void setProfileData(ProfileData data) {
        collapsingToolbar.setTitle(data.getName());
        tvProfileDescription.setText(data.getDescription());
        Glide
                .with(context)
                .load(data.getImageUrl())
                .placeholder(R.color.colorDefaultBackground)
                .into(ivProfilePhoto);
    }
    @Override
    public void showLoading() {
        progressbarBackground.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressbarBackground.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
