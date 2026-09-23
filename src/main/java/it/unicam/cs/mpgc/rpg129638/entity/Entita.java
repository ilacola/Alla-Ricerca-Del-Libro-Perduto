package it.unicam.cs.mpgc.rpg129638.entity;

import java.awt.image.BufferedImage;
import it.unicam.cs.mpgc.rpg129638.view.Disegnabile;

/**
 * Classe astratta che rappresenta qualsiasi creatura viva nel gioco (Giocatore, Mostri, NPC)
 */

public abstract class Entita implements Disegnabile {    public int x, y;
    public int speed;
    public BufferedImage sprite;
}