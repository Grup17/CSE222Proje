package com.secpisir.secpisir;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class favoriler extends AppCompatActivity implements favoriler_fragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriler);

        //TODO: kullanıcı sınıfından karaliste datafieldì ile işlemi yap
        denemeFavoriListesi deneme=new denemeFavoriListesi();
        final favoriler cntx = this;
        final LinearLayout linearly = findViewById(R.id.linearLayout_favoriler);
        //frame layout oluşturuldu
        for (int i=0;i<deneme.getDeneme_favori().size();++i)
        {
            FrameLayout flTest = new FrameLayout(cntx);
            int id = View.generateViewId();
            flTest.setId(id);
            linearly.addView(flTest);
            addFragment(id,deneme.getDeneme_favori().get(i));
        }
    }

    @Override
    public void onFragmentClose(favoriler_fragment fr) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fr);
        fragmentTransaction.commit();
    }

    protected void addFragment(int id, String text) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        favoriler_fragment fav = favoriler_fragment.newInstance(text);
        fragmentTransaction.add(id, fav);
        fragmentTransaction.commit();
    }
}
