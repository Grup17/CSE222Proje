package com.secpisir.secpisir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class YemekTarifi extends AppCompatActivity {
    private static Yemek yemek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tw = findViewById(R.id.textViewYemekTarifi);
        String content = "Kalori: " + yemek.getKategori();
        tw.setText(yemek.getTarif());
        this.setContentView(R.layout.yemek_tarifi);
    }

    public static void setYemek(Yemek y){
        yemek = y;
    }

    public void yemegiGecmiseEkle(View view){
        Kullanici k = YönetimSistemi.getKullanici();
        k.gecmiseEkle(yemek.getIsim());
    }
}