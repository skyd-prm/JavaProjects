public class Display {
    private String anzeigeText;

    //konstruktor
    public Display(String startText) {
        this.anzeigeText = startText;
    }
    //bringt den anzeigetext auf neusten stand
    public void update(int freiePlaetze) {
        this.anzeigeText = "Freie Plätze: " + freiePlaetze;
    }
    //zeigt den anzeigetext an
    public void show() {
        System.out.println("DISPLAY: " + anzeigeText);
    }
}
