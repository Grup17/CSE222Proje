import java.util.LinkedList;

public class Yemek extends Tüketilebilir {

    private LinkedList<Malzeme> malzemeler;
    private Hazırlanıs hazirlanis;
    private String kategori;
    private int hazirlanisSuresi;


    public Yemek(){

    }
    public Yemek(LinkedList<Malzeme> yeniMalzemeler, String kategori ,Hazırlanıs hazirlanis,int hazirlanisSuresi){

        malzemeler = yeniMalzemeler;
        this.kategori = kategori;
        this.hazirlanis = hazirlanis;
        this.hazirlanisSuresi = hazirlanisSuresi;

    }

    public LinkedList<Malzeme> getMalzemeler() {
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
