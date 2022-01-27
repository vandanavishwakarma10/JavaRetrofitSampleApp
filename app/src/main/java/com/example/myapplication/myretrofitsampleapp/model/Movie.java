package com.example.myapplication.myretrofitsampleapp.model;

public class Movie {

    private String id;
    private String original_language;
    private String popularity;
    private String title;


    public Movie(String id, String original_language, String popularity, String title) {
        this.id = id;
        this.original_language = original_language;
        this.popularity = popularity;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getTitle() {
        return title;
    }
}
