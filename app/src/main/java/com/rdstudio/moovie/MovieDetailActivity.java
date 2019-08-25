package com.rdstudio.moovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

public class MovieDetailActivity extends AppCompatActivity {

   // public final String MOVIE_DETAIL = "movie_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        StatusBarUtil.setTransparent(this);


        //Movie movie = getIntent().getParcelableExtra(MOVIE_DETAIL);
    }


}
