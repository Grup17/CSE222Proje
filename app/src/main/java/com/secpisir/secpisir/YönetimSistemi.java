package com.secpisir.secpisir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class YönetimSistemi {

    private static Map<String,String> kullaniciAdlari = new HashMap<>();
    private static Map<String,String> kullaniciEmailleri = new HashMap<>();
    private static Stack<Yemek> EklenenYemekler;
    private static Stack<Icecek> EklenenIcecekler;
    private static ArrayList<Yemek> yemekler = new ArrayList<>(100);
    private static ArrayList<Icecek> icecekler;
    private static PriorityQueue<Malzeme> SıkKullanılanlar;// heap;
    private static LinkedList<String> LinkedList;
    private static Set<Kullanici> kullaniciSet = new HashSet<>();
    private static MapGraph<Yemek> yemeklerCizgesi = new MapGraph<>();

    YönetimSistemi() throws IOException {
        listedenKullanicilariOku();
        yemekler = new ArrayList<>(50);
    }

    public static ArrayList<Yemek> getYemekler() {
        return yemekler;
    }

    private ArrayList<Yemek> malzemedenYemekOner(ArrayList<Yemek> yemek, ArrayList<Malzeme> malzeme) throws IllegalArgumentException{

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
        malzemedenYemekOner(temp,malzeme);
        return temp;
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

    static boolean kullaniciDogrula(){
        return true;
    }
/*
    public Menu BuGununOnerisi(){

    }

    public Menu KullanıcıyaOzelOner(Kullanici kullanıcı){

    }
    public boolean tarifKabul(Yemek yeniyemek){

    }
*/

    private static String listedenKullanicilariOku()throws IOException
    {
        /* open csv file input stream*/
        BufferedReader reader = new BufferedReader(new FileReader("src//main//java//com//gtu//secpisir//secpisir//kullanici.csv"));
        /* read csv file line by line*/
        String line = null;
        int index = 0;
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(";");
            Kullanici kullanici=new Kullanici(scanner.next(),scanner.next(),scanner.next(),scanner.next(),
                    scanner.next(),scanner.next(), scanner.next(),scanner.next());
            kullaniciSet.add(kullanici);
            kullaniciAdlari.put(kullanici.getKullaniciAdi(),kullanici.getSifre());
            kullaniciEmailleri.put(kullanici.getKullaniciAdi(),kullanici.getSifre());
        }
        //close reader
        reader.close();
        return null;
    }

    public static void listeyeKullanicilariYaz()throws IOException
    {
        String COMMA_DELIMITER=";";
        String SEPARATOR="\n";
        String HEADER="İsim;Soyisim;Kullanıcı Adı;Şifre;Email;Favoriler;KaraListe";
        FileWriter filewriter= new FileWriter("src//main//java//com//secpisir//secpisir//kullanici.csv");

        filewriter.append(HEADER);
        for (Kullanici kullanici:kullaniciSet)
        {
            /*Respectively,function will be add information into the csv file.(separator,information,delimiter...*/
            filewriter.append(SEPARATOR);
            filewriter.append(kullanici.getIsim());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getSoyad());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getKullaniciAdi());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getSifre());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getEmail());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getFavoriListe().toString());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getKaraListe().toString());
            filewriter.append(COMMA_DELIMITER);
            filewriter.append(kullanici.getGecmis(0));
        }
        filewriter.flush();
        filewriter.close();

    }

    public static void yemekTarifleriniDosyadanOku() throws FileNotFoundException {
        File file = new File("src/main//java//com//secpisir//secpisir//yemek.csv");
        Scanner scanner = new Scanner(file);
        if(scanner.hasNext())
            //Skip the csv headings
            scanner.nextLine();

        while(scanner.hasNext()){
            String line = scanner.nextLine();
            Yemek yemek = new Yemek();
            //Yemek Adı;Malzemeler;Kategori;Kalori;Hazırlanış;Hazırlanma Süresi;
            String ingredientsWhole = line.split(";")[1];
            ArrayList<Malzeme> malzemeArrayList = new ArrayList<>(6);
            for (int i = 0; i < ingredientsWhole.split("-").length; i++) {
                Malzeme malzeme = new Malzeme();
                malzeme.setIsim(ingredientsWhole.split("-")[i]);
                malzemeArrayList.add(malzeme);
            }
            yemek.setIsim(line.split(";")[0]);
            yemek.setMalzemeler(malzemeArrayList);
            yemek.setKategori(line.split(";")[2]);
            yemek.setKalori(Integer.parseInt(line.split(";")[3]));
            yemek.setTarif(line.split(";")[4]);
            yemek.setTarifSuresi(line.split(";")[5]);
            yemekler.add(yemek);
        }
        for (Yemek yemek : yemekler) {
            for (Yemek yemek1 : yemekler) {
                int ortakMalzemeler = yemeklerinOrtakMalzemeSayisi(yemek, yemek1);
                yemeklerCizgesi.insert(yemek, yemek1, ortakMalzemeler);
            }
        }
    }

    static int yemeklerinOrtakMalzemeSayisi(Yemek first, Yemek second){
        int result = 0;
        for (Malzeme malzeme : first.getMalzemeler()) {
            for (Malzeme malzeme1 : second.getMalzemeler()) {
                if(malzeme.equals(malzeme1))
                    ++result;
            }
        }
        return result;
    }

}
