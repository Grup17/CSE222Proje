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
            YönetimSistemi.getCurrentKullanici().getGecmis().add(yemek.getIsim());
            //k.gecmiseEkle(yemek.getIsim());
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Bu özellik yalnızca kayıtlı"+
                    " kullanıcılar içindir...",Toast.LENGTH_SHORT).show();
        }
    }

    public void yemegiFavorilereEkle(View view) {
        if(YönetimSistemi.getCurrentKullanici()!=null &&
                !YönetimSistemi.getCurrentKullanici().getKaraListe().contains(yemek.getIsim())) {
            YönetimSistemi.getCurrentKullanici().getFavoriListe().add(yemek.getIsim());
            //k.favorilereEkle(yemek.getIsim());
            Toast.makeText(getApplicationContext(), yemek.getIsim() +" Favorilere eklendi",Toast.LENGTH_LONG).show();
        }
        else if(YönetimSistemi.getCurrentKullanici().getFavoriListe().contains(yemek.getIsim())){
            Toast.makeText(getApplicationContext(), "Eklemek istediğiniz yemek"+
                    " zaten favorilerinizde mevcut.",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Bu özellik yalnızca kayıtlı"+
                    " kullanıcılar içindir...",Toast.LENGTH_SHORT).show();
        }
    }

    public void yemegiKaralisteyeEkle(View view){
        if(YönetimSistemi.getCurrentKullanici()!=null &&
        !YönetimSistemi.getCurrentKullanici().getFavoriListe().contains(yemek.getIsim())) {
            YönetimSistemi.getCurrentKullanici().getKaraListe().add(yemek.getIsim());
          //  k.karaListeyeEkle(yemek.getIsim());
            Toast.makeText(getApplicationContext(), "Kara listeye eklendi",Toast.LENGTH_LONG).show();
        }
        else if(YönetimSistemi.getCurrentKullanici().getKaraListe().contains(yemek.getIsim())){
            Toast.makeText(getApplicationContext(), "Eklemek istediğiniz yemek"+
                    " zaten kara listede mevcut.",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Bu özellik yalnızca kayıtlı"+
            " kullanıcılar içindir...",Toast.LENGTH_SHORT).show();
            }
    }
}
