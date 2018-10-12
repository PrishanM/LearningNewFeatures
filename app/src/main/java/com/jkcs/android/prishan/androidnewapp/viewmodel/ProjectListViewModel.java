package com.jkcs.android.prishan.androidnewapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.jkcs.android.prishan.androidnewapp.service.model.Project;
import com.jkcs.android.prishan.androidnewapp.service.repository.ProjectRepository;

import java.util.List;

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(Application application) {
        super(application);

        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");

    }

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
