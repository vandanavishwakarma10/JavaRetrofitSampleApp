package com.example.myapplication.myretrofitsampleapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieList {

    @SerializedName("results")
    private ArrayList<Movie> movieList= new ArrayList();

    public MovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
