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
        Integer yemekID = getIntent().getIntExtra("yemekID", -1);
        System.out.println("yemekID " + yemekID);
        yemek = YönetimSistemi.getYemek(yemekID);
        TextView tw = findViewById(R.id.textViewYemekTarifi);
        if(yemek == null)
            throw new IllegalStateException();
        String content = "Kalori: " + yemek.getKalori() + "\n";
        content += yemek.getTarif();
        tw.setText(content);
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