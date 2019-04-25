import java.awt.*;
import java.io.Serializable;

public class Player implements Serializable {

    private Color color;
    private int posx, posy;
    private double sum = 0;
    private boolean canMove = false, won = false;
    private String[] direction = new String[4];
    private String name;

    /**
     * @param color
     * @param posx
     * @param posy
     */
    public Player(Color color, String name, int posx, int posy) {
        this.color = color;
        this.name = name;
        this.posx = posx;
        this.posy = posy;
        updateDirection();
    }

    /**
     * @return color (String)
     * @see Zahlen toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * @param dir (+-1, 0)
     * @return nächste posX von dem Spieler bei jeweligen richtung
     * see position
     */
    public int getPosxNext(int dir) {
        return position(dir, this.posx, -10);

    }

    /**
     * @param dir (+-1, 0)
     * @return nächste posY von dem Spieler bei jeweligen richtung
     * see position
     */
    public int getPosyNext(int dir) {
        return position(dir, -10, this.posy);
    }

    /**
     * @param dir
     * @param posx
     * @param posy Zuerst wird durch die -10 überprüft ob wir x oder y wollen
     * @return die nächste pos, bei eingabe von der dir, und der aktuellen x oder y position. Wird von getPosxNext oder getPosyNext aufgerufen
     * see getPosyNext
     * see getPosxNext
     */
    private int position(int dir, int posx, int posy) {
        int pos;
        if (posx == -10) {
            pos = posy;
        } else pos = posx;

        if (pos + dir < 0) {
            return 7;
        } else if (pos + dir > 7) {
            return 0;
        } else return pos + dir;

    }

    /**
     *
     * @return der Wert der Instanzvariable von posx
     */
    public int getPosx() {
        return posx;
    }

    /**
     * @param posx wert von posx (Instanzvariable) wird verandert
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     *
     * @return der Wert der Instanzvariable von posy
     */
    public int getPosy() {
        return posy;
    }

    /**
     *
     * @param posy
     * Wert von posy (Instanzvariable) wird verandert
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

    /**
     *
     * @return der Wert der Instanzvariable von sum
     */
    public double getSum() {
        return sum;
    }

    /**
     *
     * @param sum
     * Wert von sum (Instanzvariable) wird verandert
     */
    public void setSum(double sum) {
        this.sum += sum;//TODO: react on winning player
    }

    /**
     *
     * @return
     */
    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @return der Wert der Instanzvariable von color
     */
    public Color getColor() {
        return color;
    }

    public String[] getDirection() {
        return direction;
    }

    public void updateDirection() {
        int position = Integer.parseInt((int) getPosy() +""+ getPosx());
        direction[0] = String.valueOf(position - 10);
        direction[1] = String.valueOf(position + 1);
        direction[2] = String.valueOf(position + 10);
        direction[3] = String.valueOf(position - 1);
    }
}
