import java.util.Scanner;

public class kgV_ggT_Rechner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner initiieren
        String antwort = "j";
        
        while(!antwort.equals("n")) {   //schleife für die eingabe der Zahlen

            System.out.print("Gib die erste Zahl ein: "); //eingabe erste zahl
            int zahl1 = sc.nextInt();

            System.out.print("Gib die zweite Zahl ein: "); //eingabe zweite zahl
            int zahl2 = sc.nextInt();

            int ggT = ggtBerechnen(zahl1, zahl2); //ruft die mothede auf, die den ggT berechnet
            int kgV = kgvBerechnen(zahl1, zahl2, ggT); //ruft die methode auf, die den kgV berechnet

            System.out.println("Der ggT ist: " + ggT + " und der kgV ist: " + kgV); //ausgabe des ggTs und des kgVs
            sc.nextLine(); //input-buffer bereinigen

            System.out.println("Nochmals? (j/n)"); //nachfrage, ob der User nochmals rechnen möchte
            antwort = sc.nextLine();

            while (!antwort.equals("n") && !antwort.equals("j")) { //schleife für eingabevalidierung
                System.out.println("Falsche Eingabe. Nochmals? (j/n)");
                antwort = sc.nextLine();
            }
        }
        sc.close();
    }

    static int ggtBerechnen (int zahl1, int zahl2) { //methode zur berechnung des ggTs mit Euklidischem algorithmus
            while (zahl2!=0) { //schleife der berechnung
                int rest = zahl1%zahl2;
                zahl1 = zahl2;
                zahl2 = rest;
            }
            return zahl1; //ggT wird zurückgebracht
        }

    static int kgvBerechnen (int zahl1, int zahl2, int ggT) { //methode zur berechnung des kgVs mit simpler rechnung
            int kgV = zahl1 * zahl2/ggT;
            return kgV;
    }

}