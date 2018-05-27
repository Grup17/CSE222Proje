package com.secpisir.secpisir;

public class Malzeme {
    private String isim;
    private int kod;

    public String getIsim() {
        return isim;
    }

    public int getKod() {
        return kod;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    @Override
    public String toString() { return isim; }
}