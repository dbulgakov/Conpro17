package com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.App;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ConferenceFeedPresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ConferenceFeedBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.view.fragments.BaseFragment;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.FooterAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;
import com.mikepenz.fastadapter_extensions.items.ProgressItem;
import com.mikepenz.fastadapter_extensions.scroll.EndlessRecyclerOnScrollListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations.ConferenceFeedPresenterImpl.INITIAL_OFFSET;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:07 20.04.17
 */

public class ConferenceFeedFragment extends BaseFragment<ConferenceFeedBaseView> implements ConferenceFeedBaseView {
	private FastItemAdapter<ConferenceItem> conferenceFeedAdapter;
	private FooterAdapter<ProgressItem> conferenceFeedFooterAdapter;

	public static final String CONFERENCE_FEED_FRAGMENT_TAG = ConferenceFeedFragment.class.getSimpleName();

	@Inject
	ConferenceFeedPresenter presenter;

	@BindView(R.id.recycler)
	protected RecyclerView recyclerView;


	public ConferenceFeedFragment() {
		App.getComponent().inject(this);
		setPresenter(presenter);
	}

	public static Fragment newInstance() {
		return new ConferenceFeedFragment();
	}

	@Override
	protected void setupViews(View view) {
		super.setupViews(view);
		initRecyclerView(recyclerView);

		swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadConferencesWithoutProgressbar(INITIAL_OFFSET));
	}

	@Override
	protected int getContentResId() {
		return R.layout.fragment_conference_feed;
	}

	@Override
	public void setData(List<ConferenceItem> data, boolean rewriteDataSet) {
		conferenceFeedFooterAdapter.clear();
		if (rewriteDataSet) {
			conferenceFeedAdapter.clear();
			conferenceFeedAdapter.add(data);
		} else {
			conferenceFeedAdapter.add(conferenceFeedAdapter.getAdapterItemCount(), data);
		}
	}

	private void initRecyclerView(RecyclerView recyclerView) {
		conferenceFeedAdapter = new FastItemAdapter<>();
		conferenceFeedFooterAdapter = new FooterAdapter<>();

		conferenceFeedAdapter.withOnClickListener((v, adapter, item, position) -> {
			Toast.makeText(context, item.getTitle() + " " + item.getId(), Toast.LENGTH_LONG).show();
			return false;
		});

		LinearLayoutManager layoutManager = new LinearLayoutManager(context);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setAdapter(conferenceFeedFooterAdapter.wrap(conferenceFeedAdapter));
		recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(conferenceFeedFooterAdapter) {
			@Override
			public void onLoadMore(final int currentPage) {
				Handler handler = new Handler();
				final Runnable r = () -> {
					conferenceFeedFooterAdapter.clear();
					conferenceFeedFooterAdapter.add(new ProgressItem().withEnabled(false));
					presenter.loadConferencesWithoutProgressbar(conferenceFeedAdapter.getItemCount());
				};
				handler.post(r);
			}
		});
	}

	@Override
	public void loadData() {
		// no need to load initial data if we have some in adapter
		if (conferenceFeedAdapter.getAdapterItemCount() == 0) {
			presenter.loadConferences(INITIAL_OFFSET);
		}
	}
}
