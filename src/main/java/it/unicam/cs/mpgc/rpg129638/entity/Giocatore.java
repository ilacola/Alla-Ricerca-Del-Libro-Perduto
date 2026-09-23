package it.unicam.cs.mpgc.rpg129638.entity;

import it.unicam.cs.mpgc.rpg129638.controller.KeyHandler;
import it.unicam.cs.mpgc.rpg129638.view.GamePanel;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

public class Giocatore extends Entita {
    GamePanel gp;
    KeyHandler keyH;

    // NUOVO: Variabili per la salute
    public int maxHp;
    public int hp;
    public Inventario inventario = new Inventario();
    public Giocatore(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        impostaValoriIniziali();
        caricaImmagine();
    }

    public void impostaValoriIniziali() {
        x = 100;
        y = 100;
        speed = 4;

        // NUOVO: Impostiamo la vita iniziale
        maxHp = 50;
        hp = 50;
    }

    // ... resto del codice invariato ...

    public void caricaImmagine() {
        try {
            sprite = ImageIO.read(getClass().getResourceAsStream("/player.png"));
        } catch (IOException e) {
            System.out.println("Errore nel caricamento di player.png");
        }
    }

    public void update() {
        // --- 1. GESTIONE MOVIMENTO E COLLISIONI ---
        int nextX = x;
        int nextY = y;

        if (keyH.upPressed) nextY -= speed;
        else if (keyH.downPressed) nextY += speed;
        else if (keyH.leftPressed) nextX -= speed;
        else if (keyH.rightPressed) nextX += speed;

        if (nextX != x || nextY != y) {
            // Controlla se la futura posizione sbatte contro un muro
            boolean sbatteControMuro = gp.gestoreC.controllaMuro(nextX, nextY);

            // Controlla se stiamo calpestando un oggetto a terra
            int indiceOggettoToccato = gp.gestoreC.controllaOggetto(nextX, nextY);
            raccogliOggetto(indiceOggettoToccato);

            // Se non sbatti contro il muro, muoviti effettivamente
            if (!sbatteControMuro) {
                x = nextX;
                y = nextY;
            }
        }

        // --- 2. GESTIONE AZIONI (TASTO E) ---
        if (keyH.attackPressed) {

            // A. Logica di Combattimento (Tramite interfaccia Danneggiabile)
            if (gp.nemico != null && gp.nemico.isVivo()) {
                int distanzaX = Math.abs(this.x - gp.nemico.x);
                int distanzaY = Math.abs(this.y - gp.nemico.y);

                if (distanzaX < gp.tileSize * 1.5 && distanzaY < gp.tileSize * 1.5) {

                    // Infliggiamo il danno tramite il metodo ufficiale
                    gp.nemico.subisciDanno(10);
                    System.out.println("Colpito! HP Mostro: " + gp.nemico.getHp());

                    if (!gp.nemico.isVivo()) {
                        System.out.println("Hai sconfitto il mostro!");
                    }
                }
            }

            // B. Logica Elementi Interattivi (Tramite interfaccia Interagibile)
            for(int i = 0; i < gp.interattivi.length; i++) {
                if(gp.interattivi[i] != null) {
                    int dX = Math.abs(this.x - gp.interattivi[i].x);
                    int dY = Math.abs(this.y - gp.interattivi[i].y);

                    // Se sei vicino a un elemento interattivo (meno di 1.5 tile)
                    if (dX < gp.tileSize * 1.5 && dY < gp.tileSize * 1.5) {
                        gp.interattivi[i].interagisci(this);
                    }
                }
            }

            // Resetta la pressione del tasto per evitare attivazioni multiple
            keyH.attackPressed = false;
        }
    }
    public void raccogliOggetto(int i) {
        if (i != -1) {
            // Proviamo ad aggiungere l'oggetto all'inventario
            boolean raccolto = inventario.aggiungiOggetto(gp.oggettiMappa[i]);

            if (raccolto) {
                // Attiviamo l'effetto (es. la pozione ti cura, la spada ti dà attacco)
                gp.oggettiMappa[i].effetto(this);

                // Rimuoviamo l'oggetto dalla mappa in modo che sparisca
                gp.oggettiMappa[i] = null;
            }
        }
    }
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, gp.tileSize, gp.tileSize, null);
        } else {
            g2.setColor(Color.RED);
            g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        }
    }
}