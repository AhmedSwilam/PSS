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

package com.bartech.pss.sa.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bartech.pss.sa.data.network.model.BlogResponse;
import com.bartech.pss.sa.data.network.model.OpenSourceResponse;
import com.bartech.pss.sa.di.ActivityContext;
import com.bartech.pss.sa.di.PerActivity;
import com.bartech.pss.sa.ui.Shift.ShiftMvpPresenter;
import com.bartech.pss.sa.ui.Shift.ShiftMvpView;
import com.bartech.pss.sa.ui.Shift.ShiftPresenter;
import com.bartech.pss.sa.ui.about.AboutMvpPresenter;
import com.bartech.pss.sa.ui.about.AboutMvpView;
import com.bartech.pss.sa.ui.about.AboutPresenter;
import com.bartech.pss.sa.ui.feed.FeedMvpPresenter;
import com.bartech.pss.sa.ui.feed.FeedMvpView;
import com.bartech.pss.sa.ui.feed.FeedPagerAdapter;
import com.bartech.pss.sa.ui.feed.FeedPresenter;
import com.bartech.pss.sa.ui.feed.blogs.BlogAdapter;
import com.bartech.pss.sa.ui.feed.blogs.BlogMvpPresenter;
import com.bartech.pss.sa.ui.feed.blogs.BlogMvpView;
import com.bartech.pss.sa.ui.feed.blogs.BlogPresenter;
import com.bartech.pss.sa.ui.feed.opensource.OpenSourceAdapter;
import com.bartech.pss.sa.ui.feed.opensource.OpenSourceMvpPresenter;
import com.bartech.pss.sa.ui.feed.opensource.OpenSourceMvpView;
import com.bartech.pss.sa.ui.feed.opensource.OpenSourcePresenter;
import com.bartech.pss.sa.ui.login.LoginMvpPresenter;
import com.bartech.pss.sa.ui.login.LoginMvpView;
import com.bartech.pss.sa.ui.login.LoginPresenter;
import com.bartech.pss.sa.ui.main.MainMvpPresenter;
import com.bartech.pss.sa.ui.main.MainMvpView;
import com.bartech.pss.sa.ui.main.MainPresenter;
import com.bartech.pss.sa.ui.main.rating.RatingDialogMvpPresenter;
import com.bartech.pss.sa.ui.main.rating.RatingDialogMvpView;
import com.bartech.pss.sa.ui.main.rating.RatingDialogPresenter;
import com.bartech.pss.sa.ui.splash.SplashMvpPresenter;
import com.bartech.pss.sa.ui.splash.SplashMvpView;
import com.bartech.pss.sa.ui.splash.SplashPresenter;
import com.bartech.pss.sa.ui.tank.TankMvpPresenter;
import com.bartech.pss.sa.ui.tank.TankMvpView;
import com.bartech.pss.sa.ui.tank.TankPresenter;
import com.bartech.pss.sa.utils.rx.AppSchedulerProvider;
import com.bartech.pss.sa.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    TankMvpPresenter<TankMvpView> provideTankPresenter(
            TankPresenter<TankMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    ShiftMvpPresenter<ShiftMvpView> provideShiftPresenter(
            ShiftPresenter<ShiftMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
