package com.secpisir.secpisir;
import java.util.ArrayList;

public class Yemek extends Tüketilebilir {

    private ArrayList<Malzeme> malzemeler;
    private Hazırlanıs hazirlanis;
    private String kategori;
    private int hazirlanisSuresi;


    public Yemek(){

    }
    public Yemek(ArrayList<Malzeme> yeniMalzemeler, String kategori ,Hazırlanıs hazirlanis,int hazirlanisSuresi){

        malzemeler = yeniMalzemeler;
        this.kategori = kategori;
        this.hazirlanis = hazirlanis;
        this.hazirlanisSuresi = hazirlanisSuresi;

    }

    public boolean containsMalzeme(Malzeme malzeme){
        for (Malzeme malzeme1 : malzemeler) {
            if(malzeme1.equals(malzeme))
                return true;
        }
        return false;
    }

    public ArrayList<Malzeme> getMalzemeler() {
        return malzemeler;
    }

    public String getKategori(){
        return kategori;
    }

    @Override
    public String getMalzeme() {
        return null;
    }

    @Override
    public Hazırlanıs getTarif() {
        return null;
    }

    @Override
    public int getKalori() {
        return Kalori;
    }
}
