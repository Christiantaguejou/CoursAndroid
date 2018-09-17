package com.example.chris.sharemovie.models;

public class Comment {

    private String comment;
    private String pseudo;

    private static int _id = 0;
    private static final String UTILISATEUR ="L\'utilisateur";

    public Comment(String comment) {
        this.comment = comment;
        this.pseudo = UTILISATEUR + " " +_id;
        _id++;
    }

    public String getComment() {
        return comment;
    }

    private void setComment(String comment) {
        this.comment = comment;
    }

    public String getPseudo() {
        return pseudo;
    }

    private void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
