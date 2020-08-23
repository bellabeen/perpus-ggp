package com.vika.ggf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * create Vika Rahayu Aryati
 */
public class info extends Fragment {
    public info(){
        //kosong
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.info, container, false);
        getActivity().setTitle("Info");
        return view;
    }
}