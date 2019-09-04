package com.rdstudio.moovie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;


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
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_tabs, container, false);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_now_playing_1), R.drawable.poster_a_star);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_now_playing_2), R.drawable.poster_aquaman);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_upcoming_1), R.drawable.poster_avengerinfinity);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_upcoming_2), R.drawable.poster_birdbox);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_upcoming_3), R.drawable.poster_bohemian);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_popular_1), R.drawable.poster_bumblebee);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_popular_2), R.drawable.poster_dragon);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_top_rated_1), R.drawable.poster_dragon);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_top_rated_2), R.drawable.poster_dragon);
        Tools.displayImageOriginal(getActivity(), (ImageView) root.findViewById(R.id.img_top_rated_3), R.drawable.poster_dragon);
        return root;



    }


}
