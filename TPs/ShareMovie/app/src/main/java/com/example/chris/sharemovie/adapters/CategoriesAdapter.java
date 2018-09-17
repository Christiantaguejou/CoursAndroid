package com.example.chris.sharemovie.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.Category;
import com.example.chris.sharemovie.viewHolders.CategoryViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter {

    private List<Category> categories = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_category, viewGroup, false);
        CategoryViewHolder vh = new CategoryViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Category currentCateg = categories.get(i);
        if (viewHolder instanceof CategoryViewHolder && currentCateg != null) {
            CategoryViewHolder categoryViewHolder = (CategoryViewHolder) viewHolder;
            categoryViewHolder.layoutForCategory(currentCateg);
        }
    }

    @Override
    public int getItemCount() {
        if (this.categories.size() != 0) {
            return this.categories.size();
        }
        return 0;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
