package com.secpisir.secpisir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

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
        if (yemek == null)
            throw new IllegalStateException();
        String content = "Kalori: " + yemek.getKalori() + "\n";
        content += yemek.getTarif();
        tw.setText(content);
    }

    public static void setYemek(Yemek y) {
        yemek = y;
        if (yemek == null)
            throw new IllegalStateException();
    }

    public static Yemek getYemek() {
        return yemek;
    }

    public void yemegiGecmiseEkle(View view) {
        if(YönetimSistemi.getCurrentKullanici()!=null) {
            Kullanici k = YönetimSistemi.getKullanici();
            //k.gecmiseEkle(yemek.getIsim());
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Bu özellik yalnızca kayıtlı"+
                    " kullanıcılar içindir...",Toast.LENGTH_SHORT).show();
        }
    }

    public void yemegiFavorilereEkle(View view) {
        if(YönetimSistemi.getCurrentKullanici()!=null) {
            Kullanici k = YönetimSistemi.getKullanici();
            //k.favorilereEkle(yemek.getIsim());
            Toast.makeText(getApplicationContext(), "Favorilere eklendi",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Bu özellik yalnızca kayıtlı"+
                    " kullanıcılar içindir...",Toast.LENGTH_SHORT).show();
        }
    }

    public void yemegiKaralisteyeEkle(View view){
        if(YönetimSistemi.getCurrentKullanici()!=null) {
            Kullanici k = YönetimSistemi.getKullanici();
          //  k.karaListeyeEkle(yemek.getIsim());
            Toast.makeText(getApplicationContext(), "Kara listeye eklendi",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Bu özellik yalnızca kayıtlı"+
            " kullanıcılar içindir...",Toast.LENGTH_SHORT).show();
            }
    }
}
