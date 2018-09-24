package com.example.chris.sharemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        this.recyclerView = findViewById(R.id.movies_recycler_view);
        MoviesAdapter moviesAdapter = new MoviesAdapter();
        moviesAdapter.setItemsMovieLists(setMovies());
        this.recyclerView.setAdapter(moviesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<ItemsMovieList> setMovies() {
        MoviesManager moviesManager = MoviesManager.getInstance();
        moviesManager.setContext(getApplicationContext());
        moviesManager.setup();

        return moviesManager.getItemMovies();
    }
}
