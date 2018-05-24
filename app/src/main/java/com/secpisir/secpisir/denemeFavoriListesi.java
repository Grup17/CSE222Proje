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

        deneme_favori.add("Ali Nazik");
        deneme_favori.add("Hünkar Beğendi");
        deneme_favori.add("Mantı");
        deneme_favori.add("Enginar");
        deneme_favori.add("Kıymalı Makarna");
        deneme_favori.add("Mercimek Çorbası");
    }
    public LinkedList<String> getDeneme_favori(){  return deneme_favori;}
    public int size(){ return deneme_favori.size();}

}