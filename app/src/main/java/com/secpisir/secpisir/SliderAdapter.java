package com.secpisir.secpisir;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    int sliderSize;
    public int[] slide_images;
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context, int sliderSize){
        this.context=context;
        this.sliderSize = sliderSize;
        slide_images = new int[sliderSize];
        for (int i = 0; i < sliderSize; i++) {
            if(i%2 == 0)
                slide_images[i] = R.drawable.code_icon;
            else
                slide_images[i] = R.drawable.eat_icon;
        }
    }

    public String[] slide_headings={"YEMEĞİN ADI","YEMEĞİN ADI","YEMEĞİN ADI"};
   // public String[] slide_decripsions={"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit."};

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

   /*    public void setSlideDescriptions(String[] strings){
        slide_decripsions = strings;
    }*/

    public void setSlideHeading(String[] strings){
        slide_headings = strings;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView= view.findViewById(R.id.slide_image);
        TextView slide_head= view.findViewById(R.id.slide_head);
        TextView slide_decs= view.findViewById(R.id.slide_desc);


        slideImageView.setImageResource(slide_images[position]);
        slide_head.setText(slide_headings[position]);

        Yemek yemek=YönetimSistemi.getYemek(YönetimSistemi.getYemek(slide_headings[position]));

        slide_decs.setText(yemek.getMalzemelerString());

        container.addView(view);



        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}



