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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Malzeme))
            return false;
        return isim.equals(((Malzeme)obj).isim);
    }

    @Override
    public int hashCode() {
        return isim.hashCode();
    }
}