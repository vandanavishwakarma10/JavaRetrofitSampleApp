package com.example.myapplication.myretrofitsampleapp.view.ActionInterface;

import com.example.myapplication.myretrofitsampleapp.model.Movie;

import java.util.ArrayList;

public interface MovieListUIActions {
    void showLoader(Boolean show);
    void showMessage(String message);
    void showList(ArrayList<Movie> movieArrayList);

}
