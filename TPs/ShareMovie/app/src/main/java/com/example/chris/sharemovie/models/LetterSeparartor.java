package com.example.chris.sharemovie.models;

public class LetterSeparartor extends ItemsMovieList {

    private Character letter;
    private int viewType = 2;

    public LetterSeparartor(Character letter) {
        this.letter = letter;
        this.setViewType(viewType);
    }

    public Character getLetter() {
        return letter;
    }

    private void setLetter(Character letter) {
        this.letter = letter;
    }

    @Override
    public void setViewType(int viewType) {
        super.setViewType(viewType);
    }
}
