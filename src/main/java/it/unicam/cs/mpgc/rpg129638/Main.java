package it.unicam.cs.mpgc.rpg129638;

import it.unicam.cs.mpgc.rpg129638.view.GamePanel;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Creiamo la finestra principale
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // Impediamo di ridimensionare la finestra per non rompere la griglia
        window.setTitle("Alla ricerca del libro perduto");

        // Aggiungiamo la nostra "tela" del gioco alla finestra
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); // Adatta la finestra alle dimensioni calcolate dal GamePanel

        window.setLocationRelativeTo(null); // Centra la finestra nello schermo
        window.setVisible(true);

        // Facciamo partire il ciclo continuo del gioco
        gamePanel.startGameThread();
    }
}