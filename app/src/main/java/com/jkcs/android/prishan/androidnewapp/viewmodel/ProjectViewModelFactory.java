package com.jkcs.android.prishan.androidnewapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.util.ArrayMap;

import com.jkcs.android.prishan.androidnewapp.di.ViewModelSubComponent;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

public class ProjectViewModelFactory implements ViewModelProvider.Factory {

    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public ProjectViewModelFactory(final ViewModelSubComponent viewModelSubComponent){

        creators = new ArrayMap<>();

        creators.put(ProjectListViewModel.class, viewModelSubComponent::projectListViewModel);
        creators.put(ProjectDetailViewModel.class, viewModelSubComponent::projectDetailViewModel);
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        Callable<?extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
