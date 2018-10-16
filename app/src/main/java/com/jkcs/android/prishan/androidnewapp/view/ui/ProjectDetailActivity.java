package com.jkcs.android.prishan.androidnewapp.view.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jkcs.android.prishan.androidnewapp.R;
import com.jkcs.android.prishan.androidnewapp.databinding.FragmentProjectDetailsBinding;
import com.jkcs.android.prishan.androidnewapp.service.model.Project;
import com.jkcs.android.prishan.androidnewapp.viewmodel.ProjectDetailViewModel;

public class ProjectDetailActivity extends AppCompatActivity {

    private FragmentProjectDetailsBinding detailsBinding;
    ProjectDetailViewModel projectDetailViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailsBinding = DataBindingUtil.setContentView(this, R.layout.fragment_project_details);

        String projectName = getIntent().getStringExtra("PROD_NAME");

        ProjectDetailViewModel.Factory factory = new ProjectDetailViewModel.Factory(
                getApplication(), projectName);

        projectDetailViewModel = ViewModelProviders.of(this, factory)
                .get(ProjectDetailViewModel.class);

        detailsBinding.setProjectViewModel(projectDetailViewModel);
        detailsBinding.setIsLoading(true);

        observeViewModel(projectDetailViewModel);
    }

    private void observeViewModel(final ProjectDetailViewModel viewModel) {
        // Observe project data
        viewModel.getObservableProject().observe(this, new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                if (project != null) {
                    detailsBinding.setIsLoading(false);
                    viewModel.setProject(project);
                }
            }
        });
    }
}
