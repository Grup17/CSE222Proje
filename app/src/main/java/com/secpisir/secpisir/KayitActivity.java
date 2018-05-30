package com.secpisir.secpisir;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class KayitActivity extends Activity {

    Button kayit;
    EditText isim_edit,soyad_edit,mail_edit,sifre_edit,sifre_tekrar_edit,kullanici_adi_edit;
    //PostClass post = new PostClass();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
        kayit = (Button) findViewById(R.id.button_kayit_ol);
        isim_edit = (EditText) findViewById(R.id.edit_ad);
        soyad_edit = (EditText) findViewById(R.id.edit_soyad);
        mail_edit = (EditText) findViewById(R.id.edit_email);
        sifre_edit = (EditText) findViewById(R.id.edit_sifre);
        sifre_tekrar_edit = (EditText) findViewById(R.id.edit_sifre_tekrar);
        kullanici_adi_edit = (EditText) findViewById(R.id.edit_kullaniciadi);

        kayit.setOnClickListener(new View.OnClickListener() {//Kayıt ol butonuna tıklanınca
            @Override
            public void onClick(View v) {
                String isim,soyad,mail,sifre,sifre_tekrar,hata_mesaji=" ",kullanici_adi;
                boolean hata = false;
                // TODO Auto-generated method stub
                //Edittextlerden bilgileri aldık
                isim = isim_edit.getText().toString();
                soyad = soyad_edit.getText().toString();
                mail = mail_edit.getText().toString();
                sifre = sifre_edit.getText().toString();
                sifre_tekrar = sifre_tekrar_edit.getText().toString();
                kullanici_adi = kullanici_adi_edit.getText().toString();


                YönetimSistemi yönetimSistemi=new YönetimSistemi(getApplicationContext());
                yönetimSistemi.setKullaniciInputStream(getResources().openRawResource(R.raw.kullanici));
                yönetimSistemi.setYemekInputStream(getResources().openRawResource(R.raw.yemek));
                yönetimSistemi.listedenKullanicilariOku();


                if(kullanici_adi.length()<3 || kullanici_adi.contains("/")|| kullanici_adi.contains("\\")
                        || kullanici_adi.contains("@")|| kullanici_adi.contains("{")|| kullanici_adi.contains("}")||
                        kullanici_adi.contains("[")|| kullanici_adi.contains("]")|| kullanici_adi.contains("(")||
                        kullanici_adi.contains(")")|| kullanici_adi.contains("&"))
                {
                    hata=true;
                    hata_mesaji="Kullanıcı adı uzunluğu en az 3 karakter içermeli ve geçersiz karakterler içermemeli.";
                }
                else if (yönetimSistemi.kullaniciAdlari.containsKey(kullanici_adi)){
                    hata=true;
                    hata_mesaji="Bu kullanıcı adı daha önceden alınmış.";
                }
                else if (isim.matches("") || mail.matches("") || sifre.matches("") || sifre_tekrar.matches("")) {// boş veri var mı kontrolü
                    hata = true;
                    hata_mesaji = "Gerekli alanları doldurunuz.";
                } else if (!sifre.matches(sifre_tekrar)) {//şifreler uyuşuyor mu kontrolü
                    hata = true;
                    hata_mesaji = "Şifreler uyuşmuyor.";
                } else if (sifre.length()< 8) {//şifre karakter sayısı kontrolü
                    hata_mesaji = "Şifre 8 karakterden az olamaz.";
                    hata = true;
                } else if (!isEmailValid(mail)) {//Mail format kontrol
                    hata_mesaji = "Yanlış e-mail formatı!!!";
                    hata = true;
                }
                if(hata)
                    Toast.makeText(getApplicationContext(),hata_mesaji ,Toast.LENGTH_SHORT).show();
                else
                {
                   Kullanici yeni=new Kullanici( isim,  soyad,  kullanici_adi,  sifre,  mail,"",  "","");
                   yönetimSistemi.kullaniciSet.add(yeni);
                    try {
                        yönetimSistemi.listeyeKullanicilariYaz();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    kayit(v);
                }
            }
        });
    }
    private boolean isEmailValid(String mail) {
        if(mail.endsWith("@gmail.com")|| mail.endsWith("@hotmail.com") ||
                mail.endsWith("@outlook.com") || mail.endsWith("@gtu.edu.tr"))
            return true;
        else return false;
    }
    public void kayit(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
