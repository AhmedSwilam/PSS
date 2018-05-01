package com.bartech.pss.sa.ui.tank;

import com.bartech.pss.sa.data.DataManager;
import com.bartech.pss.sa.ui.base.BasePresenter;
import com.bartech.pss.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 4/28/2018.
 */

public class TankPresenter <V extends TankMvpView> extends BasePresenter<V> implements TankMvpPresenter<V> {
    @Inject
    public TankPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
