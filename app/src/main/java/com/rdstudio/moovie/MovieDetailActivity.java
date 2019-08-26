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

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaeger.library.StatusBarUtil;

import java.util.Objects;

public class MovieDetailActivity extends AppCompatActivity {

    public static String MOVIE_DETAIL = "movie_detail";

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
        ivPosterMovie = findViewById(R.id.iv_poster_movie);
        ivPosterMovieTrailer = findViewById(R.id.iv_poster_movie_trailer);
        toolbar = findViewById(R.id.toolbar);
        nsvContent = findViewById(R.id.nsv_content);
        cvPosterMovie = findViewById(R.id.cv_poster_movie);
        tvThumbMovieTitle = findViewById(R.id.tv_thumb_movie_title);
        tvThumbPhMovie = findViewById(R.id.tv_thumb_ph_movie);
        tvThumbMovieRating = findViewById(R.id.tv_thumb_movie_rating);
        tvTitleTrailer = findViewById(R.id.tv_title_trailer);
        tvDuration = findViewById(R.id.tv_duration);
        tvTitleContentStoryline = findViewById(R.id.tv_title_content_storyline);
        tvContentStoryline = findViewById(R.id.tv_content_storyline);
        btnPlay = findViewById(R.id.btn_play);
        lytProgress = findViewById(R.id.lyt_progress);
        seekBar = findViewById(R.id.seek_bar);
        btnFullscreen = findViewById(R.id.btn_fullscreen);

        final Movie mMovie = getIntent().getParcelableExtra(MOVIE_DETAIL);

        // load item detail
        assert mMovie != null;
        Glide.with(getApplicationContext())
                .load(mMovie.getPosterMovie())
                .into(ivImageHeader);

        ivPosterMovie.setImageResource(mMovie.getPosterMovie());
        ivPosterMovieTrailer.setImageResource(mMovie.getPosterMovie());
        tvThumbMovieTitle.setText(mMovie.getTitleMovie());
        tvThumbPhMovie.setText(mMovie.getPhMovie());
        tvContentStoryline.setText(mMovie.getStorylineMovie());
        tvThumbMovieRating.setText(mMovie.getMovieRating());


    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

}
