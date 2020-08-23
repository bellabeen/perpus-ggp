package com.vika.ggf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.google.android.material.navigation.NavigationView;


public class masuk extends AppCompatActivity {
    EditText nomerindek, katasandi;
    Button btnMasuk, btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masuk);

        nomerindek = (EditText) findViewById(R.id.nomerindek);
        katasandi = (EditText) findViewById(R.id.katasandi);
        btnMasuk = (Button) findViewById(R.id.btnMasuk);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);

        String usernameKey;

        final Context context = this;

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = nomerindek.getText().toString();
                String passwordKey = katasandi.getText().toString();

                if (usernameKey.equals("1032") && passwordKey.equals("1032")) {

                    Toast.makeText(getApplicationContext(), "Anda Berhasil Masuk", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(masuk.this, MainActivity.class);
                    masuk.this.startActivity(intent);
                    finish();
                }
                else if (usernameKey.equals("1038") && passwordKey.equals("1038")) {

                    Toast.makeText(getApplicationContext(), "Anda Berhasil Masuk Sebagai Admin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(masuk.this, MainActivityAdmin.class);
                    masuk.this.startActivity(intent);
                    finish();
                }

                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Nomor Indek atau Kata Sandi Anda Salah!").setNegativeButton("Coba Lagi", null).create().show();
                }
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(masuk.this, register.class);
                masuk.this.startActivity(intent);
            }
        });
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.masuk, container, false);
        return view;
    }

}