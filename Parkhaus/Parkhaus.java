import java.util.ArrayList;
import java.util.List;

public class Parkhaus {
    private int kapazitaet;
    private int freiePlaetze;
    private List<Ticket> tickets;
    private Display display;

    //konstruktor
    public Parkhaus(int kapazitaet, Display display) {
        this.kapazitaet = kapazitaet;
        this.freiePlaetze = kapazitaet;
        this.tickets = new ArrayList<>();
        this.display = display;
        this.display.update(freiePlaetze);
    }

    //methode bei autoeinfahrt, die ein ticket erstellt
    public Ticket ticketZiehen() {
        if (freiePlaetze > 0) {
            Ticket newTicket = new Ticket(tickets.size() + 1);
            tickets.add(newTicket);
            parkplatzBelegen();
            return newTicket;
        }
        return null;
    }

    //methode bei autoeinfahrt, die einen freien parkplatz wegnimmt
    public void parkplatzBelegen() {
        if (freiePlaetze > 0) {
            freiePlaetze--;
            display.update(freiePlaetze);
        }
    }

    //methode bei autoausfahrt, die einen parkplatz freigibr
    public void parkplatzFreigeben() {
        if (freiePlaetze < kapazitaet) {
            freiePlaetze++;
            display.update(freiePlaetze);
        }
    }

    //getter
    public int getFreiePlaetze() {
        return freiePlaetze;
    }
}
