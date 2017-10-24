package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces;

import com.cyrilmarten.conf.conpro17mobile.conferences.view.ConferenceBaseView;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ConferenceFeedBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.Presenter;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:48 20.04.17
 */

public interface ConferencePresenter extends Presenter<ConferenceBaseView> {
	void loadConferenceData(int id);
}
