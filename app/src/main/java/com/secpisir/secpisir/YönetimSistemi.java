package com.secpisir.secpisir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

class YönetimSistemi {

    private Map<String,String> kullaniciAdlari=new HashMap<>();
    private Map<String,String> kullaniciEmailleri=new HashMap<>();
    private Stack<Yemek> EklenenYemekler;
    private Stack<Icecek> EklenenIcecekler;
    private ArrayList<ArrayList<Yemek>> MalzemedenYemekler;
    private ArrayList<ArrayList<Icecek>> MalzemedenIcecekler;
    private PriorityQueue<Malzeme> SıkKullanılanlar;// heap;
    private LinkedList<String> LinkedList;
    private static Set<Kullanici> kullaniciSet=new HashSet<>();

    YönetimSistemi() throws IOException {
        listedenOku();
    }


    public LinkedList<Yemek> MalzemedenOner(int Tip){
        /*
        ///
         */
        LinkedList<Yemek> temp = new LinkedList<>();
        return temp;
    }

    public Yemek RastgeleOner(){
        /////
        Yemek temp = new Yemek();
        return temp;
        /////
    }
    public Boolean girisYap(){
        return true;/////
    }

    public Stack<Tüketilebilir> SonEklenenleriGöster(){
        Stack<Tüketilebilir> temp = new Stack<>();
        return temp;//////
    }

    boolean kullaniciDogrula(){
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

    private String listedenOku()throws IOException
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

    static void listeyeYaz()throws IOException
    {
        String COMMA_DELIMITER=";";
        String SEPARATOR="\n";
        String HEADER="İsim;Soyisim;Kullanıcı Adı;Şifre;Email;Favoriler;KaraListe";
        FileWriter filewriter= new FileWriter("src//main//java//com//gtu//secpisir//secpisir//kullanici.csv");

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








}
