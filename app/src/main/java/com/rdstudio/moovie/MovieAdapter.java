package com.rdstudio.moovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    //private Context context;
    private ArrayList<Movie> listMovies;

    public MovieAdapter(ArrayList<Movie> listMovies) {
        this.listMovies = listMovies;
    }


    @NonNull
    @Override
    public MovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ListViewHolder holder, int position) {
        Movie movie = listMovies.get(position);

        // movie poster
        Glide.with(holder.itemView.getContext())
                .load(movie.getPosterMovie())
                .apply(new RequestOptions().override(100,160))
                .into(holder.ivPosterMovie);

        // text movie
        holder.tvMovieTitle.setText(movie.getTitleMovie());
        holder.tvPhMovie.setText(movie.getPhMovie());
        holder.tvStoryline.setText(movie.getStorylineMovie());
        holder.tvMovieRating.setText(movie.getMovieRating());

    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPosterMovie;
        TextView tvMovieTitle, tvPhMovie, tvStoryline, tvMovieRating, tvMoreInfo;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPosterMovie = itemView.findViewById(R.id.iv_poster_movie);
            tvMovieTitle = itemView.findViewById(R.id.tv_movie_title);
            tvPhMovie = itemView.findViewById(R.id.tv_ph_movie);
            tvStoryline = itemView.findViewById(R.id.tv_movie_storyline);
            tvMovieRating = itemView.findViewById(R.id.tv_movie_rating);
            tvMoreInfo = itemView.findViewById(R.id.tv_more_info);

        }
    }
}
