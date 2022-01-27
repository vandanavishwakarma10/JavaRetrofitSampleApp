package com.example.myapplication.myretrofitsampleapp.presenter;


import com.example.myapplication.myretrofitsampleapp.helper.PresenterCallback;
import com.example.myapplication.myretrofitsampleapp.model.MovieList;
import com.example.myapplication.myretrofitsampleapp.provider.RetrofitClient;
import com.example.myapplication.myretrofitsampleapp.view.ActionInterface.MovieListUIActions;


public class MovieListPresenter {

    private MovieListUIActions movieListUIActions;
    private RetrofitClient retrofitClient;


    public MovieListPresenter(MovieListUIActions movieListUIActions, RetrofitClient retrofitClient) {
        this.movieListUIActions = movieListUIActions;
        this.retrofitClient = retrofitClient;
    }

     public void getMovieList(String apiKey, int page){
        movieListUIActions.showLoader(true);
        retrofitClient.getMovieList(apiKey, page, new PresenterCallback<MovieList>() {
            @Override
            public void onSuccess(MovieList movieList) {
                movieListUIActions.showLoader(false);
                try{
                    movieListUIActions.showList(movieList.getMovieList());
                }catch (Exception exception){
                    movieListUIActions.showLoader(false);
                    movieListUIActions.showMessage(exception.getMessage());
                }
            }

            @Override
            public void onFailure(String failureMessage) {
                movieListUIActions.showLoader(false);
                movieListUIActions.showMessage(failureMessage);
            }
        });
    }
}
