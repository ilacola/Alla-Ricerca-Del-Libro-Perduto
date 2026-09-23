package it.unicam.cs.mpgc.rpg129638.entity;

import it.unicam.cs.mpgc.rpg129638.view.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;

import it.unicam.cs.mpgc.rpg129638.view.GamePanel;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Mostro extends Entita implements Danneggiabile {    GamePanel gp;
    public int hp = 20;
    public boolean vivo = true;

    public Mostro(GamePanel gp) {
        this.gp = gp;
        this.x = 400;
        this.y = 300;
        caricaImmagine();
    }

    public void caricaImmagine() {
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream("/nemico.png"));
        } catch (IOException e) {
            System.out.println("Immagine nemico.png non trovata!");
        }
    }

    public void draw(Graphics2D g2) {
        if (vivo) {
            if (sprite != null) {
                g2.drawImage(sprite, x, y, gp.tileSize, gp.tileSize, null);
            }
        }
    }
    @Override
    public void subisciDanno(int quantita) {
        this.hp -= quantita;
        if (this.hp <= 0) {
            this.vivo = false;
        }
    }

    @Override
    public boolean isVivo() {
        return this.vivo;
    }

    @Override
    public int getHp() {
        return this.hp;
    }
}