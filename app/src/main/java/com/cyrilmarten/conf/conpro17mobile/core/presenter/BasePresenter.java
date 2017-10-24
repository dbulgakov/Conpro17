package com.cyrilmarten.conf.conpro17mobile.core.presenter;

import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseView> implements Presenter<V> {
    protected final CompositeDisposable compositeDisposable;
	protected V view;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStop() {
        compositeDisposable.clear();
    }

	@Override
	public void attachView(V view) {
		this.view = view;
	}

	@Override
	public void detachView() {
		this.view = null;
	}

	@Override
	public boolean isViewAttached() {
		return view != null;
	}

	protected final Runnable showLoading = () -> {
		if (isViewAttached()) {
			view.showLoading();
		}
	};
	protected final Runnable hideLoading = () -> {
		if (isViewAttached()) {
			view.hideLoading();
		}
	};
}
