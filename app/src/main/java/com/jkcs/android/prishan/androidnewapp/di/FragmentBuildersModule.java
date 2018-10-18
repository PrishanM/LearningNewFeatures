package com.jkcs.android.prishan.androidnewapp.di;

import com.jkcs.android.prishan.androidnewapp.view.ui.ProjectDetailActivity;
import com.jkcs.android.prishan.androidnewapp.view.ui.ProjectListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();
}
