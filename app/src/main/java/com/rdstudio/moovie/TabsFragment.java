package com.rdstudio.moovie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class TabsFragment extends Fragment {

    public TabsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TabsFragment newInstance(String param1, String param2) {
        TabsFragment fragment = new TabsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabs, container, false);
    }


}
