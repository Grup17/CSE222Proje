package com.secpisir.secpisir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MenuYoneticisi extends AppCompatActivity{

    public void menudenKaralisteye(MenuItem item){
        Intent intent = new Intent(this, Karaliste.class);
        startActivity(intent);
    }

    public void menudenFavorilere(MenuItem item) {
        Intent intent = new Intent(this, Favoriler.class);
        startActivity(intent);
    }

    public void menudenGecmis(MenuItem item) {
        Intent intent = new Intent(this, Gecmis.class);
        startActivity(intent);
    }

}
