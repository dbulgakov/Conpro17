package com.cyrilmarten.conf.conpro17mobile.conferences.view;

import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

import java.util.List;

/**
 * Created by Tetawex on 02.03.2017.
 */

public interface ScrollFeedBaseView<T> extends BaseView {
    void requestFeedUpdate();
    void requestFeedAppend(int offset,int batchSize);
    void onFeedUpdated(List<T> data);
    void onFeedAppended(List<T> data);
}
