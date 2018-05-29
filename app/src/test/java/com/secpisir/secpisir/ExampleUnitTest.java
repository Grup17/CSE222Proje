package com.secpisir.secpisir;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void yemekleriDosyadanOku(){
        try {
            Process p = Runtime.getRuntime().exec("pwd");
            BufferedReader ips = new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println(ips.readLine());
            YönetimSistemi.yemekTarifleriniDosyadanOku();
            System.out.println(YönetimSistemi.getYemekler().get(0).getMalzemeler());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void yemeklerinOrtakMalzemeSayisi(){
        try {
            YönetimSistemi.yemekTarifleriniDosyadanOku();
            System.out.println(YönetimSistemi.getYemekler());
            Yemek yemek1 = YönetimSistemi.getYemek(18);
            Yemek yemek2 = YönetimSistemi.getYemek(15);
            System.out.println(YönetimSistemi.yemeklerinOrtakMalzemeSayisi(yemek1,yemek2));
            System.out.println(YönetimSistemi.cizgedenOrtakMalzemeler(yemek1,yemek2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void kullaniciyaOzelYemekOner(){
        try {
            YönetimSistemi.listedenKullanicilariOku();
            YönetimSistemi.yemekTarifleriniDosyadanOku();
            for (Object o : YönetimSistemi.getKullaniciSet()) {
                Kullanici k = (Kullanici)o;
                ArrayList<Yemek> suggestions = YönetimSistemi.kullaniciyaOzelYemekOner(k);
                System.out.println("Suggestions for " + k.getIsim()+":"
                    + suggestions);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}