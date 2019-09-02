package com.rdstudio.moovie;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MovieAdapter movieAdapter;
    private TabLayout tabLayout;
    private SectionsPagerAdapter viewPagerAdapater;

    private String[] dataMovie;
    private String[] dataPhMovie;
    private String[] dataStorylineMovie;
    private String[] dataMovieRating;
    private TypedArray dataPoster;


    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        movieAdapter = new MovieAdapter(this);
        initContent();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setTitle(R.string.app_name);

        Tools.setSystemBarColor(this);
    }

    private void initContent() {
        viewPager = findViewById(R.id.main_view_pager);
        tabLayout = findViewById(R.id.main_tab_layout);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_local_movies);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_live_tv);

        //Set icon color pre-selected
        Objects.requireNonNull(tabLayout.getTabAt(0).getIcon()).setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(tabLayout.getTabAt(1)).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    // add fragment for each view
    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapater = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPagerAdapater.addFragment(TabsFragment.newInstance(), "MOVIES");
        viewPagerAdapater.addFragment(TabsFragment.newInstance(), "TV SHOW");

        viewPager.setAdapter(viewPagerAdapater);
    }

    // create adapter for each section page
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(@NonNull FragmentManager manager) {
            super(manager);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Tools.changeMenuIconColor(menu, getResources().getColor(R.color.grey_10));
        return true;
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
