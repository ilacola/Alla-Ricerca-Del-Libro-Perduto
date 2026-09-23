package it.unicam.cs.mpgc.rpg129638.view;

import it.unicam.cs.mpgc.rpg129638.controller.GestoreCollisioni;
import it.unicam.cs.mpgc.rpg129638.controller.KeyHandler;
import it.unicam.cs.mpgc.rpg129638.data.GestoreSalvataggi;
import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;
import it.unicam.cs.mpgc.rpg129638.entity.Mostro;
import it.unicam.cs.mpgc.rpg129638.tile.TileManager;
import it.unicam.cs.mpgc.rpg129638.item.Oggetto; // Assicurati di importarlo
import it.unicam.cs.mpgc.rpg129638.controller.GestoreOggetti;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import it.unicam.cs.mpgc.rpg129638.interactable.ElementoInterattivo;
import it.unicam.cs.mpgc.rpg129638.controller.GestoreInterattivi;
public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    // STATI DI GIOCO
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Gestori esterni
    public TileManager tileM = new TileManager(this);
    public GestoreCollisioni gestoreC = new GestoreCollisioni(this);
    public UI ui = new UI(this); // NUOVO
    // Entità
    public GestoreSalvataggi gestoreSalvataggi = new GestoreSalvataggi(this);
    public Giocatore giocatore = new Giocatore(this, keyH);
    public Mostro nemico = new Mostro(this); // NUOVO (Ricorda di importarlo se richiesto)
    public Oggetto[] oggettiMappa = new Oggetto[10]; // Possiamo avere max 10 oggetti a terra
    public ElementoInterattivo[] interattivi = new ElementoInterattivo[10];
    public GestoreInterattivi gestoreInterattivi = new GestoreInterattivi(this);
    public GestoreOggetti gestoreOggetti = new GestoreOggetti(this);
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        gestoreOggetti.posizionaOggetti();
        gestoreInterattivi.posizionaElementi();
        gameState = titleState;
        gameState = titleState; // NUOVO: Si parte dal menu principale
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / 60;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = (nextDrawTime - System.nanoTime()) / 1000000;
                if (remainingTime < 0) remainingTime = 0;
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (gameState == titleState) {
            // Logica del Menu Principale
            if (keyH.upPressed) {
                ui.commandNum--;
                if (ui.commandNum < 0) ui.commandNum = 2;
                keyH.upPressed = false; // Resetta per evitare scroll troppo veloci
            }
            if (keyH.downPressed) {
                ui.commandNum++;
                if (ui.commandNum > 2) ui.commandNum = 0;
                keyH.downPressed = false;
            }

            if (keyH.enterPressed) {
                if (ui.commandNum == 0) { // Nuova Partita
                    gameState = playState;
                }
                if (ui.commandNum == 1) { // Carica Partita
                    gestoreSalvataggi.caricaPartita();
                    gameState = playState;
                }
                if (ui.commandNum == 2) { // Esci
                    System.exit(0);
                }
                keyH.enterPressed = false;
            }

        } else if (gameState == playState) {
            // Logica della partita vera e propria
            giocatore.update();

            if (keyH.savePressed) {
                gestoreSalvataggi.salvaPartita();
                keyH.savePressed = false;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleState) {
            // Se siamo nel menu, disegna SOLO la UI (che stamperà il titolo)
            ui.draw(g2);
        } else if (gameState == playState) {
            // Se stiamo giocando, disegna mappa, personaggi e HUD
            tileM.draw(g2);
            for (int i = 0; i < oggettiMappa.length; i++) {
                if (oggettiMappa[i] != null) {
                    oggettiMappa[i].draw(g2, this);
                }
            }
            for (int i = 0; i < interattivi.length; i++) {
                if (interattivi[i] != null) {
                    interattivi[i].draw(g2, this);
                }
            }
            nemico.draw(g2);
            giocatore.draw(g2);
            ui.draw(g2);
        }

        g2.dispose();
    }
}