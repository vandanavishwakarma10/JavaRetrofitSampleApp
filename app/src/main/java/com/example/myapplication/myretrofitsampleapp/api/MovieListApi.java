package com.example.myapplication.myretrofitsampleapp.api;

import com.example.myapplication.myretrofitsampleapp.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieListApi {

    String BASE_URL = "https://api.themoviedb.org/3/movie/";

    @GET("top_rated")
    Call<MovieList> getTopRatedMovieList(
            @Query("api_key") String apiKey,
            @Query("page") int page);
}
