package com.secpisir.secpisir;
import android.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

class YönetimSistemi {

    private IkiliAramaAgaci<Pair<Kullanıcı,String>> kullanıcılar;
    private Stack<Yemek> EklenenYemekler;
    private Stack<Icecek> EklenenIcecekler;
    private ArrayList<Yemek> yemekler;
    private ArrayList<ArrayList<Icecek>> MalzemedenIcecekler;
    private PriorityQueue<Malzeme> SıkKullanılanlar;// heap;
    private LinkedList<String> LinkedList;

    public boolean kullaniDogrula(){
        return true;////////////////////////////
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
/*
    public Menu BuGununOnerisi(){

    }

    public Menu KullanıcıyaOzelOner(Kullanıcı kullanıcı){

    }
    public boolean tarifKabul(Yemek yeniyemek){

    }
*/
    public int calculateWeightBetweenConsumables(Tüketilebilir source, Tüketilebilir destination){
        //TODO: very simple. just a for inside for, count the common ingredient number and return it
        return 0;
    }
}
