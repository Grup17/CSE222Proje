package com.secpisir.secpisir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MenuYoneticisi extends AppCompatActivity{

    public void menudenKaralisteye(){
        Intent intent = new Intent(this, karaliste.class);
        startActivity(intent);
    }

    public void menudenFavorilere(MenuItem item) {
        Intent intent = new Intent(this, favoriler.class);
        startActivity(intent);
    }
}
