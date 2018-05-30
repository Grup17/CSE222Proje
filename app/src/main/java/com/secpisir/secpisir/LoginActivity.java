package com.secpisir.secpisir;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        //Button button = findViewById(R.id.button);
        //button.setOnClickListener(loginButtonListener);
        //View view = findViewById(R.id.view);
        //view.setBackgroundColor(Color.BLACK);
    }

    public String[] returnLoginCredentials(){
        //setContentView(R.layout.activity_mainscreen);
        /*try {
            EditText userName = (EditText) findViewById(R.id.editText);
            String[] result = new String[2];
            result[1] = userName.getText().toString();
            //System.out.println("RESULT IS " + result[1]);
            Log.i("TAG", result[0]);
            return result;
        }
        catch(Throwable e){
            Log.i("TAG", e.getMessage());
        }*/
        return null;
    }

    public void onLoginButtonClick(View view){
        EditText editTextS = findViewById(R.id.editTextSifre);
        EditText editTextK = findViewById(R.id.editTextKAdi);
        Set<Kullanici> set = YönetimSistemi.getKullaniciSet();
        Kullanici k = YönetimSistemi.kullaniciDogrula(editTextK.getText().toString(), editTextS.getText().toString());
        YönetimSistemi.setKullanici(k);
        if(k != null) {
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);
        }
    }

    public void onRegisterButtonClick(View view){
        //setContentView(R.layout.activity_kayit);
        Intent intent = new Intent(this, KayitActivity.class);
        startActivity(intent);
    }

    public void onSideBarClick(View view){ view.requestFocus();}

    /*public View.OnClickListener loginButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setContentView(R.layout.activity_menu_test);
        }
    };*/

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
    public void misafirButonu(View v){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
        YönetimSistemi.setKullanici(null);
    }
}
