package com.secpisir.secpisir;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FerhatMain extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter SliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.sliderViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        SliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(SliderAdapter);
        addDotindicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

    }


    public void addDotindicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for(int i = 0 ; i<mDots.length;i++){

            mDots[i] =new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);

        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotindicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void yemekTarifineGec(View view){
        Intent intent = new Intent(this, YemekTarifi.class);
        startActivity(intent);
    }
}