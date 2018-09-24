package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.NumberMovies;

public class NumberMovieViewHolder extends BaseViewHolder {

    TextView numberFilmTextView;

    public NumberMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.numberFilmTextView = itemView.findViewById(R.id.number_movies);
    }

    @Override
    public void layoutForObject(Object object) {
        super.layoutForObject(object);
        NumberMovies numberMovies = (NumberMovies) object;

        if(numberMovies.getNumberOfMovies() != 0) {
            if(numberFilmTextView != null){
                numberFilmTextView.setText(numberMovies.toString());
            }
        }
    }
}
