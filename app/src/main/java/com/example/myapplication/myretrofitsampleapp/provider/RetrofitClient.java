package com.example.myapplication.myretrofitsampleapp.provider;


import com.example.myapplication.myretrofitsampleapp.api.MovieListApi;
import com.example.myapplication.myretrofitsampleapp.helper.PresenterCallback;
import com.example.myapplication.myretrofitsampleapp.model.MovieList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    final int SUCCESS=200;

    private MovieListApi movieListApi;
    private Retrofit retrofit;
    private Call<MovieList> call;


    public RetrofitClient() {

         retrofit = new Retrofit.Builder().baseUrl(movieListApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieListApi = retrofit.create(MovieListApi.class);
    }



    public void getMovieList(String apiKey, int page, PresenterCallback<MovieList> presenterCallback){
        call= movieListApi.getTopRatedMovieList(apiKey,page);
        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {

                if(response.code()==SUCCESS){
                    presenterCallback.onSuccess(response.body());

                }else{
                    presenterCallback.onFailure(response.message());
                }

            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                presenterCallback.onFailure(t.getMessage());
            }
        });
    }

}
