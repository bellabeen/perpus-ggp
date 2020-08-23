package com.vika.ggf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * create Vika Rahayu Aryati
 */
public class mintabuku extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.mintabuku, container, false);
        getActivity().setTitle("Permintaan Buku");
        return view;
    }

}