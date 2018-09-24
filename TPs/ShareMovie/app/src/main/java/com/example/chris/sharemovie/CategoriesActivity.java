package com.example.chris.sharemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.chris.sharemovie.adapters.CategoriesAdapter;
import com.example.chris.sharemovie.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayout backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        this.backBtn = findViewById(R.id.iconBack);
        backBtn.setOnClickListener(onClickBack);
        this.recyclerView = findViewById(R.id.category_recycler_view);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setCategories(setCategories());
        this.recyclerView.setAdapter(categoriesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    View.OnClickListener onClickBack = view -> {
        finish();
    };

    public List<Category> setCategories(){
        List<Category> categories = new ArrayList<>();

        categories.add(Category.ACTION);
        categories.add(Category.ANIMATION);
        categories.add(Category.AVENTURE);
        categories.add(Category.DANSE);
        categories.add(Category.DRAMATIQUE);
        categories.add(Category.ESPIONNAGE);
        categories.add(Category.FANTASTIQUE);
        categories.add(Category.GUERRE);
        categories.add(Category.HISTORIQUE);
        categories.add(Category.HORREUR);
        categories.add(Category.HUMOUR);
        categories.add(Category.POLICIER);
        categories.add(Category.POLITIQUE);
        categories.add(Category.ROMANTIQUE);
        categories.add(Category.THRILLER);
        categories.add(Category.WESTERN);

        this.refreshData();
        return categories;
    }

    public void refreshData() {
        if(this.recyclerView != null && this.recyclerView.getAdapter() != null) {
            this.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
