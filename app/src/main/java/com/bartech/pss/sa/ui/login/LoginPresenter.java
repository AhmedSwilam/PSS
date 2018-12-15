/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.bartech.pss.sa.ui.login;

import com.androidnetworking.error.ANError;
import com.bartech.pss.sa.R;
import com.bartech.pss.sa.data.DataManager;
import com.bartech.pss.sa.data.network.model.BranchModelResponse;
import com.bartech.pss.sa.data.network.model.CompanyModelResponse;
import com.bartech.pss.sa.data.network.model.LoginRequestt;
import com.bartech.pss.sa.data.network.model.LoginResponsePss;
import com.bartech.pss.sa.ui.base.BasePresenter;
import com.bartech.pss.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by janisharali on 27/01/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String username, String password, String company, String branch) {
        //validate username and password
        if (getMvpView()!=null){
            if (username == null && username.isEmpty()) {
                getMvpView().onError(R.string.empty_email);
                return;
            }
            if (password == null && password.isEmpty()) {
                getMvpView().onError(R.string.empty_password);
                return;
            }
            getCompositeDisposable().add(getDataManager()
                    .dooServerLoginApiCall(new LoginRequestt.ServerLoginRequestt(username, password, company, branch))
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui())
                    .subscribe(new Consumer<LoginResponsePss>() {
                        @Override
                        public void accept(LoginResponsePss responsePss) throws Exception {
                            if (responsePss.getData() != null ) {
                                getMvpView().saveLoginResponsePss(responsePss);
                                getMvpView().openShiftActivity();
                            }

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                            if (!isViewAttached()) {
                                return;
                            }

                            getMvpView().hideLoading();

                            // handle the login error here
                            if (throwable instanceof ANError) {
                                ANError anError = (ANError) throwable;
                                handleApiError(anError);
                            }
                        }
                    }));
        }

    }

    @Override
    public void getCompanyName() {
        getCompositeDisposable().add(getDataManager()
                .doServerCompanyApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<CompanyModelResponse>() {
                               @Override
                               public void accept(CompanyModelResponse companyModelResponse) throws Exception {
                                   if (companyModelResponse.getData() != null) {
                                       getMvpView().setCompanyName(companyModelResponse.getData());

                                   }

                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().hideLoading();

                                   // handle the login error here
                                   if (throwable instanceof ANError) {
                                       ANError anError = (ANError) throwable;
                                       handleApiError(anError);
                                   }

                               }
                           }
                ));


    }

    @Override
    public void getBranchName(String CompanyId) {
            getCompositeDisposable().add(getDataManager()
                    .doServerBranchApiCall()
                    .observeOn(getSchedulerProvider().ui())
                    .subscribeOn(getSchedulerProvider().io())
                    .subscribe(new Consumer<BranchModelResponse>() {
                        @Override
                        public void accept(BranchModelResponse branchModelResponse) throws Exception {
                            if (branchModelResponse.getData() != null) {
                                getMvpView().setBranchName(branchModelResponse.getData());
                            }

                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            if (!isViewAttached()) {
                                return;
                            }

                            getMvpView().hideLoading();

                            // handle the login error here
                            if (throwable instanceof ANError) {
                                ANError anError = (ANError) throwable;
                                handleApiError(anError);
                            }

                        }
                    }));

        }

    }



