package com.secpisir.secpisir;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class YönetimSistemi extends AppCompatActivity {
    static Context context;
    static Map<String,String> kullaniciAdlari = new HashMap<>();
    private static Map<String,String> kullaniciEmailleri = new HashMap<>();
    private static Stack<Yemek> EklenenYemekler;
    private static Stack<Icecek> EklenenIcecekler;
    private static ArrayList<Yemek> yemekler = new ArrayList<>(100);
    private static ArrayList<Icecek> icecekler;
    //private static PriorityQueue<Malzeme> SıkKullanılanlar;// heap;
    private static ArrayList<Malzeme> malzemeler = new ArrayList<>(40);
    static Set<Kullanici> kullaniciSet = new HashSet<>();
    private static ListGraph yemeklerCizgesi = new ListGraph(50, false);
    private static InputStream kullanicilarStream;
    private static InputStream yemeklerStream;
    private static OutputStream kullaniciOutputStream;

    private static Kullanici currentKullanici;
    public static Kullanici getKullanici(){ return currentKullanici; }

    YönetimSistemi() {    }
    YönetimSistemi(Context context) { this.context=context;   }

    public static ArrayList<Yemek> getYemekler() {
        return yemekler;
    }
    public static ArrayList<Malzeme> getMalzemeler() { return malzemeler; }

    public static void setKullaniciOutputStream(OutputStream op) { YönetimSistemi.kullaniciOutputStream = op; }

    /**current kullanıcı için setter*/
    public void setCurrentKullanici(String currentKullaniciAdi) {
        for(Kullanici kullanici:kullaniciSet)
            if(kullanici.getKullaniciAdi().equals(currentKullaniciAdi))
            {
                this.currentKullanici=kullanici;
                break;
            }
    }

    public void setYemekInputStream(InputStream is){ yemeklerStream = is;}
    public void setKullaniciInputStream(InputStream is){ kullanicilarStream = is; }

    public static Set<Kullanici> getKullaniciSet() {
        return kullaniciSet;
    }

    public static Yemek getYemek(int index){
        if(index > yemekler.size())
            throw new IndexOutOfBoundsException();
        return yemekler.get(index);
    }
    public static Malzeme getMalzeme(int index){
        return malzemeler.get(index);
    }
    public static ArrayList<String> getMalzemeIsimleri(){
        ArrayList<String> result = new ArrayList<>(malzemeler.size());
        for (Malzeme malzeme : malzemeler) {
            result.add(malzeme.getIsim());
        }
        return result;
    }

    private static ArrayList<Yemek> malzemedenYemekOnerRecursive(ArrayList<Yemek> yemek, ArrayList<Malzeme> malzeme) throws IllegalArgumentException{
        if(malzeme.size() < 1 )
            throw new IllegalArgumentException("Malzemenin size'ını düzgün gönder");
        ArrayList<Yemek> temp = new ArrayList<>();
        for (int i = 0 ;i < yemek.size() ;i ++){
            if(yemek.get(i).containsMalzeme(malzeme.get(malzeme.size()-1))){
                temp.add(yemek.get(i));
            }
        }
        malzeme.remove(malzeme.size()-1);
        if (malzeme.size() == 0)
            return yemek;
        malzemedenYemekOnerRecursive(temp,malzeme);
        return temp;
    }

    public static ArrayList<Yemek> malzemedenYemekOner(ArrayList<Malzeme> secilenMalzemeler){
        ArrayList<Yemek> result = new ArrayList<>(yemekler);
        result = malzemedenYemekOnerRecursive(result, secilenMalzemeler);
        return result;
    }

    public static Yemek RastgeleOner(){
        Random random = new Random();
        int index = random.nextInt(yemekler.size());
        return yemekler.get(index);
    }

    public static Boolean girisYap(){
        return true;/////
    }

    public static Stack<Tüketilebilir> SonEklenenleriGöster(){
        Stack<Tüketilebilir> temp = new Stack<>();
        return temp;//////
    }

    static boolean kullaniciDogrula(String kullaniciAdi, String sifre){
        if(kullaniciAdlari.containsKey(kullaniciAdi) && kullaniciAdlari.get(kullaniciAdi).equals(sifre))
            return true;
        else
            return false;
    }
/*
    public Menu BuGununOnerisi(){

    }

    public Menu KullanıcıyaOzelMenuOner(Kullanici kullanıcı){

    }
    public boolean tarifKabul(Yemek yeniyemek){

    }
*/

    public static ArrayList<Yemek> kullaniciyaOzelYemekOner(Kullanici kullanici){
        ArrayList<Yemek> favorilerListesi = new ArrayList<>(30);
        ArrayList<Yemek> result = new ArrayList<>(20);
        for (String s: kullanici.getFavoriListe()) {
            for (Yemek yemek : yemekler) {
                if(s.equals(yemek.getIsim())) {
                    //System.out.println("adding " + yemek);
                    favorilerListesi.add(yemek);
                }
                //else
                //System.out.println(s + "was not equal to " + yemek.getIsim());
            }
        }
        for (Yemek yemek : yemekler) {
            for (Yemek yemek1 : favorilerListesi) {
                Edge e = yemeklerCizgesi.getEdge(yemek.getCode(), yemek1.getCode());
                if(e != null && e.getWeight() >= 2)
                    //TODO: use priority queue to determine suggestion priority
                    if(!result.contains(yemek))
                        result.add(yemek);
            }
        }
        return result;
    }

    public static String listedenKullanicilariOku() {
        Scanner scan = new Scanner(kullanicilarStream);
        //BufferedInputStream is = new BufferedInputStream()
        /* read csv file line by line*/
        String line = null;
        int index = 0;
        line = scan.nextLine();
        while (line != null) {
            try {
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(";");
                Kullanici kullanici = new Kullanici(scanner.next(), scanner.next(), scanner.next(), scanner.next(),
                        scanner.next(), scanner.next(), scanner.next(), scanner.next());
                kullaniciSet.add(kullanici);
                kullaniciAdlari.put(kullanici.getKullaniciAdi(), kullanici.getSifre());
                kullaniciEmailleri.put(kullanici.getKullaniciAdi(), kullanici.getSifre());
                line = scan.nextLine();
            }
            catch(NoSuchElementException e){
                line = null;
            }
        }
        //close reader
        scan.close();
        for (Kullanici k:kullaniciSet)
        {
            System.out.println(k.getKullaniciAdi());
        }
        return null;
    }

    public static boolean listeyeKullanicilariYaz()throws IOException
    {
        FileOutputStream fos =context.openFileOutput(String.valueOf(R.raw.kullanici), Context.MODE_PRIVATE);
        String COMMA_DELIMITER=";";
        byte comma[]=COMMA_DELIMITER.getBytes();
        String SEPARATOR="\n";
        byte separator[]=SEPARATOR.getBytes();
        String HEADER="İsim;Soyisim;Kullanıcı Adı;Şifre;Email;Favoriler;KaraListe";
        byte header[]=HEADER.getBytes();
        fos.write(header);
        for (Kullanici kullanici:kullaniciSet)
        {
            /*Respectively,function will be add information into the csv file.(separator,information,delimiter...*/
            fos.write(separator);
            fos.write(kullanici.getIsim().getBytes());
            fos.write(comma);
            fos.write(kullanici.getSoyad().getBytes());
            fos.write(comma);
            fos.write(kullanici.getKullaniciAdi().getBytes());
            fos.write(comma);
            fos.write(kullanici.getSifre().getBytes());
            fos.write(comma);
            fos.write(kullanici.getEmail().getBytes());
            fos.write(comma);
            fos.write(kullanici.getListe(kullanici.getFavoriListe()).getBytes());
            fos.write(comma);
            fos.write(kullanici.getListe(kullanici.getKaraListe()).getBytes());
            fos.write(comma);
            fos.write(kullanici.getListe(kullanici.getGecmis()).getBytes());
        }
        fos.flush();
        fos.close();
        return true;
    }

    public static void yemekTarifleriniDosyadanOku() {
        Scanner scanner = new Scanner(yemeklerStream);
        if(scanner.hasNext())
            //Skip the csv headings
            scanner.nextLine();
        int mealCode = 0, ingredientCode = 0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Yemek yemek = new Yemek();
            //Yemek Adı;Malzemeler;Kategori;Kalori;Hazırlanış;Hazırlanma Süresi;
            String ingredientsWhole = line.split(";")[1];
            ArrayList<Malzeme> malzemeArrayList = new ArrayList<>(6);
            for (int i = 0; i < ingredientsWhole.split("-").length; i++) {
                Malzeme malzeme = new Malzeme();
                malzeme.setIsim(ingredientsWhole.split("-")[i]);
                malzeme.setKod(ingredientCode);
                malzemeArrayList.add(malzeme);
                if(!malzemeler.contains(malzeme)) {
                    /* Add to main ingredients list while reading from file */
                    //System.out.println("Added " + malzeme.getIsim() + " to malzemeler");
                    ++ingredientCode;
                    malzeme.setKod(ingredientCode);
                    malzemeler.add(malzeme);

                }
                else {
                    int existingMealCode = malzemeler.indexOf(malzeme);
                    malzeme.setKod(existingMealCode);
                }
            }
            yemek.setIsim(line.split(";")[0]);
            yemek.setMalzemeler(malzemeArrayList);
            yemek.setKategori(line.split(";")[2]);
            yemek.setKalori(Integer.parseInt(line.split(";")[3]));
            yemek.setTarif(line.split(";")[4]);
            yemek.setTarifSuresi(line.split(";")[5]);
            yemek.setCode(mealCode);
            yemekler.add(yemek);
            ++mealCode;
        }
        for (Yemek yemek : yemekler) {
            for (Yemek yemek1 : yemekler) {
                int ortakMalzemeler = yemeklerinOrtakMalzemeSayisi(yemek, yemek1);
                if((!yemek.equals(yemek1))) {
                    yemeklerCizgesi.insert(yemek.getCode(), yemek1.getCode(), ortakMalzemeler);
                    //System.out.println("inserted " + yemek + " " + yemek1 + " " + ortakMalzemeler);
                    if(yemek.toString().equals("Kakaolu Islak Kek") && yemek1.toString().equals("Keşkül")) {
                        System.out.println("Ortal malzemeleri: " + ortakMalzemeler);
                        System.out.println("graphtaki Ortak malzemeleri: " + yemeklerCizgesi.getEdge(yemek.getCode(),yemek1.getCode()).getWeight());
                    }
                }
            }
        }
        scanner.close();
        Yemek yemek = yemekler.get(18);
        Yemek yemek1 = yemekler.get(15);
        if(yemek.toString().equals("Kakaolu Islak Kek") && yemek1.toString().equals("Keşkül"))
            System.out.println("graphtaki Ortal malzemeleri: " + yemeklerCizgesi.getEdge(yemek.getCode(),yemek1.getCode()).getWeight());
    }

    static int yemeklerinOrtakMalzemeSayisi(Yemek first, Yemek second){
        int result = 0;
        for (Malzeme malzeme : first.getMalzemeler()) {
            for (Malzeme malzeme1 : second.getMalzemeler()) {
                if(malzeme.getKod() == malzeme1.getKod())
                    ++result;
            }
        }
        return result;
    }

    static int cizgedenOrtakMalzemeler(Yemek first, Yemek second){
        Edge edge = yemeklerCizgesi.getEdge(first.getCode(),second.getCode());
        if(edge == null)
            return -1;
        System.out.println("first is " + first + " second is " + second + " and weight is " + edge.getWeight());
        return edge.getWeight();
    }

}
