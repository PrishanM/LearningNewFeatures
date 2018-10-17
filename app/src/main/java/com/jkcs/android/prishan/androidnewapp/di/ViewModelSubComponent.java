package com.jkcs.android.prishan.androidnewapp.di;

import com.jkcs.android.prishan.androidnewapp.viewmodel.ProjectDetailViewModel;
import com.jkcs.android.prishan.androidnewapp.viewmodel.ProjectListViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder{
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
    ProjectDetailViewModel projectDetailViewModel();
}
