package com.secpisir.secpisir;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;

import java.util.Scanner;

public class MenuTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        NavigationView navigationView = (NavigationView) findViewById(R.id.menuNavigationView);
        if (navigationView != null) {
            navigationView.setItemIconTintList(null);
        }
    }

    @Override
    public boolean onNavigateUp() {
        return super.onNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        NavigationView navigationView = (NavigationView) findViewById(R.id.menuNavigationView);
        if (navigationView != null) {
            navigationView.setItemIconTintList(null);
            System.err.println("ALRIGHT");
            Scanner scan = new Scanner(System.in);
            scan.next();
        }
        else{
            navigationView.setItemIconTintList(null);
        }
    }
}
