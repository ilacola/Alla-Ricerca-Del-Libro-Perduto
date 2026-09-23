package it.unicam.cs.mpgc.rpg129638.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    GamePanel gp;
    Font arial_30;
    Font arial_60_bold;
    public int commandNum = 0; // Tiene traccia di quale voce del menu stiamo selezionando

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_30 = new Font("Arial", Font.BOLD, 30);
        arial_60_bold = new Font("Arial", Font.BOLD, 60);
    }

    public void draw(Graphics2D g2) {
        if (gp.gameState == gp.titleState) {
            drawTitleScreen(g2);
        } else if (gp.gameState == gp.playState) {
            drawHUD(g2);
        }
    }

    public void drawTitleScreen(Graphics2D g2) {
        // Sfondo Blu Notte elegante
        g2.setColor(new Color(20, 25, 40));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        // TITOLO
        g2.setFont(arial_60_bold);
        String text = "IL LIBRO PERDUTO";
        int x = calcolaCentroX(text, g2);
        int y = gp.tileSize * 3;

        // Ombra del titolo
        g2.setColor(Color.BLACK);
        g2.drawString(text, x + 4, y + 4);
        // Testo del titolo
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        // MENU OPZIONI
        g2.setFont(arial_30);

        text = "NUOVA PARTITA";
        x = calcolaCentroX(text, g2);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if (commandNum == 0) g2.drawString(">", x - gp.tileSize, y);

        text = "CARICA PARTITA";
        x = calcolaCentroX(text, g2);
        y += gp.tileSize + 20;
        g2.drawString(text, x, y);
        if (commandNum == 1) g2.drawString(">", x - gp.tileSize, y);

        text = "ESCI";
        x = calcolaCentroX(text, g2);
        y += gp.tileSize + 20;
        g2.drawString(text, x, y);
        if (commandNum == 2) g2.drawString(">", x - gp.tileSize, y);
    }

    public void drawHUD(Graphics2D g2) {
        // Disegna la vecchia barra degli HP durante la partita
        g2.setFont(arial_30);
        g2.setColor(Color.WHITE);
        g2.drawString("HP: " + gp.giocatore.hp + "/" + gp.giocatore.maxHp, 20, 40);

        int lunghezzaBarraMax = gp.giocatore.maxHp * 3;
        g2.setColor(Color.RED);
        g2.fillRect(20, 50, lunghezzaBarraMax, 20);

        int lunghezzaBarraAttuale = gp.giocatore.hp * 3;
        g2.setColor(Color.GREEN);
        g2.fillRect(20, 50, lunghezzaBarraAttuale, 20);
    }

    // Metodo di utilità per centrare perfettamente qualsiasi testo
    public int calcolaCentroX(String text, Graphics2D g2) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth / 2 - length / 2;
    }
}