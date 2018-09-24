package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chris.sharemovie.models.Category;
import com.example.chris.sharemovie.R;

public class CategoryViewHolder extends BaseViewHolder {

    private TextView categoryNameTextView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.categoryNameTextView = itemView.findViewById(R.id.categoryName);
    }

    @Override
    public void layoutForObject(Object object) {
        super.layoutForObject(object);
        Category category = (Category) object;

        if(category != null) {
            if (categoryNameTextView != null) {
                categoryNameTextView.setText(category.getName());
            }
        }
    }
}
