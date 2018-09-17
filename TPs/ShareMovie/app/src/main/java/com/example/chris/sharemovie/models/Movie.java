package com.example.chris.sharemovie.models;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Movie {

    private String title;
    private String descrpition;
    private Drawable image;
    private Category category;

    public Movie(String title, String descrpition, Drawable image, Category category) {
        this.title = title;
        if(descrpition.length() > 80) {
            this.descrpition = descrpition.substring(0, 80);
            this.descrpition = this.descrpition + "...";
        } else {
            this.descrpition = descrpition;
        }
        this.image = image;
        this.category = category;
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
}
