package com.example.chris.sharemovie.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chris.sharemovie.R;
import com.example.chris.sharemovie.models.ItemsMovieList;
import com.example.chris.sharemovie.models.LetterSeparartor;
import com.example.chris.sharemovie.models.Movie;
import com.example.chris.sharemovie.viewHolders.LetterSeparatorViewHolder;
import com.example.chris.sharemovie.viewHolders.MovieViewHolder;
import com.example.chris.sharemovie.viewHolders.NumberMovieViewHolder;
import com.example.chris.sharemovie.models.NumberMovies;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter {

    private List<ItemsMovieList> itemsMovieLists = new ArrayList<>();
    private static final int MOVIE_VIEW = 1;
    private static final int LETTER_VIEW = 2;
    private static final int NUMBER_FILM_VIEW = 3;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == MOVIE_VIEW) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_movie, viewGroup, false);
            MovieViewHolder vh = new MovieViewHolder(view);
            return vh;
        }
        else if (i == LETTER_VIEW) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_letter_separator, viewGroup, false);
            LetterSeparatorViewHolder vh = new LetterSeparatorViewHolder(view);
            return vh;
        }
        else if (i == NUMBER_FILM_VIEW) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_number_movie, viewGroup, false);
            NumberMovieViewHolder vh = new NumberMovieViewHolder(view);
            return vh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemsMovieList currentItem = itemsMovieLists.get(i);
        if(currentItem != null) {

            if (currentItem.getViewType() == MOVIE_VIEW) {
                MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;
                movieViewHolder.layoutForMovie((Movie) currentItem);

            }
            else if (currentItem.getViewType() == LETTER_VIEW) {
                LetterSeparatorViewHolder letterSeparatorViewHolder = (LetterSeparatorViewHolder) viewHolder;
                letterSeparatorViewHolder.layoutForLetter((LetterSeparartor) currentItem);
            }
            else if (currentItem.getViewType() == NUMBER_FILM_VIEW) {
                NumberMovieViewHolder numberMovieViewHolder = (NumberMovieViewHolder) viewHolder;
                numberMovieViewHolder.layoutForLetter((NumberMovies) currentItem);
            }
        }

    }

    @Override
    public int getItemCount() {
        if(itemsMovieLists != null) {
            return itemsMovieLists.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if(itemsMovieLists != null) {
            return itemsMovieLists.get(position).getViewType();
        }
        return 0;
    }

    public void setItemsMovieLists(List<ItemsMovieList> categories) {
        this.itemsMovieLists = categories;
    }

}
