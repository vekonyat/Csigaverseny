/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author vekon
 */
public class Verseny {

    private static Random rnd = new Random();
    private static int korok = 5;
    private int[] messze = {0, 0, 0}; 
    int[] sebesseg;
    int seb1, seb2, seb3;
   
    
    public Verseny() {
        kezdes();
    }

    private void kezdes() {
    
    Csiga csiga1 = new Csiga();
    Csiga csiga2 = new Csiga();
    Csiga csiga3 = new Csiga();
        
    int fogad = Verseny.rnd.nextInt(3);
    
    csiga1.setSebesseg();
    csiga2.setSebesseg();
    csiga3.setSebesseg();
           
    seb1 = csiga1.getSebesseg();
    seb2 = csiga2.getSebesseg();
    seb3 = csiga3.getSebesseg();
    
    sebesseg = new int[] {seb1, seb2, seb3};
    
    System.out.println("Fogadás: " + Csiga.szinek[fogad]);   
    System.out.println("Csigák sebessége: " + Arrays.toString(sebesseg));
    
        for (int i = 0; i < korok; i++) {
            System.out.println("Körszám: " + i);
             csiga1.setMessze();
             csiga2.setMessze();
             csiga3.setMessze();
             messze = new int[] {csiga1.getMessze(), csiga2.getMessze(), csiga3.getMessze()}; 
            System.out.println("Távolság: " + Arrays.toString(messze));
        }
    
    }


    
}
