package com.jkcs.android.prishan.androidnewapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jkcs.android.prishan.androidnewapp.service.model.Project;
import com.jkcs.android.prishan.androidnewapp.service.repository.ProjectRepository;

import java.util.List;

import javax.inject.Inject;

public class ProjectListViewModel extends AndroidViewModel {

    private final LiveData<List<Project>> projectListObservable;

    @Inject
    public ProjectListViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);
        projectListObservable = projectRepository.getProjectList("Google");
    }

   /* public ProjectListViewModel(Application application) {
        super(application);

        projectListObservable = ProjectRepository.getInstance().getProjectList("Google");

    }*/

    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
