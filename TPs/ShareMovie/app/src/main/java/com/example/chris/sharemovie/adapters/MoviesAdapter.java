package com.example.chris.sharemovie.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.Movie;
import com.example.chris.sharemovie.viewHolders.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter {

    private List<Movie> movies = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_movie, viewGroup, false);
        MovieViewHolder vh = new MovieViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Movie currentMovie = movies.get(i);
        if (viewHolder instanceof MovieViewHolder && currentMovie != null) {
//            if(i > 0) {
//
//            }
//            else {
                MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;
                movieViewHolder.layoutForMovie(currentMovie);
//            }
        }
    }

    @Override
    public int getItemCount() {
        if(movies != null) {
            return movies.size();
        }
        return 0;
    }

    public void setMovies(List<Movie> categories) {
        this.movies = categories;
    }

}
