package com.secpisir.secpisir;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class karaliste extends AppCompatActivity implements karaliste_fragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karaliste);

        //TODO: kullanıcı sınıfından karaliste datafieldì ile işlemi yap
        DenemeListesi deneme=new DenemeListesi();
        final karaliste cntx = this;
        final LinearLayout linearly = findViewById(R.id.linearLayout_karaliste);
        //frame layout oluşturuldu
        for (int i=0;i<deneme.getDeneme_liste().size();++i)
        {
            FrameLayout flTest = new FrameLayout(cntx);
            int id = View.generateViewId();
            flTest.setId(id);
            linearly.addView(flTest);
            addFragment(id,deneme.getDeneme_liste().get(i));
        }
    }

    @Override
    public void onFragmentClose(karaliste_fragment fr) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fr);
        fragmentTransaction.commit();
    }

    protected void addFragment(int id, String text) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        karaliste_fragment kara =  karaliste_fragment.newInstance(text);
        fragmentTransaction.add(id,kara);
        fragmentTransaction.commit();
    }
}