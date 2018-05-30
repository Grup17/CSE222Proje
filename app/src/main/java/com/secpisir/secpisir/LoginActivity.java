package com.secpisir.secpisir;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    Button giris;
    EditText kullaniciAdi,sifre;
    public static final String kAdi = "nameKey";
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        giris = (Button)findViewById(R.id.button_giris_yap);
        kullaniciAdi = (EditText)findViewById(R.id.edit_kullaniciadi);
        sifre = (EditText)findViewById(R.id.edit_sifre);
        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        sp.edit().putBoolean("logged",true).apply();
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YönetimSistemi yönetimSistemi = new YönetimSistemi();
                yönetimSistemi.setKullaniciInputStream(getResources().openRawResource(R.raw.kullanici));
                yönetimSistemi.setYemekInputStream(getResources().openRawResource(R.raw.yemek));
                YönetimSistemi.listedenKullanicilariOku();
                if(yönetimSistemi.kullaniciDogrula( kullaniciAdi.getText().toString(),sifre.getText().toString())) {

                    String n  = kullaniciAdi.getText().toString();
                    sp.edit().putBoolean("logged",true).apply();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(kAdi, n);
                    editor.commit();
                    onLoginButtonClick(v);
                    sp.edit().putBoolean("logged",true).apply();
                }else{
                    Toast.makeText(getApplicationContext(), "Geçersiz " +
                            "kullanıcı adı ya da şifre",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onLoginButtonClick(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

    public void onRegisterButtonClick(View view){
        //setContentView(R.layout.activity_kayit);
        Intent intent = new Intent(this, KayitActivity.class);
        startActivity(intent);
    }

    public void onSideBarClick(View view){ view.requestFocus();}

    /* ------Menu Onclicks------- */
    public void menudenKaralisteye(MenuItem item) {
        Intent intent = new Intent(this, Karaliste.class);
        startActivity(intent);
    }
    public void menudenFavorilere(MenuItem item) {
        Intent intent = new Intent(this, Favoriler.class);
        startActivity(intent);
    }
    public void menudenTarifEklemeye(MenuItem item){
        Intent intent = new Intent(this, TarifEkle.class);
        startActivity(intent);
    }
    public void menudenGecmise (MenuItem item) {
        Intent intent = new Intent(this, Gecmis.class);
        startActivity(intent);
    }
    /* ------------- */
}
