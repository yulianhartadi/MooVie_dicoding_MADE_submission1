package com.rdstudio.moovie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TabsFragment extends Fragment {



    public TabsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TabsFragment newInstance() {
        TabsFragment fragment = new TabsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Movie> list = new ArrayList<>();

        // 1. Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);

        // 2. get a reference to recyclerview
        RecyclerView mainRvMovie = rootView.findViewById(R.id.rv_movie);
        mainRvMovie.setHasFixedSize(true);

        // 3. set layout manager
        mainRvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));


        // 3a. load data for recyclerview



        return rootView;



    }


}
