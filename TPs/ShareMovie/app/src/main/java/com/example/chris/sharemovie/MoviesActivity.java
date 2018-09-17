package com.example.chris.sharemovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.chris.sharemovie.adapters.MoviesAdapter;
import com.example.chris.sharemovie.models.Category;
import com.example.chris.sharemovie.models.Movie;

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
        moviesAdapter.setMovies(setMovies());
        this.recyclerView.setAdapter(moviesAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Movie> setMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(getApplicationContext().getString(R.string.imitationTitle),
                                getApplicationContext().getString(R.string.imitationDescription),
                                    getApplicationContext().getDrawable(R.drawable.imitation_game),
                                        new Category("Historique")));

        return movies;
    }
}
