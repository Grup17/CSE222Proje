package com.secpisir.secpisir;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class KayitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

    }
    public void kayit(View view){
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
