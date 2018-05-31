package com.secpisir.secpisir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KullaniciBilgileri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kullanici_bilgileri);
        /*TextView k_adi = findViewById(R.id.kullanici_adi);
        TextView k_soyadi = findViewById(R.id.soyad);
        TextView ad = findViewById(R.id.ad);
        TextView mail = findViewById(R.id.email);
        String adi = YönetimSistemi.getCurrentKullanici().getIsim().split(" ")[0];
        String soyadi = YönetimSistemi.getCurrentKullanici().getIsim().split(" ")[1];
        Kullanici k = YönetimSistemi.getCurrentKullanici();
        k_adi.setText(k.getKullaniciAdi());
        ad.append(adi);
        k_soyadi.append(soyadi);
        mail.append(k.getEmail());*/
    }
}
