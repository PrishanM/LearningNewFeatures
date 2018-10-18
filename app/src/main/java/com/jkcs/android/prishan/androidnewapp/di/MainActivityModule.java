package com.jkcs.android.prishan.androidnewapp.di;

import com.jkcs.android.prishan.androidnewapp.view.ui.MainActivity;
import com.jkcs.android.prishan.androidnewapp.view.ui.ProjectDetailActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract ProjectDetailActivity contributeProjectDetailActivity();

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
