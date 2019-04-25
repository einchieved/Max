/**
 * Class: SpielFeld, Filename: SpielFeld.java
 * 19.12.2018 | 17:15
 *
 * @AUTHOR Robin
 */
import java.io.Serializable;
import java.util.Random;

public class SpielFeld implements Serializable {

    private final int x = 8;
    private final int y = 8;
    private Zahlen[][] feld;
    private double summe = 0;

    Player playerW, playerB;
    Zahlen zahlenB, zahlenW;

    /**
     *
     * @param playerB
     * @param playerW
     * Instanz von SpielFeld wird erstellt, mit zweit Player Objekten.
     * In dem Spielfeld ist ein Array von Zahlen Instanzen.
     * fillField() wird Aufgerufen.
     * @see Zahlen
     * @see Player
     * see fillfield
     */
    public SpielFeld(Player playerB, Player playerW) {
        feld = new Zahlen[y][x];
        this.playerB = playerB;
        this.playerW = playerW;
        fillField();
    }

    /**
     * Füllt das feld (Zahlen Array) von der Instanz mit Zahlen Instanzen, die Zufällig erstellt werden
     * (zaehler zwischen 3 und 20) und (nenner zwischen 1 und 10)
     * Erstellt 2 neue Zahlen Instanzen (zahlenW, zahlenB) mit Player Objekten (playerW, playerB).
     * Fügt die Zahlen Instanzen in das Zahlen Array an stelle 3|4 und 4|3
     * @new gibt die Summer der Zahlen auf der Konsole aus
     */
    private void fillField() {
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int zaehler = rand.nextInt((20 - 3) + 1) + 3;
                int b = rand.nextInt((10 - 1) + 1) + 1;
                if (i == 3 && j == 4) {
                    zahlenW = new Zahlen(playerW);
                    feld[i][j] = zahlenW;
                } else if (i == 4 && j == 3) {
                    zahlenB = new Zahlen(playerB);
                    feld[i][j] = zahlenB;
                } else {
                    feld[i][j] = new Zahlen(zaehler, b, true);
                    summe += feld[i][j].getNumber();
                }
            }
        }
    }

    /**
     *
     * @param direction
     * @param player
     * @return Erfolgreich oder Nicht
     * Löst den String direction (N, O, S, W) in +- 1 und 0 auf
     * und ruft die Methode move() damit auf
     * see move
     */
    public boolean movePlayer(String direction, Player player) {
        switch (direction) {//set previous player position to ZERO, add the number to the player-sum, move player to position
            case "N":
                return move(player, 0, -1);
            case "O":
                return move(player, 1, 0);
            case "S":
                return move(player, 0, 1);
            case "W":
                return move(player, -1, 0);
            default:
        }
        return false;
    }

    /**
     *
     * @param player
     * @param x
     * @param y
     * @return Erfolgreich oder Nicht
     * (Bewegt) (player.setPos(x/y)) den Player an die richtige Stelle in dem Zahlen Array der Instanz, wenn die Stelle eine Nummer ist (isNumber)
     * ansonsten wird "Spieler ist im Weg" auf der Konsole ausgegebn und false zurückgegeben
     * Ersetzt die Stelle, wo der Player stand mit einer neuen Zahlen Instanze (zaehler 0, nenner 1, isNumber treu)
     * Fügt den Wert des Zahlen Objektes auf das sich der Player bewegt zu seiner summe (sum) hinzu (player.setSum(yx.getNumber))
     *
     */
    public boolean move(Player player, int x, int y) {
        if (feld[player.getPosyNext(y)][player.getPosxNext(x)].isNumber()) { //only if next position is a number
            feld[player.getPosy()][player.getPosx()] = new Zahlen(0, 1, true);
            player.setSum(feld[player.getPosyNext(y)][player.getPosxNext(x)].getNumber());
            if (player.getName().equals(playerW.getName())) {
                feld[player.getPosyNext(y)][player.getPosxNext(x)] = zahlenW;
            } else if (player.getName().equals(playerB.getName())) {
                feld[player.getPosyNext(y)][player.getPosxNext(x)] = zahlenB;
            }
            player.setPosy(player.getPosyNext(y));
            player.setPosx(player.getPosxNext(x));
            return true;
        } else {
            System.out.println("Spieler ist im Weg");
            return false;
        }
    }

    public Zahlen[][] getFeld() {
        return feld;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double verbliebenPunkte(){
        return summe - playerB.getSum() - playerW.getSum();
    }
}
