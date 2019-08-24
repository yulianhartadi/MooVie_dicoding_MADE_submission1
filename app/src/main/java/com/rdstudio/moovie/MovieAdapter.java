package com.rdstudio.moovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        // add view holder
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return view;
    }

    private class ViewHolder{
        private TextView tvTitleMovie, tvPhMovie, tvStorylineMovie;
        private ImageView imgPosterMovie;

        ViewHolder(View view){
            tvTitleMovie = view.findViewById(R.id.tv_movie_title);
            tvPhMovie = view.findViewById(R.id.tv_ph_movie);
            tvStorylineMovie = view.findViewById(R.id.tv_movie_storyline);
            imgPosterMovie = view.findViewById(R.id.iv_poster_movie);
        }

        void bind(Movie movie){
            tvTitleMovie.setText(movie.getTitleMovie());
            tvPhMovie.setText(movie.getPhMovie());
            tvStorylineMovie.setText(movie.getStorylineMovie());
            imgPosterMovie.setImageResource(movie.getPosterMovie());
        }
    }
}
