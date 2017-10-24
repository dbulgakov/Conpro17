package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.Model;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ConferenceFeedItemMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ConferenceFeedPresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ConferenceFeedBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.BasePresenter;
import com.cyrilmarten.conf.conpro17mobile.util.RxUtils;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:48 20.04.17
 */

public class ConferenceFeedPresenterImpl extends BasePresenter<ConferenceFeedBaseView> implements ConferenceFeedPresenter {
	private static final int DEFAULT_BATCH_SIZE = 20;
	public static final int INITIAL_OFFSET = 0;

	private final Model model;
	private final ConferenceFeedItemMapper conferenceFeedItemMapper;

	public ConferenceFeedPresenterImpl(Model model, ConferenceFeedItemMapper conferenceFeedItemMapper) {
		this.model = model;
		this.conferenceFeedItemMapper = conferenceFeedItemMapper;
	}

	@Override
	public void loadConferences(int offset) {
		compositeDisposable.add(getLoadConferencesObservable(offset)
			.compose(RxUtils.applyOpBeforeAndAfter(showLoading, hideLoading))
			.subscribe(response -> {
				if (isViewAttached()) {
					boolean rewriteDataset = offset == INITIAL_OFFSET;
					view.setData(response, rewriteDataset);
				}
			}, throwable -> {
				if (isViewAttached()) {
					view.showError(throwable);
				}
			}));
	}

	@Override
	public void loadConferencesWithoutProgressbar(int offset) {
		compositeDisposable.add(getLoadConferencesObservable(offset)
			.compose(RxUtils.applyOpAfter(hideLoading))
			.subscribe(response -> {
				if (isViewAttached()) {
					boolean rewriteDataset = offset == INITIAL_OFFSET;
					view.setData(response, rewriteDataset);
				}
			}, throwable -> {
				if (isViewAttached()) {
					view.showError(throwable);
				}
			}));
	}

	private Observable<List<ConferenceItem>> getLoadConferencesObservable(int offset) {
		return model
			.getConferenceFeed(offset)
			.compose(RxUtils.applySchedulers())
			.map(conferenceFeedResponse -> conferenceFeedItemMapper.map(conferenceFeedResponse.getData().getData()));
	}
}
