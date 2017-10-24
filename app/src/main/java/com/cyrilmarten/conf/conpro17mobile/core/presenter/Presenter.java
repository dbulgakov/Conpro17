package com.cyrilmarten.conf.conpro17mobile.core.presenter;

import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

public interface Presenter<V extends BaseView> {
    void onStop();
	void attachView(V view);
	void detachView();
	boolean isViewAttached();
}
