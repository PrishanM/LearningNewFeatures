package com.jkcs.android.prishan.androidnewapp.view.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jkcs.android.prishan.androidnewapp.R;
import com.jkcs.android.prishan.androidnewapp.databinding.FragmentProjectDetailsBinding;
import com.jkcs.android.prishan.androidnewapp.di.Injectable;
import com.jkcs.android.prishan.androidnewapp.viewmodel.ProjectDetailViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class ProjectDetailActivity extends AppCompatActivity implements Injectable {

    private FragmentProjectDetailsBinding detailsBinding;

    @Nullable
    @Inject
    ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidInjection.inject(this);

        detailsBinding = DataBindingUtil.setContentView(this, R.layout.fragment_project_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Project Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        String projectName = getIntent().getStringExtra("PROD_NAME");

        final ProjectDetailViewModel projectDetailViewModel;

        projectDetailViewModel = ViewModelProviders.of(this, factory)
                .get(ProjectDetailViewModel.class);

        projectDetailViewModel.setProjectID(projectName);
        detailsBinding.setProjectViewModel(projectDetailViewModel);
        detailsBinding.setIsLoading(true);

        observeViewModel(projectDetailViewModel);
    }

    private void observeViewModel(final ProjectDetailViewModel viewModel) {
        // Observe project data
        viewModel.getObservableProject().observe(this, project -> {
            if (project != null) {
                detailsBinding.setIsLoading(false);
                viewModel.setProject(project);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
