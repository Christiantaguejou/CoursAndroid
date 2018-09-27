package com.example.chris.sharemovie.viewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chris.sharemovie.MainActivity;
import com.example.chris.sharemovie.MoviesActivity;
import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.Movie;
import com.example.chris.sharemovie.models.MoviesManager;

public class MovieViewHolder extends BaseViewHolder{

    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private RelativeLayout relativeLayout;
    private Context ctx;
    private int movieId;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.movie_image);
        this.titleTextView = itemView.findViewById(R.id.list_movie_title);
        this.descriptionTextView = itemView.findViewById(R.id.list_movie_description);
        this.relativeLayout = itemView.findViewById(R.id.global_cell);

    }

    public void setContext(Context ctx) {
        this.ctx = ctx;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public void layoutForObject(Object object) {
        super.layoutForObject(object);
        Movie movie = (Movie) object;

        if(movie.getImage() != 0) {
            if(imageView != null){
                imageView.setImageDrawable(imageView.getContext().getDrawable(movie.getImage()));
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
        if(relativeLayout != null) {
            relativeLayout.setOnClickListener(v -> {
                Intent intent = new Intent(imageView.getContext(), MainActivity.class);
                intent.putExtra("movie", movie.getId());
                imageView.getContext().startActivity(intent);
            });
        }
    }
}
