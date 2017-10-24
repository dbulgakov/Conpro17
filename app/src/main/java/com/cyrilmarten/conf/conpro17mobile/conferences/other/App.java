package com.cyrilmarten.conf.conpro17mobile.conferences.other;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.cyrilmarten.conf.conpro17mobile.BuildConfig;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.AppComponent;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.AppModule;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.DaggerAppComponent;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules.MappersModule;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules.ModelModule;
import com.cyrilmarten.conf.conpro17mobile.conferences.other.di.modules.PresenterModule;

import net.danlew.android.joda.JodaTimeAndroid;

import io.fabric.sdk.android.Fabric;

public class App extends Application {
    private static AppComponent appComponent;
    private static App appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        appInstance = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        JodaTimeAndroid.init(this);
        initAppComponent();
    }

    @SuppressWarnings("deprecation")
    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .modelModule(new ModelModule(BuildConfig.GENERAL_API_HOST))
				.presenterModule(new PresenterModule())
                .mappersModule(new MappersModule())//Это нужно сюда добавлять?
                .build();
    }

    public static AppComponent getComponent() {
        return appComponent;
    }

    public static Context getContext() {
        return appInstance.getApplicationContext();
    }
}
