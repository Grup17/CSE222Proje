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
        this.setContentView(R.layout.yemek_tarifi);
        TextView tw = findViewById(R.id.textViewYemekTarifi);
        if(yemek == null)
            throw new IllegalStateException();
        if(tw == null)
            throw new IllegalStateException();
        String content = "Kalori: " + yemek.getKategori();
        System.out.println(yemek.getTarif());
        tw.setText(yemek.getTarif());
    }

    public static void setYemek(Yemek y){
        yemek = y;
        if(yemek == null)
            throw new IllegalStateException();
    }

    public static Yemek getYemek() {
        return yemek;
    }

    public void yemegiGecmiseEkle(View view){
        Kullanici k = YönetimSistemi.getKullanici();
        k.gecmiseEkle(yemek.getIsim());
    }
}