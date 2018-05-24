package com.gtu.secpisir.secpisir;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

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
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
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

    public void menudenKaralisteye(MenuItem item){
        Intent intent = new Intent(this, karaliste.class);
        startActivity(intent);
    }

    public void menudenFavorilere(MenuItem item) {
        Intent intent = new Intent(this, favoriler.class);
        startActivity(intent);
    }
}
