
package csigaverseny;

import java.util.Random;


public class Csiga {
    
    private static Random rnd = new Random();
    private String szin;
    private int sebesseg;
    private int messze = 0;
    private int messzeOld = 0;
    private boolean kapGyorsitot;
    private int maxSeb = 3;
    
    public static String[] szinek = {"piros", "zold", "kek"};
    
    public void setSebesseg() {
        sebesseg = rnd.nextInt(maxSeb)+1;
    }
    
    public int getSebesseg() {
        return sebesseg;
    }
    
    public void setMessze() {
        messze = messzeOld + sebesseg;
        messzeOld = messze;
    }

    public int getMessze() {
        return messze;
    }
    
}
