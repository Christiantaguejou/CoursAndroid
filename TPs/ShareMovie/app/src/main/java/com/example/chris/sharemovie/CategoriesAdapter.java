package com.example.chris.sharemovie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter {

    private List<Category> categories = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_category, viewGroup, false);
        CategoryViewHolder ch = new CategoryViewHolder(view);
        return ch;
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
