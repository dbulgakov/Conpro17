package com.cyrilmarten.conf.conpro17mobile.conferences.view.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceData;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.FileItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.LectureItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ConferencePresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ConferenceBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.view.activities.NavigationDrawerActivity;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ConferenceActivity extends NavigationDrawerActivity<ConferenceBaseView> implements ConferenceBaseView {
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_HOME_AS_UP_ENABLED = "home_as_up_enabled";
    private static final String DATE_FORMAT = "EEEE, d MMMM";
    private static final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(DATE_FORMAT);
    @Inject
    ConferencePresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.iv_conference_logo)
    ImageView ivConferenceLogo;

    @BindView(R.id.tv_conference_description)
    TextView tvConferenceDescription;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_organizer)
    TextView tvOrganizer;

    @BindView(R.id.progressbar_bg)
    View progressbarBackground;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @BindView(R.id.rv_attachments)
    RecyclerView attachmentsRecyclerView;
    @BindView(R.id.rv_lectures)
    RecyclerView lecturesRecyclerView;

    private FastItemAdapter<FileItem> attachmentsAdapter;
    private FastItemAdapter<LectureItem> lecturesAdapter;

    private int id;

    public ConferenceActivity() {
        App.getComponent().inject(this);
        setPresenter(presenter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);
        setDrawerEnabled(false);
        id = getIntent().getIntExtra(KEY_ID, 0);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        presenter.attachView(this);
    }

    @Override
    protected void setupViews(Bundle savedInstanceState) {
        super.setupViews(savedInstanceState);
        initRecyclerViews();
        setSupportActionBar(toolbar);
        collapsingToolbar.setExpandedTitleColor(getResources()
                .getColor(R.color.colorTextPrimaryLight));
        toolbar.setTitle(R.string.loading);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_conference;
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
    public void loadData() {
        presenter.loadConferenceData(id);
    }

    private void setAttachmentsData(List<FileItem> data) {
        attachmentsAdapter.clear();
        attachmentsAdapter.add(data);
    }

    private void setLecturesData(List<LectureItem> data) {
        lecturesAdapter.clear();
        lecturesAdapter.add(data);
    }

    @Override
    public void setConferenceData(ConferenceData data) {

        tvConferenceDescription.setText(data.getDescription());
        tvDate.setText(data.getDateTime().toString(dateFormatter));
        tvLocation.setText(data.getLocation());
        tvOrganizer.setText(data.getOrganizerName());
        setAttachmentsData(data.getAttachments());
        setLecturesData(data.getLectures());
        collapsingToolbar.setTitle(data.getTitle());
        Glide
                .with(context)
                .load(data.getImageUrl())
                .placeholder(R.color.colorDefaultBackground)
                .into(ivConferenceLogo);
    }

    private void initRecyclerViews() {
        attachmentsAdapter = new FastItemAdapter<>();
        attachmentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        attachmentsRecyclerView.setAdapter(attachmentsAdapter);

        lecturesAdapter = new FastItemAdapter<>();
        lecturesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lecturesRecyclerView.setAdapter(lecturesAdapter);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
