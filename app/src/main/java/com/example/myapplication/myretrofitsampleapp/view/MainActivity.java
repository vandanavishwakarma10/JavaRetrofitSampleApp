package com.example.myapplication.myretrofitsampleapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.myretrofitsampleapp.R;
import com.example.myapplication.myretrofitsampleapp.model.Movie;
import com.example.myapplication.myretrofitsampleapp.presenter.MovieListPresenter;
import com.example.myapplication.myretrofitsampleapp.provider.RetrofitClient;
import com.example.myapplication.myretrofitsampleapp.view.ActionInterface.MovieListUIActions;
import com.example.myapplication.myretrofitsampleapp.view.adapter.MovieListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieListUIActions {

    final String API_KEY="ec01f8c2eb6ac402f2ca026dc2d9b8fd";

    private Button loadnextPage;
    private Button showDetails;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;

    private int page;

    private MovieListPresenter movieListPresenter;
    private MovieListAdapter movieListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defaultInitialisation();
        setListener();

    }

    /* Define all Listeners */
    private void setListener() {

        showDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fethDetails();
            }
        });

        loadnextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page+=1;
                fethDetails();
            }
        });

    }

    /* Call Api and fetch details */
    private void fethDetails() {
        movieListPresenter.getMovieList(API_KEY,page);
    }

    /* Initialise with default values */
    private void defaultInitialisation() {


        movieListPresenter=new MovieListPresenter(this,new RetrofitClient());

        page = 1;
        loadnextPage = findViewById(R.id.loadNextPage);
        showDetails = findViewById(R.id.showDetails);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        movieListAdapter=new MovieListAdapter();
        recyclerView.setAdapter(movieListAdapter);

    }

    @Override
    public void showLoader(Boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
            loadnextPage.setVisibility(View.GONE);

        }else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(ArrayList<Movie> movieArrayList) {


        if(movieArrayList.size()>0){
            loadnextPage.setVisibility(View.VISIBLE);
            showDetails.setVisibility(View.GONE);
        }else{
            loadnextPage.setVisibility(View.GONE);
        }

        movieListAdapter.appendMovieArrayList(movieArrayList);
        movieListAdapter.notifyDataSetChanged();
    }
}