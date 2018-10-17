package com.jkcs.android.prishan.androidnewapp.di;

import android.app.Application;

import com.jkcs.android.prishan.androidnewapp.common.ApplicationController;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(ApplicationController mvvmApplication);
}
