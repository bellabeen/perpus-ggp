package com.vika.ggf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * create Vika Rahayu Aryati.
 */
public class anggota extends Fragment {
    public anggota(){
        //nanti diisi
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.anggota, container, false);
        getActivity().setTitle("Anggota");
        return view;
    }
}