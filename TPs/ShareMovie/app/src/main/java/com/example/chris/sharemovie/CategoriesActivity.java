package com.example.chris.sharemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chris.sharemovie.adapters.CategoriesAdapter;
import com.example.chris.sharemovie.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        this.recyclerView = findViewById(R.id.category_recycler_view);
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setCategories(setCategories());
        this.recyclerView.setAdapter(categoriesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Category> setCategories(){
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("Action"));
        categories.add(new Category("Aventure"));
        categories.add(new Category("Animation"));
        categories.add(new Category("Danse"));
        categories.add(new Category("Dramatique"));
        categories.add(new Category("Espionnage"));
        categories.add(new Category("Fantastique"));
        categories.add(new Category("Guerre"));
        categories.add(new Category("Historique"));
        categories.add(new Category("Horreur"));
        categories.add(new Category("Humour"));
        categories.add(new Category("Policier"));
        categories.add(new Category("Politique"));
        categories.add(new Category("Romantique"));
        categories.add(new Category("Thriller"));
        categories.add(new Category("Western"));

        this.refreshData();
        return categories;
    }

    public void refreshData() {
        if(this.recyclerView != null && this.recyclerView.getAdapter() != null) {
            this.recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
