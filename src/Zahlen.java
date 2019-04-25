import java.io.Serializable;

public class Zahlen implements Serializable {

    private int zaehler, nenner;
    private Player player;
    private boolean isNumber;

    /**
     * @param zaehler
     * @param nenner
     * @param isNumber
     */
    public Zahlen(int zaehler, int nenner, boolean isNumber) {
        this.zaehler = zaehler;
        this.nenner = nenner;
        this.isNumber = isNumber;

        /*Brüch gegebenenfalls kürzen
         */
        this.zaehler = zaehler / ggt(zaehler, nenner);
        this.nenner = nenner / ggt(zaehler, nenner);
    }

    /**
     *
     * @param player
     * Erstellt eine Instanz von Zahlen, welche eine Referenz auf ein Player Objekt liefert
     */
    public Zahlen(Player player) {
        this.player = player;
    }

    /**
     *
     * @param x
     * @param y
     * @return größter gemeinsamer Teiler (int)
     */
    private static int ggt(int x, int y) {
        return y == 0 ? x : ggt(y, x % y);
    }

    /**
     * @return (String)
     * @see Player toString()
     * falls isNumber false ist, bei der Instanz, wird die player.toString aufgerufen, da es sich um ein Player handelt.
     * Ansonsten wird wenn der nenner 1 enspricht nur der zaehler zurückgegeben, ansonsten gib den zaehler + / + den nenner zurück.
     */
    public String toString() {
        return !isNumber ? player.toString() :
                nenner == 1 ? String.valueOf(zaehler) : zaehler + "/" + nenner;
    }

    /**
     *
     * @return der Wert der Instanzvariabel von isNumber (boolen)
     */
    public boolean isNumber() {
        return this.isNumber;
    }

    /**
     *
     * @return der Wert der Instanzvariabel von getZehler (int)
     */
    public int getZaehler() {
        return zaehler;
    }

    /**
     *
     * @return der Wert der Instanzvariabel von getNenner (int)
     */
    public int getNenner() {
        return nenner;
    }

    /**
     *
     * @return derWert der Instanzvariabel von getNumber (doubel)
     */
    public double getNumber() {
        return (double) zaehler / nenner;
    }


}
