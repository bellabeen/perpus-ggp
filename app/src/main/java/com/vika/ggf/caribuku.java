package com.vika.ggf;

import android.app.ListActivity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



/**
 * create Vika Rahayu Aryati
 */
public class caribuku extends ListFragment implements SearchView.OnQueryTextListener {

    private View rootView;
    private static final String TAG = "cariBukuLogger";

    List<String> mAllValues;
    private ArrayAdapter<String> mAdapter;
    private Context mContext;

    public caribuku(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        populateList();
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        String item = (String) listView.getAdapter().getItem(position);
        if (getActivity() instanceof OnItem1SelectedListener) {
            ((OnItem1SelectedListener) getActivity()).OnItem1SelectedListener(item);
        }
        getFragmentManager().popBackStack();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.caribuku, container, false);
        getActivity().setTitle("Cari Buku");

        ListView listView = (ListView) rootView.findViewById(android.R.id.list);
        TextView emptyTextView = (TextView) rootView.findViewById(android.R.id.empty);
        listView.setEmptyView(emptyTextView);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Cari Buku ...");

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }

        List<String> filteredValues = new ArrayList<String>(mAllValues);
        for (String value : mAllValues) {
            if (!value.toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }

        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, filteredValues);
        setListAdapter(mAdapter);

        return false;
    }

    public void resetSearch() {
        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mAllValues);
        setListAdapter(mAdapter);
    }

    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }

    public interface OnItem1SelectedListener {
        void OnItem1SelectedListener(String item);
    }


    private void populateList(){

        mAllValues = new ArrayList<>();

        mAllValues.add("Dua Ibu");
        mAllValues.add("Ayahku Bukan Pembohong");
        mAllValues.add("Adventures In Darkness");
        mAllValues.add("Anak Bulgur");
        mAllValues.add("Annisa");
        mAllValues.add("Arah Langkah");
        mAllValues.add("Bintang");
        mAllValues.add("Berani Bermimpi");
        mAllValues.add("Bumi");
        mAllValues.add("Brisinger");
        mAllValues.add("Argentina");
        mAllValues.add("Cinta di Dalam Gelas");
        mAllValues.add("Catatan Juang");
        mAllValues.add("Cinta Adalah Perlawanan");
        mAllValues.add("Cherry Blossom");
        mAllValues.add("Destiny");
        mAllValues.add("Don't Give Up");
        mAllValues.add("Dilan: Dia Adalah Dilanku Tahun 1990");
        mAllValues.add("Dunia Kafka");
        mAllValues.add("Dear Nathan");
        mAllValues.add("Dari Papua Meneropong Indonesia");
        mAllValues.add("Empat Ginjal Ditubuhku");
        mAllValues.add("Eliana");
        mAllValues.add("Eye of The World");
        mAllValues.add("Eldest");
        mAllValues.add("Eksistensi Rasa");
        mAllValues.add("Everything You Need Know About");
        mAllValues.add("Friksi (Friction)");
        mAllValues.add("Fire");
        mAllValues.add("Filosofi Kopi : Kumpulan Cerita dan Prosa Satu Dekade");
        mAllValues.add("Follow @Merry Riana");
        mAllValues.add("Finding My Prince Charming");
        mAllValues.add("Ga Thuk : Masihkah Kita Percaya Logika?");
        mAllValues.add("Harry Potter dan Batu Bertuah");
        mAllValues.add("Harry Potter dan Piala Api");
        mAllValues.add("Hello Salma");
        mAllValues.add("Hujan");
        mAllValues.add("In A Blue Moon");
        mAllValues.add("Ibuk");
        mAllValues.add("If I Can't Will You Always By My Side?");
        mAllValues.add("Indonesia Ketergantungan dan Keterbelakangan");
        mAllValues.add("Inheritance Warisan");
        mAllValues.add("Jatuh");
        mAllValues.add("Jeda Dalam Koma : Berhenti untuk Mengerti");
        mAllValues.add("Jun!!!");
        mAllValues.add("Kau, Aku dan Sepucuk Angpau Merah");
        mAllValues.add("Konspirasi Alam Semesta");
        mAllValues.add("Ketika Cahaya Berpijar");
        mAllValues.add("Kenanga");
        mAllValues.add("Komet");
        mAllValues.add("Kopi Sumatera Di Amerika");
        mAllValues.add("Lelaki Harimau");
        mAllValues.add("London Love Story");
        mAllValues.add("Love Is!");
        mAllValues.add("Love Therapy");
        mAllValues.add("Lucian");
        mAllValues.add("Lelaki Yang Membelah Bulan");
        mAllValues.add("Made of Stars");
        mAllValues.add("Matahari");
        mAllValues.add("Maysuri");
        mAllValues.add("MeloDylan");
        mAllValues.add("Milea : Suara Dari Dilan");
        mAllValues.add("MINOEL");
        mAllValues.add("Mimpi - Mimpi Lintang Maryamah Karpov");
        mAllValues.add("Mission of The New Recipe");
        mAllValues.add("Move On Nggak Pake Lama");
        mAllValues.add("Messages Of Success");
        mAllValues.add("My Stupid Boss 5");
        mAllValues.add("Mycroft Holmes");
        mAllValues.add("Negeri Di Ujung Tanduk)");
        mAllValues.add("Negeri 5 Negara");
        mAllValues.add("Negeri Para Bedebah");
        mAllValues.add("No Sex In The City");
        mAllValues.add("Padang Bulan");
        mAllValues.add("Para Lajang");
        mAllValues.add("A Verry Yuppy Wedding");
        mAllValues.add("Permata di Hatiku");
        mAllValues.add("Pergi");
        mAllValues.add("Pensiun Muda Pensiun Kaya");
        mAllValues.add("Pulang");
        mAllValues.add("Pertemuan Yang Mengejutkan");
        mAllValues.add("People Of The Book");
        mAllValues.add("Pahlawan Zaman Kita");
        mAllValues.add("Greece");
        mAllValues.add("Rantau 1 Muara");
        mAllValues.add("Ranah 3 Warna");
        mAllValues.add("Remember Me");
        mAllValues.add("Rindu");
        mAllValues.add("Runtuhnya Suara Azan");
        mAllValues.add("Sagra");
        mAllValues.add("Saman");
        mAllValues.add("Rembulan Tenggelam di Wajahmu");
        mAllValues.add("Satu Ruang");
        mAllValues.add("Satria November");
        mAllValues.add("Satria Novemver #2");
        mAllValues.add("Sempurna");
        mAllValues.add("Sherlock Holmes Koleksi Kasus 1");
        mAllValues.add("Sherlock Holmes Koleksi Kasus 2");
        mAllValues.add("Sherlock Holmes The Collerctor's Edition if Complete Best Novel");
        mAllValues.add("Sepotong Hari yang Baru");
        mAllValues.add("Shopaholic Insyaf");
        mAllValues.add("Supernova : Intelegensi Embun Pagi");
        mAllValues.add("Stephen King Under The Done : Di Bawah Kubah");
        mAllValues.add("Sirkus Pohon");
        mAllValues.add("Sunset dan Rosie");
        mAllValues.add("Sebuah Usaha Melupakan");
        mAllValues.add("Seribu Wajah Ayah");
        mAllValues.add("Surga yang Harus Ku Jaga");
        mAllValues.add("The Architecture of Love");
        mAllValues.add("The Adventures Of Sherlock Holmes");
        mAllValues.add("The Book of Invisible Questions");
        mAllValues.add("The Case Book Of Sharelock Holmes");
        mAllValues.add("Tahajud Cinta Di Kota New York");
        mAllValues.add("The Cassual Vacancy : Perebutan Kursi Kosong");
        mAllValues.add("Tempurung");
        mAllValues.add("#TemanTapiMenikah");
        mAllValues.add("The Land Of Five Towers");
        mAllValues.add("Tuhan Maha Romantis");
        mAllValues.add("The Book Of Forbiden Feelings");
        mAllValues.add("The Return Of Sherlock Holmes");
        mAllValues.add("Titip Rindu Untuk Ibu");
        mAllValues.add("Tentang Kamu");
        mAllValues.add("#TemanTapiMenikah2");
        mAllValues.add("The Twilight Saga Eclipse");
        mAllValues.add("Wah Ternyata 2");
        mAllValues.add("Wah Ternyata 3");
        mAllValues.add("Will You Please Be Quiet Please");
        mAllValues.add("You Are The Apple of My Eye");
        mAllValues.add("Borobudur Auction");
        mAllValues.add("English Is Fun");
        mAllValues.add("Forbes Asia");
        mAllValues.add("Globe Asia 50 Richest Indonesians");
        mAllValues.add("Globe Asia Travel Time");
        mAllValues.add("Indonesia Forbes");
        mAllValues.add("Indonesia Forbes The Partner");
        mAllValues.add("Indonesia Tatler");
        mAllValues.add("Kamus Inggris Indonesia");
        mAllValues.add("Kamus Arab");
        mAllValues.add("Kamus Besar Bahasa Indonesia");
        mAllValues.add("Kamus Inggris - Indonesia");
        mAllValues.add("Kamus Ilmiah Populer Lengkap");
        mAllValues.add("Kamus Jepang : Master Pocket");
        mAllValues.add("Kamus Korea : Master Pocket");
        mAllValues.add("Kamus Mandarin");
        mAllValues.add("Kamus Pangan dan Gizi");
        mAllValues.add("Kamus Saku Perancis Indonesia");
        mAllValues.add("Kamus Umum Bahasa Indonesia");
        mAllValues.add("Mencintai Kenyataan");
        mAllValues.add("Oxfotd Advance Learners Dictionary");
        mAllValues.add("Prioritas Berkembang Bersama Sahabat");
        mAllValues.add("Tiimes Harga Karun Yang Hilang");
        mAllValues.add("Times Indonesia Memilih");
        mAllValues.add("Times Jakarta Setelah Jokowi");
        mAllValues.add("Times Mari Legalkan Ganja");
        mAllValues.add("Akuntansi Biaya");
        mAllValues.add("Audit Forensik");
        mAllValues.add("Akuntansi Manajemen");
        mAllValues.add("Aplikasi Iso Sebagai Standar Mutu");
        mAllValues.add("A to Z Human Capital");
        mAllValues.add("Bangkit Dengan 7 Budi Utama");
        mAllValues.add("Business Model You");
        mAllValues.add("Buku Pintar Membuat SOP");
        mAllValues.add("Competency Management");
        mAllValues.add("Cash Flow Management");
        mAllValues.add("Cash Flow Quadrant");
        mAllValues.add("Engaging Talent");
        mAllValues.add("Forensic Accounting");
        mAllValues.add("Extreme Toyota");
        mAllValues.add("Good To Great");
        mAllValues.add("Gelombang Ketiga");
        mAllValues.add("Good Habits Great Sales");
        mAllValues.add("Investasi Ala Orang Gajian");
        mAllValues.add("Innovate We Can!");
        mAllValues.add("Jadi Manajer? Siapa Takut!");
        mAllValues.add("Kaizen");
        mAllValues.add("13 Konsep Beyond Leadership");
        mAllValues.add("Komunikasi Cerdas");
        mAllValues.add("Kamus Ungkapan Bahasa Indonesia");
        mAllValues.add("Leading Change");
        mAllValues.add("Lead By GCG");
        mAllValues.add("Leader Mentoring");
        mAllValues.add("Menembus Batas");
        mAllValues.add("Manajemen Risiko 2");
        mAllValues.add("Morning Briefing Work");
        mAllValues.add("Minaut Indonesia");
        mAllValues.add("Manajemen Logistik Terintegrasi");
        mAllValues.add("Marketing Management");
        mAllValues.add("Manajemen Pengadaan");
        mAllValues.add("Manajemen Pergudangan");
        mAllValues.add("Manajemen Sumber Daya Manusia (Jilid 2)");
        mAllValues.add("Memecut Tanpa Memecat");
        mAllValues.add("Mencapai Sasaran Melalui Kerjasama Tim");
        mAllValues.add("Membabat Virus Nganggur");
        mAllValues.add("Memberi Untuk Menerima Lebih Banyak");
        mAllValues.add("Make Your Own Plan");
        mAllValues.add("Perusahaan Adaptif");
        mAllValues.add("Personal Balanced Scorecard");
        mAllValues.add("Pedoman Hubungan Industri");
        mAllValues.add("Pedoman Kerja Manager");
        mAllValues.add("Pedoman Lengkap Soft Skills");
        mAllValues.add("Perilaku Organisasi (Jilid 1)");
        mAllValues.add("Perilaku Organisasi (Jilid 2)");
        mAllValues.add("Panduan Praktis HRD & GA");
        mAllValues.add("Step By Step Membuat SOP");
        mAllValues.add("Solusi Keuangan");
        mAllValues.add("#SHARING");
        mAllValues.add("Strategi CSR");
        mAllValues.add("Siapa Bilang Jadi Pegawai Nggak Bisa Kaya?");
        mAllValues.add("Sukses Pensiun Dini");
        mAllValues.add("Solusi Keuangan");
        mAllValues.add("Super Project Manager");
        mAllValues.add("Soft Skils");
        mAllValues.add("Strategi Social Security & Minimum Wages");
        mAllValues.add("The Art Of Controlling People");
        mAllValues.add("The Art Of Packaging");
        mAllValues.add("The 360 Degree Leader");
        mAllValues.add("The Disney Way");
        mAllValues.add("Think Agile");
        mAllValues.add("Tata Krama Perusahaan");
        mAllValues.add("The 5 Essential People skills");
        mAllValues.add("Talent On Demand");
        mAllValues.add("The Quality of Growth");
        mAllValues.add("The Talent War");
        mAllValues.add("The Toyota Way");
        mAllValues.add("WOW SELLING");
        mAllValues.add("Warehouse Safety Management");
        mAllValues.add("Winning The War For Talent");
        mAllValues.add("Value Investing");
        mAllValues.add("Transformasi Rantai Suplai Dengan Model Scor");
        mAllValues.add("Your Job Is Not Your Career");
        mAllValues.add("5 CM");
        mAllValues.add("Butir - Butir Waktu");
        mAllValues.add("Bila Esok Tiba (Buku Pertama)");
        mAllValues.add("Bila Esok Tiba (Buku Kedua)");
        mAllValues.add("Sang Idola 1");
        mAllValues.add("Sang Idola 2");
        mAllValues.add("Laskar Pelangi");
        mAllValues.add("Lucky 1");
        mAllValues.add("Lucky 2");
        mAllValues.add("Luckky 3");
        mAllValues.add("Padang Bayang Kelabu");
        mAllValues.add("Wajah Sang Pembunuh");

        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mAllValues);
        setListAdapter(mAdapter);
    }
}
