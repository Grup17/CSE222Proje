package com.secpisir.secpisir;

import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        NavigationView navigationView = findViewById(R.id.menuNavigationView);
        if (navigationView != null) {
            navigationView.setItemIconTintList(null);
        }
        //toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //setSupportActionBar(toolbar);


        //MenuFragment menuFragment = new MenuFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }

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
