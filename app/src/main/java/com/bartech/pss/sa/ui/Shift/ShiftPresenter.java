package com.bartech.pss.sa.ui.Shift;

import com.bartech.pss.sa.data.DataManager;
import com.bartech.pss.sa.ui.base.BasePresenter;
import com.bartech.pss.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 4/21/2018.
 */

public class ShiftPresenter <V extends ShiftMvpView> extends BasePresenter<V> implements ShiftMvpPresenter<V> {
    @Inject
    public ShiftPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
