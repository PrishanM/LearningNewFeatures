package com.jkcs.android.prishan.androidnewapp.view.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkcs.android.prishan.androidnewapp.R;
import com.jkcs.android.prishan.androidnewapp.databinding.FragmentProjectListBinding;
import com.jkcs.android.prishan.androidnewapp.service.model.Project;
import com.jkcs.android.prishan.androidnewapp.view.adapter.ProjectAdapter;
import com.jkcs.android.prishan.androidnewapp.view.callback.ProjectClickCallback;
import com.jkcs.android.prishan.androidnewapp.viewmodel.ProjectListViewModel;

import java.util.List;

public class ProjectListFragment extends Fragment {

    public static final String TAG = "ProjectListFragment";
    private ProjectAdapter projectAdapter;
    private FragmentProjectListBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false);

        projectAdapter = new ProjectAdapter(projectClickCallback);
        binding.projectList.setAdapter(projectAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProjectListViewModel viewModel =
                ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(ProjectListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                    binding.setIsLoading(false);
                    projectAdapter.setProjectList(projects);
                }
            }
        });
    }

    private final ProjectClickCallback projectClickCallback = new ProjectClickCallback() {
        @Override
        public void onClick(Project project) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

                Intent i = new Intent(getContext(),ProjectDetailActivity.class);
                i.putExtra("PROD_ID",project.id);
                startActivity(i);
                //((MainActivity) getActivity()).show(project);
            }
        }
    };
}
