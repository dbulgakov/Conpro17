package com.cyrilmarten.conf.conpro17mobile.conferences.view.fragments;

import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceItem;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import java.util.List;

/**
 * Created by tetawex on 31.05.17.
 */

public interface ConferenceView extends BaseView {
    void setData(List<ConferenceItem> data, boolean rewriteDataSet);
}
