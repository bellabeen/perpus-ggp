package com.vika.ggf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityAdmin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    Fragment fragment = null;

    //Ini Nav Menu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_admin);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Ini untuk tampilan default awal ketika aplikasi dijalankan
        if (savedInstanceState == null) {
            fragment = new indek_admin();
            callFragment(fragment);
        }
    }


    //Ini Untuk Login dan Daftar
    public class masuk extends AppCompatActivity {
        EditText nomerindek, katasandi;
        Button btnMasuk, btnDaftar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_admin);

            nomerindek = (EditText) findViewById(R.id.nomerindek);
            katasandi = (EditText) findViewById(R.id.katasandi);
            btnMasuk = (Button) findViewById(R.id.btnMasuk);
            btnDaftar = (Button) findViewById(R.id.btnDaftar);

            String usernameKey;

            final Context context = this;


            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivityAdmin.this, indek_admin.class);
                    MainActivityAdmin.this.startActivity(intent);
                }
            });
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.masuk, container, false);
        return view;}


    //Ini Untuk Register
    public class register extends AppCompatActivity {
        EditText nik, hp, email;
        Button btnCek, btnBatal, btnDaftar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.register);

            nik = (EditText) findViewById(R.id.nik);
            hp = (EditText) findViewById(R.id.hp);
            email = (EditText) findViewById(R.id.email);
            btnCek = (Button) findViewById(R.id.btnCek);
            btnBatal = (Button) findViewById(R.id.btnBatal);
            btnDaftar = (Button) findViewById(R.id.btnDaftar);

            String nikKey;

            final Context context = this;

            btnCek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            btnBatal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moveTaskToBack(true);
                    finish();
                    System.exit(0);
                }
            });

            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nikKey = nik.getText().toString();

                    if (nikKey.equals("1038")){
                        Intent intent = new Intent(MainActivityAdmin.this, masuk.class);
                        MainActivityAdmin.this.startActivity(intent);
                        finish();
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Harap Isi Semua Kolom").setNegativeButton("Anda Berhasil Daftar!", null).create().show();
                    }
                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Ini aksi untuk keluar
        int id = item.getItemId();

        if (id == R.id.action_keluar) {
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Ini Menu Navigasi
        int id = item.getItemId();

        if (id == R.id.nav_anggota) {
            fragment = new anggota();
            callFragment(fragment);
        } else if (id == R.id.nav_peminjaman) {
            fragment = new peminjaman();
            callFragment(fragment);
        } else if (id == R.id.nav_perpanjangan) {
            fragment = new perpanjang();
            callFragment(fragment);
        } else if (id == R.id.nav_pengembalian) {
            fragment = new pengembalian();
            callFragment(fragment);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_admin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //Ini untuk memanggil seluruh fragment
    private void callFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container_admin, fragment)
                .commit();
    }
}
