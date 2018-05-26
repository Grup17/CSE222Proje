package com.secpisir.secpisir;


import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

import static com.secpisir.secpisir.YönetimSistemi.listeyeYaz;

public class Kullanici {

    private BinarySearchTree<String> favoriler;
    private BinarySearchTree<String>  karaListe;
    private Stack<String> gecmis= new Stack<>();
    private boolean girisYap=false;
    private String kullaniciAdi;
    private String isim;
    private String soyad;
    private String sifre;
    private String email;

    public Kullanici(String isim, String soyad, String kullaniciAdi, String sifre, String email
            , String favoriler, String karaliste,String gecmis){
        this.email=email;
        this.isim=isim;
        this.soyad=soyad;
        this.sifre=sifre;
        this.kullaniciAdi =kullaniciAdi;
        this.favoriler=setListe(favoriler);
        this.karaListe=setListe(karaliste);
        setGecmis(gecmis);
    }


    public boolean karaListeyeEkle(String yemek)  {
        if (favoriler.contains(yemek))
            return false;
        Boolean check=karaListe.add(yemek);
        try {
            listeyeYaz();
        } catch (IOException e) {
            return false;
        }
        return check;
    }

    public boolean karaListedenCıkar(String yemek) {
        Boolean check=karaListe.remove(yemek);
        try {
            listeyeYaz();
        } catch (IOException e) {
            return false;
        }
        return check;
    }
    //
    public boolean favorilereEkle(String yemek) {
        if (karaListe.contains(yemek))
            return false;
        Boolean check=favoriler.add(yemek);
        try {
            listeyeYaz();
        } catch (IOException e) {
            return false;
        }
        return check;
    }
    //
    public boolean favorilerdenCıkar(String yemek) {
        Boolean check=favoriler.remove(yemek);
        try {
            listeyeYaz();
        } catch (IOException e) {
            return false;
        }
        return check;
    }

    boolean gecmiseEkle(String yemek){
        Boolean check=gecmis.add(yemek);
        try {
            listeyeYaz();
        } catch (IOException e) {
            return false;
        }
        return check;
    }
    boolean gecmistenSil(String yemek){
        Boolean check=gecmis.remove(yemek);
        try {
            listeyeYaz();
        } catch (IOException e) {
            return false;
        }
        return check;
    }


    private BinarySearchTree<String> setListe(String yemekler)
        {
        //TODO String ile arama sorun olursa yemek objesi oluşturulacak
        BinarySearchTree<String> yemekListesi=new BinarySearchTree<>() ;
        String[] data = yemekler.split("-");
        for(int i=0;i<data.length;++i)
            yemekListesi.add(data[i]);
        return yemekListesi;
    }

    void  setGecmis(String gecmis) {
        String[] data = gecmis.split("-");
        for(int i=data.length-1;i>=0;--i)
            this.gecmis.push(data[i]);
    }
    public Stack<String> getGecmis() {
        return gecmis;
    }

    public String getGecmis(int ignore){
        StringBuilder sb=new StringBuilder();
        Iterator<String> iter=gecmis.iterator();
        if(iter.hasNext())
        {
            do {
                sb.append(iter.next());
            }while (iter.hasNext() && sb.append("-")!=null);
        }else
            sb.append(0);
        return sb.toString();
    }
    public BinarySearchTree<String> getKaraListe(){
        return karaListe;
    }
    public BinarySearchTree<String> getFavoriListe() {
        return favoriler;
    }

    String getKullaniciAdi() { return kullaniciAdi; }

    String getEmail() { return email; }

    String getSifre() { return sifre; }

    void setSifre(String sifre) { this.sifre = sifre; }

    public String getIsim() { return isim; }

    public void setIsim(String isim) { this.isim = isim; }

    public String getSoyad() { return soyad; }

    public void setSoyad(String soyad) { this.soyad = soyad; }



/*
    public tarifEkle(Yemek yemek){
        //TODO arayüx ekle
    }*/
}
