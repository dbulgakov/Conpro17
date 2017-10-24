package com.cyrilmarten.conf.conpro17mobile.conferences.view;

import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.data.ProfileData;
import com.cyrilmarten.conf.conpro17mobile.core.view.BaseView;

/**
 * Created by tetawex on 20.06.17.
 */

public interface ProfileBaseView extends BaseView {
    void setProfileData(ProfileData data);
}
