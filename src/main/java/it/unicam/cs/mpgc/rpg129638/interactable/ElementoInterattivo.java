package it.unicam.cs.mpgc.rpg129638.interactable;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;
import it.unicam.cs.mpgc.rpg129638.view.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class ElementoInterattivo implements Interagibile {
    public BufferedImage image;
    public String nome;
    public int x, y;
    public boolean interazioneCompletata = false; // Serve per non ripetere l'azione all'infinito

    // Ogni elemento reagirà in modo diverso quando premiamo "E"
    public abstract void interagisci(Giocatore giocatore);

    public void draw(Graphics2D g2, GamePanel gp) {
        if (image != null) {
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        } else {
            // Fallback: Disegna un blocco arancione se non carichi un'immagine png
            g2.setColor(Color.ORANGE);
            g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        }
    }
}