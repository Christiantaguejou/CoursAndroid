package com.example.chris.sharemovie;

public class Category {

    private String name;
    private int id;

    private static int _id = 0;

    public Category(String name) {
        this.name = name;
        this.id = _id;
        _id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
}
