package com.rdstudio.moovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaeger.library.StatusBarUtil;

import java.util.Objects;

public class MovieDetailActivity extends AppCompatActivity {

    public final String MOVIE_DETAIL = "movie_detail";

    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView ivImageHeader, ivPosterMovie, ivPosterMovieTrailer;
    Toolbar toolbar;
    NestedScrollView nsvContent;
    CardView cvPosterMovie;
    TextView tvThumbMovieTitle, tvThumbPhMovie, tvThumbMovieRating,
            tvTitleTrailer, tvDuration, tvTitleContentStoryline, tvContentStoryline;
    FloatingActionButton btnPlay;
    LinearLayout lytProgress;
    AppCompatSeekBar seekBar;
    ImageButton btnFullscreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initToolbar();

        // connect id
        appBarLayout = findViewById(R.id.app_bar_layout);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ivImageHeader = findViewById(R.id.iv_img_header);
        


        Movie movie = getIntent().getParcelableExtra(MOVIE_DETAIL);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
