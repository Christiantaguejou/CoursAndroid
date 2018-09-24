package com.example.chris.sharemovie.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.Movie;

public class MovieViewHolder extends BaseViewHolder{

    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.movie_image);
        this.titleTextView = itemView.findViewById(R.id.list_movie_title);
        this.descriptionTextView = itemView.findViewById(R.id.list_movie_description);
    }

    @Override
    public void layoutForObject(Object object) {
        super.layoutForObject(object);
        Movie movie = (Movie) object;

        if(movie.getImage() != null) {
            if(imageView != null){
                imageView.setImageDrawable(movie.getImage());
            }
        }
        if(movie.getTitle() != null) {
            if(titleTextView != null){
                titleTextView.setText(movie.getTitle());
            }
        }
        if(movie.getDescrpition() != null) {
            if(descriptionTextView != null){
                descriptionTextView.setText(movie.getDescrpition());
            }
        }
    }
}
