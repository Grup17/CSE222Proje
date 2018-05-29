package com.secpisir.secpisir;
import java.util.ArrayList;

public class Yemek extends Tüketilebilir {

    private ArrayList<Malzeme> malzemeler;
    private String hazirlanis;
    private String kategori;
    private String isim;
    private String hazirlanisSuresi;
    private int code;

    public Yemek(){

    }
    public Yemek(ArrayList<Malzeme> yeniMalzemeler, String kategori ,String hazirlanis,String hazirlanisSuresi){

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
    public String getTarif() {
        return null;
    }

    @Override
    public int getKalori() {
        return Kalori;
    }

    public String getIsim() {
        return isim;
    }

    public int getCode() {
        return code;
    }

    public void setTarif(String hazirlanis) {
        this.hazirlanis = hazirlanis;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setTarifSuresi(String hazirlanisSuresi) {
        this.hazirlanisSuresi = hazirlanisSuresi;
    }

    public void setMalzemeler(ArrayList<Malzeme> malzemeler) {
        this.malzemeler = malzemeler;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setKalori(int kalori){
        this.Kalori = kalori;
    }
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return isim;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Yemek))
            return false;
        return isim.equals(((Yemek) obj).isim);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
