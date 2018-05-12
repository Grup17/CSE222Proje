package com.secpisir.secpisir;

import java.util.LinkedList;


public class denemeFavoriListesi {

    private LinkedList<String> deneme_favori=new LinkedList<>();

    public denemeFavoriListesi()
    {
        create();
    }

    private void create()
    {

        deneme_favori.add("batuhan");
        deneme_favori.add("çağrı");
        deneme_favori.add("ferhat");
        deneme_favori.add("osman");
        deneme_favori.add("sevgi");
        deneme_favori.add("simge");
    }
    public LinkedList<String> getDeneme_favori(){  return deneme_favori;}
    public int size(){ return deneme_favori.size();}

}