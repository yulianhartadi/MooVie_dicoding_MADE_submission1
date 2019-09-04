package com.rdstudio.moovie;

import android.app.SearchManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }

    // alternative 2, tetep ga muncul
    /*private void initToolbar(){
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.activity_main, null);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);
        getSupportActionBar().setHomeButtonEnabled(true);
        Tools.setSystemBarColor(this);
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        Tools.changeMenuIconColor(menu, getResources().getColor(R.color.grey_10));

        //Search menu
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.choose_language:
                Toast.makeText(MainActivity.this, "Selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
            case R.id.settings:
                // Settings
                // Choose Language menu
                Toast.makeText(MainActivity.this, "Selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;

            default:
                return true;
        }
    }

    private void initContent() {
        viewPager = findViewById(R.id.main_view_pager);
        tabLayout = findViewById(R.id.main_tab_layout);
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_local_movies);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_live_tv);

        //Set icon color pre-selected
        Objects.requireNonNull(tabLayout.getTabAt(0)).getIcon().setColorFilter(getResources().getColor(R.color.grey_5), PorterDuff.Mode.SRC_IN);
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
        viewPagerAdapater.addFragment(TabsFragment.newInstance(), "Movies");
        viewPagerAdapater.addFragment(TabsFragment.newInstance(), "TV Show");

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

}
