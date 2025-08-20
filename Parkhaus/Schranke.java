public class Schranke {
    private boolean offen;
    //konstruktor
    public Schranke() {
        this.offen = false;
    }
    //wird aufgerufen bei ausfahrt mit bezahltem ticket
    public void oeffnen() {
        this.offen = true;
        System.out.println("Schranke wurde geöffnet!");
    }
    //wird aufgerufen nach ausfahrt mit bezahltem ticket
    public void schliessen() {
        this.offen = false;
        System.out.println("Schranke wurde geschlossen!");
    }
    //getter
    public boolean isOffen() {
        return offen;
    }
}
