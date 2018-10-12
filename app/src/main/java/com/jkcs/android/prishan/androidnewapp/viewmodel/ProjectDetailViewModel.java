package com.jkcs.android.prishan.androidnewapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.jkcs.android.prishan.androidnewapp.service.model.Project;
import com.jkcs.android.prishan.androidnewapp.service.repository.ProjectRepository;

public class ProjectDetailViewModel extends AndroidViewModel {

    private final LiveData<Project> projectObservable;
    private final String projectID;

    public ObservableField<Project> project = new ObservableField<>();

    public ProjectDetailViewModel(@NonNull Application application,final String projectID) {
        super(application);

        this.projectID = projectID;

        projectObservable = ProjectRepository.getInstance().getProjectDetails("Google", projectID);
    }

    public LiveData<Project> getObservableProject() {
        return projectObservable;
    }

    public void setProject(Project project) {
        this.project.set(project);
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        private final String projectID;

        public Factory(@NonNull Application application, String projectID) {
            this.application = application;
            this.projectID = projectID;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ProjectDetailViewModel(application, projectID);
        }
    }
}
