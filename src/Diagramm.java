import java.awt.*;
import java.io.Serializable;
import javax.swing.*;

public class Diagramm extends JPanel implements Serializable{

	class Teil implements Serializable{
		double wert;
		Color farbe;

		public Teil(double wert, Color farbe) {
			this.wert = wert;
			this.farbe = farbe;
		}
	}

	Teil[] teile = new Teil[3];

	public Diagramm(double wertSpielerEins, Color farbeSpielerEins, double wertSpielerZwei, Color farbeSpielerZwei, double wertRest) {
		setSize(200,300);
		teile[0] = new Teil(wertSpielerEins, farbeSpielerEins);
		teile[1] = new Teil(wertSpielerZwei, farbeSpielerZwei);
		teile[2] = new Teil(wertRest, Color.black);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double gesamt = 0.0D;
		for (int i = 0; i < teile.length; i++) {
			gesamt += teile[i].wert;
		}

		double curValue = 0.0D;
		int startAngle = 0;
		for (int i = 0; i < teile.length; i++) {
			startAngle = (int) (curValue * 360 / gesamt);
			int arcAngle = (int) ((teile[i].wert +1d) * 360 / gesamt);

			g.setColor(teile[i].farbe);
			g.fillArc(getBounds().x, getBounds().y, getBounds().width, getBounds().height, startAngle, arcAngle);
			curValue += teile[i].wert;
		}
	}
}
