
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.*;

public class Hauptmenue extends JFrame implements ActionListener {

	JLabel hauptmenue = new JLabel("Hauptmenü", SwingConstants.CENTER);
	JLabel name1 = new JLabel("Spieler1 :", SwingConstants.CENTER);
	JLabel name2 = new JLabel("Spieler2 :", SwingConstants.CENTER);
	JLabel spielfeldfarbe = new JLabel("Spielfeldfarbe:", SwingConstants.CENTER);
	JLabel spielernamen = new JLabel("Spielername:", SwingConstants.CENTER);
	JTextField inName1 = new JTextField(5);
	JTextField inName2 = new JTextField(5);
	JButton spiel = new JButton("Spiel starten");
	Player player1;
	Player player2;

	JPanel spalte0 = new JPanel();
	JPanel spalte1 = new JPanel();
	JPanel spalte2 = new JPanel();
	JPanel spalte3 = new JPanel();
	JPanel spalte4 = new JPanel();
	JPanel spalte5 = new JPanel();
	JPanel spalte6 = new JPanel();
	JPanel spalte7 = new JPanel();
	JPanel spalte8 = new JPanel();
	JPanel spalte9 = new JPanel();
	JPanel spalte10 = new JPanel();
	JPanel spalte11 = new JPanel();

	JPanel leer1 = new JPanel();
	JPanel leer2 = new JPanel();
	JPanel leer3 = new JPanel();
	JPanel leer4 = new JPanel();
	JPanel leer5 = new JPanel();
	JPanel leer6 = new JPanel();
	JPanel leer7 = new JPanel();
	JPanel leer8 = new JPanel();
	JPanel leer9 = new JPanel();
	JPanel leer10 = new JPanel();
	JPanel leer11 = new JPanel();
	JPanel leer12 = new JPanel();
	JPanel leer13 = new JPanel();
	JPanel leer14 = new JPanel();
	JPanel leer15 = new JPanel();
	JPanel leer16 = new JPanel();
	JPanel leer17 = new JPanel();
	JPanel leer18 = new JPanel();
	JPanel leer19 = new JPanel();
	JPanel leer20 = new JPanel();
	JPanel inN = new JPanel();
	JPanel inN2 = new JPanel();
	JPanel farbuttonsl1 = new JPanel();
	JPanel farbuttonsl2 = new JPanel();
	JPanel farbuttonsr1 = new JPanel();
	JPanel farbuttonsr2 = new JPanel();

	JRadioButton green, blue, yellow, magenta, orange, white, red, pink;
	JRadioButton green2, blue2, yellow2, magenta2, orange2, white2, red2, pink2;
	ButtonGroup color;
	ButtonGroup color2;

	/*
	Spielstand laden
	 */
	private JMenuBar jMenuBar;
	private JMenu jMenu;
	private JMenuItem loadGame;
	private JFileChooser jFileChooser;

	Hauptmenue() {

		setTitle("Hauptmen�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridLayout(13, 1));

		jMenuBar = new JMenuBar();
		jMenu = new JMenu("Spielstand");
		loadGame = new JMenuItem("laden");
		loadGame.addActionListener(this);
		loadGame.setActionCommand("laden");
		jMenu.add(loadGame);
		jMenuBar.add(jMenu);
		add(jMenuBar);
		jFileChooser = new JFileChooser(new File("c://"));

		hauptmenue.setFont(new Font("SansSerif", Font.BOLD, 35));
		name1.setFont(new Font("SansSerif", Font.BOLD, 20));
		name2.setFont(new Font("SansSerif", Font.BOLD, 20));
		spielfeldfarbe.setFont(new Font("SansSerif", Font.BOLD, 20));
		spielernamen.setFont(new Font("SansSerif", Font.BOLD, 20));
		spalte0.setLayout(new GridLayout(1, 1));

		spalte1.setLayout(new GridLayout(1, 1));

		spalte2.setLayout(new GridLayout(1, 1));
		spalte3.setLayout(new GridLayout(1, 5));
		spalte4.setLayout(new GridLayout(1, 1));
		spalte5.setLayout(new GridLayout(1, 3));
		spalte6.setLayout(new GridLayout(1, 1));
		spalte7.setLayout(new GridLayout(1, 5));
		spalte8.setLayout(new GridLayout(1, 5));
		spalte9.setLayout(new GridLayout(1, 1));
		spalte10.setLayout(new GridLayout(1, 3));
		spalte11.setLayout(new GridLayout(1, 1));

		inN.setLayout(new GridLayout(3, 1));

		inN2.setLayout(new GridLayout(3, 1));

		farbuttonsl1.setLayout(new GridLayout(2, 2));
		farbuttonsl1.setBackground(Color.blue);
		farbuttonsl2.setLayout(new GridLayout(2, 2));
		farbuttonsl2.setBackground(Color.blue);
		farbuttonsr1.setLayout(new GridLayout(2, 2));
		farbuttonsr1.setBackground(Color.blue);
		farbuttonsr2.setLayout(new GridLayout(2, 2));
		farbuttonsr2.setBackground(Color.blue);

		green = new JRadioButton("Grün", false);
		green.setBackground(Color.green);
		blue = new JRadioButton("Blau", false);
		blue.setBackground(Color.blue);
		yellow = new JRadioButton("Gelb", false);
		yellow.setBackground(Color.yellow);
		magenta = new JRadioButton("Magenta", false);
		magenta.setBackground(Color.magenta);
		orange = new JRadioButton("Orange", false);
		orange.setBackground(Color.orange);
		white = new JRadioButton("Weiß", false);
		white.setBackground(Color.white);
		red = new JRadioButton("Rot", false);
		red.setBackground(Color.red);
		pink = new JRadioButton("Pink", false);
		pink.setBackground(Color.pink);

		green2 = new JRadioButton("Grün", false);
		green2.setBackground(Color.green);
		blue2 = new JRadioButton("Blau", false);
		blue2.setBackground(Color.blue);
		yellow2 = new JRadioButton("Gelb", false);
		yellow2.setBackground(Color.yellow);
		magenta2 = new JRadioButton("Magenta", false);
		magenta2.setBackground(Color.magenta);
		orange2 = new JRadioButton("Orange", false);
		orange2.setBackground(Color.orange);
		white2 = new JRadioButton("Weiß", false);
		white2.setBackground(Color.white);
		red2 = new JRadioButton("Rot", false);
		red2.setBackground(Color.red);
		pink2 = new JRadioButton("Pink", false);
		pink2.setBackground(Color.pink);

		color = new ButtonGroup();
		color.add(green);
		color.add(blue);
		color.add(yellow);
		color.add(magenta);
		color.add(orange);
		color.add(white);
		color.add(red);
		color.add(pink);

		farbuttonsl1.add(green);
		farbuttonsl1.add(blue);
		farbuttonsl1.add(yellow);
		farbuttonsl1.add(magenta);
		farbuttonsl2.add(orange);
		farbuttonsl2.add(white);
		farbuttonsl2.add(red);
		farbuttonsl2.add(pink);

		color2 = new ButtonGroup();
		color2.add(green2);
		color2.add(blue2);
		color2.add(yellow2);
		color2.add(magenta2);
		color2.add(orange2);
		color2.add(white2);
		color2.add(red2);
		color2.add(pink2);

		farbuttonsr1.add(green2);
		farbuttonsr1.add(blue2);
		farbuttonsr1.add(yellow2);
		farbuttonsr1.add(magenta2);
		farbuttonsr2.add(orange2);
		farbuttonsr2.add(white2);
		farbuttonsr2.add(red2);
		farbuttonsr2.add(pink2);

		spiel.setToolTipText("Beginne ein neues Spiel!");
		spiel.addActionListener(this);
		spiel.setActionCommand("game");
		inName1.addActionListener(this);
		inName1.setActionCommand("name1");
		inName2.addActionListener(this);
		inName2.setActionCommand("name2");
		green.addActionListener(this);
		green.setActionCommand("green");
		blue.addActionListener(this);
		blue.setActionCommand("blue");
		yellow.addActionListener(this);
		yellow.setActionCommand("yellow");
		magenta.addActionListener(this);
		magenta.setActionCommand("magenta");
		orange.addActionListener(this);
		orange.setActionCommand("orange");
		white.addActionListener(this);
		white.setActionCommand("white");
		red.addActionListener(this);
		red.setActionCommand("red");
		pink.addActionListener(this);
		pink.setActionCommand("pink");
		green2.addActionListener(this);
		green2.setActionCommand("green2");
		blue2.addActionListener(this);
		blue2.setActionCommand("blue2");
		yellow2.addActionListener(this);
		yellow2.setActionCommand("yellow2");
		magenta2.addActionListener(this);
		magenta2.setActionCommand("magenta2");
		orange2.addActionListener(this);
		orange2.setActionCommand("orange2");
		white2.addActionListener(this);
		white2.setActionCommand("white2");
		red2.addActionListener(this);
		red2.setActionCommand("red2");
		pink2.addActionListener(this);
		pink2.setActionCommand("pink2");

		getContentPane().add(spalte0);
		getContentPane().add(spalte1);
		getContentPane().add(spalte2);
		getContentPane().add(spalte3);
		getContentPane().add(spalte4);
		getContentPane().add(spalte5);
		getContentPane().add(spalte6);
		getContentPane().add(spalte7);
		getContentPane().add(spalte8);
		getContentPane().add(spalte9);
		getContentPane().add(spalte10);
		getContentPane().add(spalte11);

		inN.add(leer1);
		inN.add(inName1);
		inName1.setToolTipText("Bitte Spielernamen f�r Spieler 1 eingeben");
		inN.add(leer2);

		inN2.add(leer3);
		inN2.add(inName2);
		inName2.setToolTipText("Bitte Spielernamen f�r Spieler 2 eingeben");
		inN2.add(leer4);

		spalte1.add(hauptmenue);
		spalte3.add(leer13);
		spalte3.add(name1);
		spalte3.add(leer5);
		spalte3.add(leer15);
		spalte3.add(leer16);
		spalte3.add(name2);
		spalte3.add(leer14);
		spalte5.add(leer6);
		spalte5.add(inN);
		spalte5.add(leer7);
		spalte5.add(spielernamen);
		spalte5.add(leer8);
		spalte5.add(inN2);
		spalte5.add(leer9);
		spalte7.add(farbuttonsl1);
		spalte7.add(spielfeldfarbe);
		spalte7.add(farbuttonsr1);
		spalte8.add(farbuttonsl2);
		spalte8.add(leer10);
		spalte8.add(farbuttonsr2);
		spalte10.add(leer11);
		spalte10.add(spiel);
		spalte10.add(leer12);

		setSize(900, 600);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		Gui gui;

		if (evt.getActionCommand().equals("game")) {

			Player player1 = new Player(getColor1(), inName1.getText(), 3, 4);
			Player player2 = new Player(getColor2(), inName2.getText(), 4, 3);

			if (player1.getName().equals(player2.getName())) {
				JOptionPane.showMessageDialog(null, "Nicht den gleichen Namen verwenden ", "InfoBox: ",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (player1.getColor().equals(player2.getColor())) {
				JOptionPane.showMessageDialog(null, "Nicht die gleiche Farbe verwenden", "InfoBox: ",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				gui = new Gui(player1, player2);
			}

		} else  if (evt.getActionCommand().equals("laden")) {
			jFileChooser.showOpenDialog(null);
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
				gui = (Gui) input.readObject();
				gui.setVisible(true);
				//gui visi
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

	public Color getColor1() {

		Color farbe = Color.yellow;

		if (green2.isSelected()) {
			farbe = Color.green;
		} else if (blue2.isSelected()) {
			farbe = Color.blue;
		} else if (yellow2.isSelected()) {
			farbe = Color.yellow;
		} else if (magenta2.isSelected()) {
			farbe = Color.magenta;
		} else if (orange2.isSelected()) {
			farbe = Color.orange;
		} else if (white2.isSelected()) {
			farbe = Color.white;
		} else if (red2.isSelected()) {
			farbe = Color.red;
		} else if (pink2.isSelected()) {
			farbe = Color.pink;
		}

		return farbe;
	}

	public Color getColor2() {

		Color farbe = Color.yellow;

		if (green.isSelected()) {
			farbe = Color.green;
		} else if (blue.isSelected()) {
			farbe = Color.blue;
		} else if (yellow.isSelected()) {
			farbe = Color.yellow;
		} else if (magenta.isSelected()) {
			farbe = Color.magenta;
		} else if (orange.isSelected()) {
			farbe = Color.orange;
		} else if (white.isSelected()) {
			farbe = Color.white;
		} else if (red.isSelected()) {
			farbe = Color.red;
		} else if (pink.isSelected()) {
			farbe = Color.pink;
		}
		return farbe;

	}

	public static void main(String[] args) {
		Hauptmenue demo = new Hauptmenue();

	}

}
