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
        Csiga csiga2 = new Csiga("Zöld");
        Csiga csiga3 = new Csiga("Kék");

        int fogad = Verseny.rnd.nextInt(3);

        System.out.println("Fogadás: " + Csiga.szinek[fogad]);
        System.out.println("");

        for (int i = 0; i < korok; i++) {
            System.out.println("Körszám: " + (i + 1));

            /* Gyorsító esélyszámítás és beállítás */
            int gyorsitas = Verseny.rnd.nextInt(100 / gyorsEsely) + 1;

            if (gyorsitas == 1) {
                kapGyorsitot = Verseny.rnd.nextInt(3) + 1;
            }

            if (kapGyorsitot == 1) {
                csiga1.setKapGyorsitot(true);
            } else if (kapGyorsitot == 2) {
                csiga2.setKapGyorsitot(true);
            } else if (kapGyorsitot == 3) {
                csiga3.setKapGyorsitot(true);
            }

            /* Sebesség kiszámítása */
            kalkSebesseg(csiga1, csiga2, csiga3);

            csigaKiir("Csigák sebessége: ", Csiga.szinek, sebesseg);
            System.out.print("\n");

            /* Távszámítás, kiíratás*/
            csiga1.setMessze();
            csiga2.setMessze();
            csiga3.setMessze();

            messze = new int[]{csiga1.getMessze(), csiga2.getMessze(), csiga3.getMessze()};

            csigaKiir("Elért távolság: ", Csiga.szinek, messze);
            System.out.print("\n");

            if (kapGyorsitot > 0) {
                System.out.println("Gyorsított csiga: " + Csiga.szinek[--kapGyorsitot]);
                kapGyorsitot = 0;
            }
            System.out.println(" ");
        }
        /* A nyerõ távolság kiválasztása */
        for (int i = 0; i < 3; i++) {
            if (messze[i] > nyeroTav) {
                nyeroTav = messze[i];
            }
        }
        System.out.print("A nyertes: ");
        
        /* Ahol a nyerõ táv egyezik, ott nyertes van, több is lehet + fogadó nyer-e */
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
            System.out.println("A fogadó nyer!");
        } else {
            System.out.println("A fogadó veszít.");
        }

    }

    private void kalkSebesseg(Csiga csiga1, Csiga csiga2, Csiga csiga3) {
        /*Csigasebesség beállítása*/
        csiga1.setSebesseg();
        csiga2.setSebesseg();
        csiga3.setSebesseg();

        seb1 = csiga1.getSebesseg();
        seb2 = csiga2.getSebesseg();
        seb3 = csiga3.getSebesseg();

        sebesseg = new int[]{seb1, seb2, seb3};
    }

    private void csigaKiir(String szoveg, String[] szinek, int[] adatok) {
        System.out.print(szoveg);

        for (int j = 0; j < 3; j++) {
            System.out.print(szinek[j] + ": ");
            System.out.print(adatok[j] + " ; ");

        }
    }
}
