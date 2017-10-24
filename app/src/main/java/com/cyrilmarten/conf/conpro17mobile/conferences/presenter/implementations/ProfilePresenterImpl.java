package com.cyrilmarten.conf.conpro17mobile.conferences.presenter.implementations;

import com.cyrilmarten.conf.conpro17mobile.conferences.model.Model;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.mappers.ProfileDataMapper;
import com.cyrilmarten.conf.conpro17mobile.conferences.presenter.interfaces.ProfilePresenter;
import com.cyrilmarten.conf.conpro17mobile.conferences.view.ProfileBaseView;
import com.cyrilmarten.conf.conpro17mobile.core.presenter.BasePresenter;
import com.cyrilmarten.conf.conpro17mobile.util.RxUtils;

/**
 * Created by tetawex on 20.04.17.
 * Last updated 17:48 20.04.17
 */

public class ProfilePresenterImpl extends BasePresenter<ProfileBaseView> implements ProfilePresenter {
    private final Model model;
    private final ProfileDataMapper mapper;

    public ProfilePresenterImpl(Model model,
                                ProfileDataMapper mapper) {
        this.model = model;
        this.mapper = mapper;
    }

    @Override
    public void loadProfileData(int id) {
        compositeDisposable.add(model.getProfileData(id)
                .compose(RxUtils.applySchedulers())
                .compose(RxUtils.applyOpBeforeAndAfter(showLoading, hideLoading))
                .map(response -> mapper.map(response.getData()))
                .subscribe(data -> {
                    if (isViewAttached()) {
                        view.setProfileData(data);
                    }
                }, throwable -> {
                    if (isViewAttached()) {
                        view.showError(throwable);
                    }
                }));
    }
}
