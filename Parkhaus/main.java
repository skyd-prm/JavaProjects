import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // setup
        Display display = new Display("willkommen!"); // erstellt ein display mit starttext
        Parkhaus parkhaus = new Parkhaus(3, display); // erstellt parkhaus mit kapazität 3
        Schranke schranke = new Schranke(); // erstellt eine schranke
        Kasse kasse = new Kasse(1); // erstellt eine kasse mit minutenpreis 1 euro
        List<Auto> autos = new ArrayList<>(); // liste um alle autos zu speichern

        boolean running = true; // schleife läuft solange running true ist
        while (running) {
            System.out.println("\n===== parkhaus steuerung =====");
            System.out.println("1. auto einfahrt");
            System.out.println("2. auto bezahlen");
            System.out.println("3. auto ausfahrt");
            System.out.println("4. parkhaus-status");
            System.out.println("0. beenden");
            System.out.print("aktion wählen: ");

            int wahl = sc.nextInt();

            switch (wahl) {
                case 1:
                    // auto einfahrt
                    Auto auto = new Auto();
                    auto.einfahrt(parkhaus);
                    if (auto.getTicket() != null) {
                        autos.add(auto); // auto wird gespeichert wenn ticket gezogen wurde
                    }
                    display.show();
                    break;

                case 2:
                    // auto bezahlen
                    if (autos.isEmpty()) {
                        System.out.println("kein auto im parkhaus!");
                        break;
                    }
                    System.out.print("ticket-id eingeben zum bezahlen: ");
                    int id = sc.nextInt();
                    Auto zuBezahlen = findeAutoMitTicket(autos, id);
                    if (zuBezahlen != null) {
                        zuBezahlen.bezahlen(kasse);
                    } else {
                        System.out.println("kein auto mit diesem ticket gefunden!");
                    }
                    break;

                case 3:
                    // auto ausfahrt
                    if (autos.isEmpty()) {
                        System.out.println("kein auto im parkhaus!");
                        break;
                    }
                    System.out.print("ticket-id eingeben zur ausfahrt: ");
                    int id2 = sc.nextInt();
                    Auto zuAusfahren = findeAutoMitTicket(autos, id2);
                    if (zuAusfahren != null) {
                        zuAusfahren.ausfahrt(schranke);
                        if (zuAusfahren.getTicket().isBezahlt()) {
                            parkhaus.parkplatzFreigeben(); // platz wieder frei
                            autos.remove(zuAusfahren); // auto aus liste löschen
                        }
                        display.show();
                    } else {
                        System.out.println("kein auto mit diesem ticket gefunden!");
                    }
                    break;

                case 4:
                    // parkhaus-status anzeigen
                    System.out.println("freie plätze: " + parkhaus.getFreiePlaetze());
                    display.show();
                    System.out.println("autos im parkhaus:");
                    for (Auto a : autos) {
                        System.out.println(" - auto mit ticket " + a.getTicket().getId() +
                                (a.getTicket().isBezahlt() ? " (bezahlt)" : " (unbezahlt)"));
                    }
                    break;

                case 0:
                    // programm beenden
                    running = false;
                    System.out.println("programm beendet.");
                    break;

                default:
                    // falsche eingabe
                    System.out.println("ungültige auswahl!");
            }
        }

        sc.close(); // scanner schließen
    }

    // hilfsmethode um auto anhand ticket-id zu finden
    private static Auto findeAutoMitTicket(List<Auto> autos, int id) {
        for (Auto a : autos) {
            if (a.getTicket() != null && a.getTicket().getId() == id) {
                return a;
            }
        }
        return null; // kein auto gefunden
    }
}
