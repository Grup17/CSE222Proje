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
import java.util.List;
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
    //private static PriorityQueue<Malzeme> SıkKullanılanlar;// heap;
    private static ArrayList<Malzeme> malzemeler = new ArrayList<>(40);
    private static LinkedList<String> LinkedList;
    private static Set<Kullanici> kullaniciSet = new HashSet<>();
    private static ListGraph yemeklerCizgesi = new ListGraph(50, false);

    YönetimSistemi() throws IOException {
        listedenKullanicilariOku();
        yemekler = new ArrayList<>(50);
    }

    public static ArrayList<Yemek> getYemekler() {
        return yemekler;
    }

    public static Set<Kullanici> getKullaniciSet() {
        return kullaniciSet;
    }

    public static Yemek getYemek(int index){
        if(index > yemekler.size())
            throw new IndexOutOfBoundsException();
        return yemekler.get(index);
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

    public static String listedenKullanicilariOku()throws IOException
    {
        /* open csv file input stream*/
        BufferedReader reader = new BufferedReader(new FileReader("src//main//java//com//secpisir//secpisir//kullanici.csv"));
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
                    System.out.println("Added " + malzeme.getIsim() + " to malzemeler");
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
                        System.out.println("graphtaki Ortal malzemeleri: " + yemeklerCizgesi.getEdge(yemek.getCode(),yemek1.getCode()).getWeight());
                    }
                }
            }
        }
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
