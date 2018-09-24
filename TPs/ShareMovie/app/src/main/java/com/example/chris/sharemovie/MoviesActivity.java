package com.example.chris.sharemovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.chris.sharemovie.adapters.MoviesAdapter;
import com.example.chris.sharemovie.models.Category;
import com.example.chris.sharemovie.models.ItemsMovieList;
import com.example.chris.sharemovie.models.LetterSeparartor;
import com.example.chris.sharemovie.models.Movie;
import com.example.chris.sharemovie.models.MoviesManager;
import com.example.chris.sharemovie.models.NumberMovies;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView categoriesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        categoriesListView = findViewById(R.id.category_list_btn);
        categoriesListView.setOnClickListener(onClickCategories);

        this.recyclerView = findViewById(R.id.movies_recycler_view);
        MoviesAdapter moviesAdapter = new MoviesAdapter();
        moviesAdapter.setItemsMovieLists(setMovies());
        this.recyclerView.setAdapter(moviesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    View.OnClickListener onClickCategories = view -> {
        Intent intent = new Intent(MoviesActivity.this, CategoriesActivity.class);
        startActivity(intent);
    };

    public List<ItemsMovieList> setMovies() {
        MoviesManager moviesManager = MoviesManager.getInstance();
        moviesManager.setContext(getApplicationContext());
        moviesManager.setup();

        return moviesManager.getItemMovies();
    }
}
