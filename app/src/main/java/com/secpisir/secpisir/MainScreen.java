package com.secpisir.secpisir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
    }

    public void menudenKaralisteye(MenuItem item) {
        Intent intent = new Intent(this, karaliste.class);
        startActivity(intent);
    }

    public void menudenFavorilere(MenuItem item) {
        Intent intent = new Intent(this, favoriler.class);
        startActivity(intent);
    }

    public void anaEkrandanAramaya(View view) {
        Log.i("TAG", "deneme");
        Intent intent = new Intent(this, IngredientActivity.class);
        startActivity(intent);
    }

    public void anaEkrandanKategorilere(View view) {
        Intent intent = new Intent(this, KategorilerActivity.class);
        startActivity(intent);
    }

    public void anaEkrandanRastgeleye(View view) {
        setContentView(R.layout.rastgele);
    }
}
