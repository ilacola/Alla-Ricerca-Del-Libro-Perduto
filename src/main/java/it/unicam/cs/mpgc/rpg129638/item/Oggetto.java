package it.unicam.cs.mpgc.rpg129638.item;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;
import it.unicam.cs.mpgc.rpg129638.view.GamePanel;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Oggetto {
    public BufferedImage image;
    public String nome;
    public boolean collisione = false;
    public int x, y;

    // Metodo astratto che ogni oggetto specifico implementerà a modo suo (Polimorfismo)
    public abstract void effetto(Giocatore giocatore);

    public void draw(Graphics2D g2, GamePanel gp) {
        if (image != null) {
            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        }
    }
}