package com.example.myapplication.myretrofitsampleapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.myretrofitsampleapp.R;
import com.example.myapplication.myretrofitsampleapp.model.Movie;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ListMovie> {

    private ArrayList<Movie> movieArrayList=new ArrayList<>();

    public void appendMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList.addAll(movieArrayList);
    }

    @NonNull
    @Override
    public ListMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new ListMovie(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovie holder, int position) {

        Movie movie=movieArrayList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ListMovie extends RecyclerView.ViewHolder {

        TextView idValue,orignalLangValue,popularityValue,titleValue;

        public ListMovie(@NonNull View itemView) {
            super(itemView);

            idValue=itemView.findViewById(R.id.idValue);
            orignalLangValue=itemView.findViewById(R.id.orignalLangValue);
            popularityValue=itemView.findViewById(R.id.popularityValue);
            titleValue=itemView.findViewById(R.id.titleValue);
        }

        public void bind(Movie movie) {
            idValue.setText(movie.getId());
            orignalLangValue.setText(movie.getOriginal_language());
            popularityValue.setText(movie.getPopularity());
            titleValue.setText(movie.getTitle());
        }
    }
}
