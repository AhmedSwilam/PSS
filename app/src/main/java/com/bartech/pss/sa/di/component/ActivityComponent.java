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

package com.bartech.pss.sa.di.component;

import com.bartech.pss.sa.di.PerActivity;
import com.bartech.pss.sa.di.module.ActivityModule;
import com.bartech.pss.sa.ui.Shift.ShiftActivity;
import com.bartech.pss.sa.ui.about.AboutFragment;
import com.bartech.pss.sa.ui.feed.FeedActivity;
import com.bartech.pss.sa.ui.feed.blogs.BlogFragment;
import com.bartech.pss.sa.ui.feed.opensource.OpenSourceFragment;
import com.bartech.pss.sa.ui.login.LoginActivity;
import com.bartech.pss.sa.ui.main.MainActivity;
import com.bartech.pss.sa.ui.main.rating.RateUsDialog;
import com.bartech.pss.sa.ui.splash.SplashActivity;
import com.bartech.pss.sa.ui.tank.TankActivity;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

    void inject(ShiftActivity shiftActivity);

    void inject(TankActivity tankActivity);
}
