package csigaverseny;

import java.util.Random;

public class Csiga {

    private static Random rnd = new Random();
    private String szin;
    private int sebesseg;
    private int messze = 0;
    private int messzeOld = 0;
    private boolean kapGyorsitot = false;

    public boolean isKapGyorsitot() {
        return kapGyorsitot;
    }

    public void setKapGyorsitot(boolean kapGyorsitot) {
        this.kapGyorsitot = kapGyorsitot;
    }
    private int maxSeb = 3;

    public static String[] szinek = {"Piros", "Zöld", "Kék"};

    public Csiga(String szin) {
        this.szin = szin;
    }

    public String getSzin() {
        return szin;
    }

    public void setSebesseg() {
        sebesseg = rnd.nextInt(maxSeb) + 1;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setMessze() {
        messze = messzeOld + sebesseg;
        if (kapGyorsitot) {
            messze = 2 * messze;
        }
        messzeOld = messze;
        this.kapGyorsitot = false;
    }

    public int getMessze() {
        return messze;
    }
}
