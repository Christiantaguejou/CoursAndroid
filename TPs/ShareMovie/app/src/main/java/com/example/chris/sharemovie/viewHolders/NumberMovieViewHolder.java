package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.NumberMovies;

public class NumberMovieViewHolder extends RecyclerView.ViewHolder {

    TextView numberFilmTextView;

    public NumberMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.numberFilmTextView = itemView.findViewById(R.id.number_movies);
    }

    public void layoutForLetter (NumberMovies numberMovies) {
        if(numberMovies.getNumberOfMovies() != 0) {
            if(numberFilmTextView != null){
                numberFilmTextView.setText(numberMovies.toString());
            }
        }
    }
}
