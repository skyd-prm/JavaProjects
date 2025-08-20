public class Auto {
    private Ticket ticket;

    public Auto() {
        this.ticket = null;
    }

    //einfahrt in parkhaus
    public void einfahrt(Parkhaus p) {
        this.ticket = p.ticketZiehen();
        if (ticket != null) { //falls noch platz frei
            System.out.println("Auto hat Ticket " + ticket.getId() + " gezogen und ist eingefahren.");
        } else {
            System.out.println("Kein Platz im Parkhaus!");
        }
    }

    //ausfahrt durch schranke
    public void ausfahrt(Schranke s) {
        if (ticket != null && ticket.isBezahlt()) { //nur wenn es ein bezahltes ticket gibt
            s.oeffnen(); //zuerst schranke öffnen
            if (s.isOffen()) {
                System.out.println("Auto fährt aus mit Ticket " + ticket.getId());
            }
            s.schliessen();
        } else { //schranke wird nicht geöffnet beinicht bezahltem/keinem ticket
            System.out.println("Ticket ist nicht bezahlt! Schranke bleibt geschlossen.");
        }
    }


    //ticket bezahlen bei kasse
    public void bezahlen(Kasse k) {
        if (ticket != null) {
            k.bezahlen(ticket);
        }
    }
    //getter
    public Ticket getTicket() {
    return ticket;
}

}
