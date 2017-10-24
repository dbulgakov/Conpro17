package com.cyrilmarten.conf.conpro17mobile.conferences.view;

import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ConferenceData;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.FileItem;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.LectureItem;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import java.util.List;

/**
 * Created by Tetawex on 01.06.2017.
 */

public interface ConferenceBaseView extends BaseView {
    void setConferenceData(ConferenceData data);
}
