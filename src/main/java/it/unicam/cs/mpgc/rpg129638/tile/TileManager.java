package it.unicam.cs.mpgc.rpg129638.tile;

import it.unicam.cs.mpgc.rpg129638.view.GamePanel;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    public Tile[] tipiTile;
    public int[][] mappaStanza;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.tipiTile = new Tile[10]; // Possiamo avere fino a 10 tipi di blocchi diversi

        caricaImmaginiTile();
        caricaMappa();
    }

    public void caricaImmaginiTile() {
        try {
            // 0 = Pavimento
            tipiTile[0] = new Tile();
            // Inserisci qui il nome esatto del tuo file per l'erba
            tipiTile[0].image = ImageIO.read(getClass().getResourceAsStream("/pavimento.png"));

            // 1 = Muro
            tipiTile[1] = new Tile();
            // Inserisci qui il nome esatto del tuo file per il muro
            tipiTile[1].image = ImageIO.read(getClass().getResourceAsStream("/muro.png"));
            tipiTile[1].collisione = true;

        } catch (IOException e) {
            System.out.println("Immagini pavimento/muro non trovate! Userò dei colori di base.");
        }
    }

    public void caricaMappa() {
        // Una griglia 16 colonne x 12 righe. Disegna tu la stanza cambiando gli 0 e gli 1!
        mappaStanza = new int[][] {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
    }

    public void draw(Graphics2D g2) {
        // Scorre tutta la matrice e disegna il tile corrispondente alle coordinate esatte
        for (int riga = 0; riga < gp.maxScreenRow; riga++) {
            for (int col = 0; col < gp.maxScreenCol; col++) {

                int tipoTile = mappaStanza[riga][col];
                int x = col * gp.tileSize;
                int y = riga * gp.tileSize;

                if (tipiTile[tipoTile] != null && tipiTile[tipoTile].image != null) {
                    g2.drawImage(tipiTile[tipoTile].image, x, y, gp.tileSize, gp.tileSize, null);
                } else {
                    // Se manca l'immagine, disegna un quadrato colorato (grigio scuro per il muro, grigio chiaro per pavimento)
                    if (tipoTile == 1) g2.setColor(Color.DARK_GRAY);
                    else g2.setColor(Color.LIGHT_GRAY);
                    g2.fillRect(x, y, gp.tileSize, gp.tileSize);
                }
            }
        }
    }
}