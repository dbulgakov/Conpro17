package com.cyrilmarten.conf.conpro17mobile.core.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Toast;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.Presenter;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by bulgakov on 26/04/2017.
 */

public abstract class BaseFragment<V extends BaseView> extends Fragment implements BaseView {
	@BindView(R.id.swipe_refresh_layout)
	protected SwipeRefreshLayout swipeRefreshLayout;

	@BindView(R.id.progressbar)
	protected View progressbar;

	protected Context context;

	private Unbinder unbinder;

	private Presenter<V> presenter;

	protected void setPresenter(Presenter<V>  presenter) {
		this.presenter = presenter;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setupViews(view);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(getLayoutId(), container, false);
	}

	protected void setupViews(View view) {
		context = view.getContext();
		ViewStub stub = (ViewStub) view.findViewById(R.id.content_placeholder);
		inflateViewStub(stub);
		unbinder = ButterKnife.bind(this, view);
	}

	@Override
	public void showError(Throwable throwable) {
		// impl coming soon
	}

	@Override
	public void showLoading() {
		show(progressbar);
	}

	@Override
	public void hideLoading() {
		hide(progressbar);
		swipeRefreshLayout.setRefreshing(false);
	}

	@Override
	public void showToast(String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showToast(int stringResId) {
		Toast.makeText(context, getText(stringResId), Toast.LENGTH_SHORT).show();
	}

	protected abstract int getContentResId();

	protected int getLayoutId() {
		return R.layout.base_view;
	}

	private void show(View view) {
		if (view != null) {
			view.setVisibility(View.VISIBLE);
		}
	}

	private void hide(View view) {
		if (view != null) {
			view.setVisibility(View.GONE);
		}
	}

	private void inflateViewStub(ViewStub viewStub) {
		if (viewStub != null) {
			viewStub.setLayoutResource(getContentResId());
			viewStub.inflate();
		}
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}


	@Override
	public void onResume() {
		super.onResume();
		if (presenter != null) {
			//noinspection unchecked
			presenter.attachView((V) this);
		}
		loadData();
	}

	@Override
	public void onPause() {
		super.onPause();
		if (presenter != null) {
			presenter.detachView();
		}
	}
}
