
public class Kasse {
    private double minutenPreis;
    //konstruktor
    public Kasse(double minutenPreis) {
        this.minutenPreis = minutenPreis;
    }

    //ticket bezahlen 
    public void bezahlen(Ticket t) {
        double betrag = t.getPreis(minutenPreis);
        System.out.println("Bitte bezahlen: " + betrag + " EUR");
        t.bezahlen();
    }
}
