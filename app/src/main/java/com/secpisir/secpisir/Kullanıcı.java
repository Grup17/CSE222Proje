package com.secpisir.secpisir;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Kullanıcı {
    private LinkedList<Yemek> FavoriYemekler;
    private Map<String,LinkedList<Yemek>> karaListe;
    private Stack<Yemek> gecmis;
    private String kullanıIsmı;
    private Boolean girisYapı;

    public Stack<Yemek> getGecmis() {
        return gecmis;
    }

    public LinkedList<Yemek> getKaraListe(String key){
        return karaListe.get(key);
    }

    public LinkedList<Yemek> getKaraListeyeEkle(String key, Yemek yemek){
        karaListe.get(key).add(yemek);
        return karaListe.get(key);
    }

    public boolean favorilereEkle(Yemek yeniFavori){
        return  FavoriYemekler.add(yeniFavori);
    }

    public boolean favorilerdenÇıkar(Yemek yemek){
        return  FavoriYemekler.remove(yemek);
    }
/*
    public tarifEkle(Yemek yemek){
        //TODO arayüx ekle
    }*/
}
