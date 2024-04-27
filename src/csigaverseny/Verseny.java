/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csigaverseny;

import java.util.Random;

/**
 *
 * @author vekon
 */
public class Verseny {

    private static Random rnd = new Random();
    private static int korok = 5;
    public Verseny() {
        kezdes();
    }

    private void kezdes() {
    
    Csiga csiga1 = new Csiga();
    Csiga csiga2 = new Csiga();
    Csiga csiga3 = new Csiga();
        
    int fogad = Verseny.rnd.nextInt(3);    
    
    System.out.println("Fogadás: " + Csiga.szinek[fogad]);   
    
        for (int i = 0; i < korok; i++) {
            System.out.println(i);
        }
    
    }


    
}
