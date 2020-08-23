package com.vika.ggf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * create Vika Rahayu Aryati
 */
public class riwayatpeminjaman extends Fragment {
    public riwayatpeminjaman(){
        //nanti di isi
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.riwayatpeminjaman, container, false);
        getActivity().setTitle("Riwayat Peminjaman");
        return view;
    }
}