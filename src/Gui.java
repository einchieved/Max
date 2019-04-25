import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Gui extends JFrame implements ActionListener, MouseListener {
    private Player playerB, playerG;
    private Player onTurn;
    private SpielFeld spielFeld;
    private JButton[][] buttons;
    private Zahlen[][] feld;
    private int x, y;
    private boolean moved = false;
    private Color curColor;
    private JPanel punkte = new JPanel(), dia = new JPanel();
    private JLabel punktePlayerB = new JLabel("0"), punktePlayerG = new JLabel("0");
    private JLabel verbleibendePunkte = new JLabel();
    private Diagramm diagramm;
    private JFileChooser jFileChooser;

    public Gui(Player player1, Player player2) {
        this.playerB = player1;
        this.playerG = player2;

        onTurn = playerB; //PlayerB beginns!
        curColor = onTurn.getColor();

        JPanel hauptPanel = new JPanel();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Spielstand");
        JMenuItem menuItemLaden = new JMenuItem("Laden");
        JMenuItem menuItemSpeichern = new JMenuItem("Speichern");
        menuItemLaden.addActionListener(this);
        menuItemLaden.setActionCommand("laden");
        menuItemSpeichern.addActionListener(this);
        menuItemSpeichern.setActionCommand("save");
        menu.add(menuItemSpeichern);
        menu.add(menuItemLaden);
        menuBar.add(menu);
        jFileChooser = new JFileChooser(new File("c://"));

        getContentPane().add(menuBar, BorderLayout.NORTH);

        hauptPanel.setLayout(new BoxLayout(hauptPanel, BoxLayout.X_AXIS));
        setSize((player1.getName().length() + player2.getName().length())  * 120, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon("MIcon.png");
        setIconImage(icon.getImage());
        setTitle("Max-Game \t || \t by Nico, Christopher, Robin");

        //playerB = new Player(Color.BLUE, "Peter", 3, 4);
        //playerG = new Player(Color.GREEN,"Hans", 4, 3);
        spielFeld = new SpielFeld(playerB, playerG);
        x = spielFeld.getX();
        y = spielFeld.getY();
        feld = spielFeld.getFeld();
        buttons = new JButton[x][y];
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                buttons[i][j] = new JButton("" + feld[i][j]);
                buttons[i][j].setFont(new Font("Courier", Font.BOLD, 22) );
                buttons[i][j].addActionListener(this);
                buttons[i][j].addMouseListener(this);
                if (i == 0) {
                    buttons[i][j].setActionCommand("" + j);
                    buttons[i][j].setName("" +j);
                }
                else {
                    buttons[i][j].setActionCommand(i + String.valueOf(j));
                    buttons[i][j].setName(i + String.valueOf(j));
                }
                buttons[i][j].setBackground(curColor);
                buttonPanel.add(buttons[i][j]);
            }
        }
        buttonPanel.setSize(600, 400);
        hauptPanel.add(buttonPanel);

        diagramm = new Diagramm(playerB.getSum(), playerB.getColor(), playerG.getSum(), playerG.getColor(), spielFeld.verbliebenPunkte());
        JPanel status = new JPanel();
        status.setLayout(new BoxLayout(status, BoxLayout.Y_AXIS));

        punkte.setLayout(new GridLayout(3,2));
        punkte.add(new JLabel(playerB.getName() + " :"));
        punkte.getComponent(0).setForeground(playerB.getColor());
        punkte.add(punktePlayerB);
        punkte.add(new JLabel(playerG.getName() + " :"));
        punkte.getComponent(2).setForeground(playerG.getColor());
        punkte.add(punktePlayerG);
        punkte.add(new JLabel("verbleibende Punkte :"));
        verbleibendePunkte.setText(spielFeld.verbliebenPunkte() + "");
        punkte.add(verbleibendePunkte);

        status.add(punkte);
        dia.setLayout(new BoxLayout(dia, BoxLayout.Y_AXIS));
        dia.add(diagramm);
        status.add(dia);

        hauptPanel.add(status);

        getContentPane().add(hauptPanel);

        setVisible(true);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("laden")) {

            jFileChooser.showOpenDialog(null);
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
                Gui gui;
                gui = (Gui) input.readObject();
                //gui visi
            } catch (IOException ev) {
                ev.printStackTrace();
            } catch (ClassNotFoundException ev) {
                ev.printStackTrace();
            }
        } else if (e.getActionCommand().equals("save")) {
            jFileChooser.showOpenDialog(null);
            ObjectOutputStream output = null;
            try {
                output = new ObjectOutputStream(new FileOutputStream(jFileChooser.getSelectedFile()));
                output.writeObject(this);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        String[] direction = onTurn.getDirection();
        /*
        int position = Integer.parseInt((int) onTurn.getPosy() +""+ onTurn.getPosx());
        String north = String.valueOf(position - 10);
        String east = String.valueOf(position + 1);
        String south = String.valueOf(position + 10);
        String west = String.valueOf(position - 1);
        */
    /*
    JOptionPane.showMessageDialog(null,"Pos. : " + position + "\n" +
            "Feld: " + e.getActionCommand() + "\n" +
            "N: " + north + "\n" +
            "E: " + east + "\n" +
            "S: " + south + "\n" +
            "W: " + west, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
     */
        if (direction[0].equals(e.getActionCommand())) {
            moved = spielFeld.movePlayer("N", onTurn);
        } else if (direction[1].equals(e.getActionCommand())) {
            moved = spielFeld.movePlayer("O", onTurn);
        } else if (direction[2].equals(e.getActionCommand())) {
            moved = spielFeld.movePlayer("S", onTurn);
        } else if (direction[3].equals(e.getActionCommand())) {
            moved = spielFeld.movePlayer("W", onTurn);
        } else {
            JOptionPane.showMessageDialog(null, "Ungültiger Zug", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            moved = false;
        }
        onTurn.updateDirection();
        updateButtons();
        if (onTurn.getSum() >= 65) {
            JOptionPane.showMessageDialog(null, onTurn.toString() + " hat gewonnen!!", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }

    private void updateButtons() {
        if (moved) {
            if (onTurn == playerB) { //Switch Player
                onTurn = playerG;
                curColor = onTurn.getColor();
            }
            else {
                onTurn = playerB;
                curColor = onTurn.getColor();
            }
            feld = spielFeld.getFeld();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    buttons[i][j].setText("" + feld[i][j]);
                    buttons[i][j].setBackground(curColor);
                }
            }
        }
        punktePlayerB.setText(playerB.getSum() + "");
        punktePlayerG.setText(playerG.getSum() + "");
        punkte.repaint();
        dia.remove(diagramm);
        diagramm = new Diagramm(playerB.getSum(), playerB.getColor(), playerG.getSum(), playerG.getColor(), spielFeld.verbliebenPunkte());
        dia.add(diagramm);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        String[] direction = onTurn.getDirection();

        if (!direction[0].equals(e.getComponent().getName()) &&
                !direction[1].equals(e.getComponent().getName()) &&
                !direction[2].equals(e.getComponent().getName()) &&
                !direction[3].equals(e.getComponent().getName())) {
            e.getComponent().setBackground(Color.BLACK);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setBackground(curColor);
    }
}
