package com.jkcs.android.prishan.androidnewapp.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectViewHolder projectViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        /*final ProjectListItemBinding binding;

        public ProjectViewHolder(ProjectListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }*/
    }
}
