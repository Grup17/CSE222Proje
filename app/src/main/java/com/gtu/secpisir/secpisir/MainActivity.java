package com.gtu.secpisir.secpisir;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_giris);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        NavigationView navigationView = (NavigationView) findViewById(R.id.menuNavigationView);
        if (navigationView != null) {
            navigationView.setItemIconTintList(null);
        }

    }*/

    /*public void onLoginButtonClick(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }*/


    /*@Override
    protected void onStart() {
        super.onStart();
        View view = findViewById(R.id.view);
        view.setBackgroundColor(Color.RED);
    }*/

    public void onRegisterButtonClick(View view){
        //setContentView(R.layout.activity_kayit);
        //Intent intent = new Intent(this, KayitActivity.class);
        //startActivity(intent);
    }
}
