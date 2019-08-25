package com.rdstudio.moovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // add dummy list data movie
    /*private String[] dataMovie = {"A Star Is Born", "Aquaman", "Bohemian Rhapsody", "BumbleBee", "Creed II", "DeadPool", "HTTYD",
    "DragonBall","Glass", "Hunter Killer", "Mary Poppins", "Mortal Engines", "Preman Pensiun", "Robin Hood", "Spiderman In To The Spider Verse",
    "The Girl In The Spders Web", "The Mule", "Venom"};*/

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

        // Add dummy main view
        /*ListView listView = findViewById(R.id.lv_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, dataMovie);
        listView.setAdapter(adapter);*/

        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(movieAdapter);

        prepareMovies();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getTitleMovie(), Toast.LENGTH_SHORT).show();

                // Parcelable intent
                Movie dataMovie = new Movie();
                dataMovie.setPosterMovie(movies.get(i).getPosterMovie());
                dataMovie.setTitleMovie(movies.get(i).getTitleMovie());
                dataMovie.setPhMovie(movies.get(i).getPhMovie());
                dataMovie.setStorylineMovie(movies.get(i).getStorylineMovie());
                dataMovie.setMovieRating(movies.get(i).getMovieRating());

                Intent detailMovieIntent = new Intent(MainActivity.this, MovieDetailActivity.class);

                startActivity(detailMovieIntent);

            }
        });

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
    private void prepareMovies(){
        dataMovie = getResources().getStringArray(R.array.movie_title);
        dataPhMovie = getResources().getStringArray(R.array.movie_ph);
        dataStorylineMovie = getResources().getStringArray(R.array.movie_storyline);
        dataMovieRating = getResources().getStringArray(R.array.movie_rating);
        dataPoster = getResources().obtainTypedArray(R.array.movie_poster);
    }
}
