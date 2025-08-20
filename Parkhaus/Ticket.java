import java.util.Date;

public class Ticket {
    private int id;
    private Date startzeit;
    private boolean bezahlt;
     //konstruktor
    public Ticket(int id) {
        this.id = id;
        this.startzeit = new Date();
        this.bezahlt = false;
    }
    //getter
    public int getId() {
        return id;
    }
    //getter
    public Date getStartzeit() {
        return startzeit;
    }
    //getter
    public boolean isBezahlt() {
        return bezahlt;
    }
    //bezahlt das ticket
    public void bezahlen() {
        this.bezahlt = true;
    }

    //berechnen des preises mit vorgegebenem minutenpreis
    public double getPreis(double minutenPreis) {
        long differenz = (new Date().getTime() - startzeit.getTime()) / 60000; //minuten
        if (differenz == 0) differenz = 1; //braucht mindestens eine minute
        return differenz * minutenPreis;
    }
}
