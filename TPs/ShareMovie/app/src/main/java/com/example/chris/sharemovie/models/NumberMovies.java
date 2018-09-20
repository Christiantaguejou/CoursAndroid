package com.example.chris.sharemovie.models;

public class NumberMovies extends ItemsMovieList {

    private int viewType = 3;
    private int numberOfMovies;

    public NumberMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
        setViewType(viewType);
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    @Override
    public void setViewType(int viewType) {
        super.setViewType(viewType);
    }

    @Override
    public String toString() {
        if(getNumberOfMovies() > 1) {
            return getNumberOfMovies()+" films";
        }
        else {
            return getNumberOfMovies()+" film";
        }
    }
}
