package com.example.chris.sharemovie.models;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;

public class Movie implements Comparable<Movie>  {

    private String title;
    private String originalTitle;
    private String descrpition;
    private Drawable image;
    private Category category;
    private String keyword;

    public Movie(String title, String originalTitle, String descrpition, Drawable image, Category category, String keyword) {
        this.title = title;
        if(descrpition.length() > 80) {
            this.descrpition = descrpition.substring(0, 80);
            this.descrpition = this.descrpition + "...";
        } else {
            this.descrpition = descrpition;
        }
        this.image = image;
        this.category = category;
        this.originalTitle = originalTitle;
        this.keyword = keyword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public int compareTo(@NonNull Movie movie) {
        return title.toLowerCase().compareTo(movie.title.toLowerCase());
    }
}
