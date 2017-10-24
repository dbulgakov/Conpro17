package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.Model;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ConferenceDataMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ConferencePresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ConferenceBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.BasePresenter;
import com.cyrilmarten.conf.conpro17mobile.util.RxUtils;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:48 20.04.17
 */

public class ConferencePresenterImpl extends BasePresenter<ConferenceBaseView> implements ConferencePresenter {
	private final Model model;
	private final ConferenceDataMapper conferenceDataMapper;

	public ConferencePresenterImpl(Model model,
                                   ConferenceDataMapper conferenceDataMapper) {
		this.model = model;
		this.conferenceDataMapper = conferenceDataMapper;
	}

	@Override
	public void loadConferenceData(int id) {
		compositeDisposable.add(model.getConferenceData(id)
				.compose(RxUtils.applySchedulers())
				.compose(RxUtils.applyOpBeforeAndAfter(showLoading, hideLoading))
                .map(response -> conferenceDataMapper.map(response.getConferenceData()))
				.subscribe(data -> {
					if (isViewAttached()) {
						view.setConferenceData(data);
					}
				}, throwable -> {
					if (isViewAttached()) {
						view.showError(throwable);
					}
				}));
	}
}
