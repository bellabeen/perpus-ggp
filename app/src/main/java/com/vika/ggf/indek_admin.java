package com.vika.ggf;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/*
 * create Vika Rahayu Aryati.
 */
public class indek_admin extends Fragment  {
    public indek_admin(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.indek_admin, container, false);
        getActivity().setTitle("Perpustakaan GGF Admin");
        return view;
    }

}
