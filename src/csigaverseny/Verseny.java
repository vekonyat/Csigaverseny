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
    int gyorsEsely = 20;
    int kapGyorsitot = 0;
    int nyeroTav = 0;
    boolean fogadoNyer = false;

    public Verseny() {
        kezdes();
    }

    private void kezdes() {

        Csiga csiga1 = new Csiga("Piros");
        Csiga csiga2 = new Csiga("Z�ld");
        Csiga csiga3 = new Csiga("K�k");

        int fogad = Verseny.rnd.nextInt(3);
        /*Kezd�sebess�g be�ll�t�sa*/
        csiga1.setSebesseg();
        csiga2.setSebesseg();
        csiga3.setSebesseg();

        seb1 = csiga1.getSebesseg();
        seb2 = csiga2.getSebesseg();
        seb3 = csiga3.getSebesseg();

        sebesseg = new int[]{seb1, seb2, seb3};

        System.out.println("Fogad�s: " + Csiga.szinek[fogad]);

        System.out.print("Csig�k sebess�ge: ");
        csigaKiir(Csiga.szinek, sebesseg);

        System.out.println("\n");

        for (int i = 0; i < korok; i++) {
            System.out.println("K�rsz�m: " + (i + 1));

            /* Gyors�t� es�lysz�m�t�s �s be�ll�t�s */
            int gyorsitas = Verseny.rnd.nextInt(100 / gyorsEsely) + 1;
            if ( gyorsitas == 1) {
                kapGyorsitot = Verseny.rnd.nextInt(3) + 1;
            }
            if (kapGyorsitot == 1) {
                csiga1.setKapGyorsitot(true);
            }
            if (kapGyorsitot == 2) {
                csiga2.setKapGyorsitot(true);
            }
            if (kapGyorsitot == 3) {
                csiga3.setKapGyorsitot(true);
            }
            /* T�vsz�m�t�s, ki�rat�s*/
            csiga1.setMessze();
            csiga2.setMessze();
            csiga3.setMessze();

            messze = new int[]{csiga1.getMessze(), csiga2.getMessze(), csiga3.getMessze()};
            System.out.print("El�rt t�vols�g: ");
            csigaKiir(Csiga.szinek, messze);

            if (kapGyorsitot > 0) {
                System.out.print("Gyors�tott csiga: " + Csiga.szinek[--kapGyorsitot]);
                kapGyorsitot = 0;
            }
            System.out.println(" ");
        }
        /* A nyer� t�vols�g kiv�laszt�sa */
        for (int i = 0; i < 3; i++) {
            if (messze[i] > nyeroTav) {
                nyeroTav = messze[i];
            }
        }
        System.out.print("\nA nyertes: ");
        /* Ahol a nyer� t�v egyezik, ott nyertes van, t�bb is lehet + fogad� nyer-e */
        for (int i = 0; i < 3; i++) {
            if (messze[i] == nyeroTav) {
                System.out.print(Csiga.szinek[i] + " ");
                if (i == fogad) {
                    fogadoNyer = true;
                }
            }
        }
        System.out.println("");
        if (fogadoNyer) {
            System.out.println("A fogad� nyer!");
        } else {
            System.out.println("A fogad� vesz�t.");
        }

    }

    private void csigaKiir(String[] szinek, int[] adatok) {
        for (int j = 0; j < 3; j++) {
            System.out.print(szinek[j] + ": ");
            System.out.print(adatok[j] + " ; ");
        }
    }
}
