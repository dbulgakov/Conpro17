package com.cyrilmarten.conf.conpro17mobile.core.view;

public interface BaseView {
    void showError(Throwable throwable);
    void showLoading();
    void hideLoading();
	void showToast(String message);
	void showToast(int stringResId);
	void loadData();
}
