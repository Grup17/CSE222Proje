package com.gtu.secpisir.secpisir;

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

public class SliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images = {
            R.drawable.eat_icon,
            R.drawable.code_icon,
            R.drawable.eat_icon

    };
    public String[] slide_headings={"YEMEĞİN ADI","YEMEĞİN ADI","YEMEĞİN ADI"};
    public String[] slide_decripsions={"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit."};

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=(ImageView) view.findViewById(R.id.slide_image);
        TextView slide_head=(TextView) view.findViewById(R.id.slide_head);
        TextView slide_decs=(TextView) view.findViewById(R.id.slide_desc);


        slideImageView.setImageResource(slide_images[position]);
        slide_head.setText(slide_headings[position]);
        slide_decs.setText(slide_decripsions[position]);

        container.addView(view);



        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}


