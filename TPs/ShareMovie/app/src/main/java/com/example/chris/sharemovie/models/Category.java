package com.example.chris.sharemovie.models;

public class Category {

    private String name;
    private int id;

    private static int _id = 0;

    private Category(String name) {
        this.name = name;
        this.id = _id;
        _id++;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public static final Category ACTION = new Category("Action");
    public static final Category AVENTURE = new Category("Aventure");
    public static final Category ANIMATION = new Category("Animation");
    public static final Category DANSE = new Category("Danse");
    public static final Category DRAMATIQUE = new Category("Dramatique");
    public static final Category ESPIONNAGE = new Category("Espionnage");
    public static final Category FANTASTIQUE = new Category("Fantastique");
    public static final Category GUERRE = new Category("Guerre");
    public static final Category HISTORIQUE = new Category("Historique");
    public static final Category HORREUR = new Category("Horreur");
    public static final Category HUMOUR = new Category("Humour");
    public static final Category POLICIER = new Category("Policier");
    public static final Category POLITIQUE = new Category("Politique");
    public static final Category ROMANTIQUE = new Category("Romantique");
    public static final Category SCIENCE_FICTION = new Category("Science-Fiction");
    public static final Category THRILLER = new Category("Thriller");
    public static final Category WESTERN = new Category("Western");

}
