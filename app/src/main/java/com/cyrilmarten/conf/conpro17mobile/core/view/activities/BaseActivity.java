package com.cyrilmarten.conf.conpro17mobile.core.view.activities;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.cyrilmarten.conf.conpro17mobile.R;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.Presenter;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;
import com.mikepenz.materialize.MaterializeBuilder;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by bulgakov on 01/05/2017.
 * Last updated 20:27 01/05/2017
 */

public abstract class BaseActivity<V extends BaseView> extends AppCompatActivity implements BaseView {

	protected Context context;

	private Unbinder unbinder;

	private Presenter<V> presenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getContentViewResId());
		unbinder = ButterKnife.bind(this);
        context = this;
        setupViews(savedInstanceState);
    }

    protected abstract int getContentViewResId();

	protected void setupViews(Bundle savedInstanceState) {
	}

	protected void setPresenter(Presenter<V>  presenter) {
		this.presenter = presenter;
	}

	@Override
	public void showError(Throwable throwable) {
		Toast.makeText(this, R.string.err,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showLoading() {
	}

	@Override
	public void hideLoading() {
	}

	@Override
	public void showToast(String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showToast(int stringResId) {
		Toast.makeText(context, getText(stringResId), Toast.LENGTH_SHORT).show();
	}

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

	@Override
	public void onDestroy() {
		unbinder.unbind();
		super.onDestroy();
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

    @Override
    public void loadData() {

    }

    protected void makeTranslucentStatusBar(){
        new MaterializeBuilder()
                .withActivity(this)
                .withTintedStatusBar(false)
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
