package com.jkcs.android.prishan.androidnewapp.di;

import android.arch.lifecycle.ViewModelProvider;

import com.jkcs.android.prishan.androidnewapp.service.repository.GitHubService;
import com.jkcs.android.prishan.androidnewapp.viewmodel.ProjectViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(subcomponents=ViewModelSubComponent.class)
class AppModule {

    @Singleton
    @Provides
    GitHubService provideGitHubService(){
        return new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService.class);
    }


    @Singleton
    @Provides
    ViewModelProvider.Factory factory(ViewModelSubComponent.Builder builder){

        return new ProjectViewModelFactory(builder.build());
    }
}
