package it.unicam.cs.mpgc.rpg129638.tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    public boolean collisione = false; // Ci servirà nel prossimo step per non far passare il personaggio attraverso i muri
}