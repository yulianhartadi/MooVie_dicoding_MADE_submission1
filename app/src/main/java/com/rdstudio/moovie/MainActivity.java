package com.rdstudio.moovie;

import android.content.res.TypedArray;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.rdstudio.moovie.utils.Tools;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private String[] dataMovie;
    private String[] dataPhMovie;
    private String[] dataStorylineMovie;
    private String[] dataMovieRating;
    private TypedArray dataPoster;
    private MovieAdapter movieAdapter;

    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();


        movieAdapter = new MovieAdapter(this);

        prepareMovies();
        addItem();

    }

    private void initToolbar(){
        Toolbar toolbar =findViewById(R.id.main_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }



    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataMovie.length; i++) {
            Movie movie = new Movie();
            movie.setPosterMovie(dataPoster.getResourceId(i, -1));
            movie.setTitleMovie(dataMovie[i]);
            movie.setPhMovie(dataPhMovie[i]);
            movie.setStorylineMovie(dataStorylineMovie[i]);
            movie.setMovieRating(dataMovieRating[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    //prepare stored movie data
    private void prepareMovies() {
        dataMovie = getResources().getStringArray(R.array.movie_title);
        dataPhMovie = getResources().getStringArray(R.array.movie_ph);
        dataStorylineMovie = getResources().getStringArray(R.array.movie_storyline);
        dataMovieRating = getResources().getStringArray(R.array.movie_rating);
        dataPoster = getResources().obtainTypedArray(R.array.movie_poster);
    }
}
