package com.cyrilmarten.conf.conpro17mobile.conferences.view;

import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceItem;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import java.util.List;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:48 20.04.17
 */

public interface ConferenceFeedBaseView extends BaseView {
    void setData(List<ConferenceItem> data, boolean rewriteDataSet);
}
