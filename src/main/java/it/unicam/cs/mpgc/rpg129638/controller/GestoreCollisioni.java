package it.unicam.cs.mpgc.rpg129638.controller;

import it.unicam.cs.mpgc.rpg129638.view.GamePanel;

public class GestoreCollisioni {
    GamePanel gp;

    public GestoreCollisioni(GamePanel gp) {
        this.gp = gp;
    }

    public boolean controllaMuro(int xFuturo, int yFuturo) {
        // Calcoliamo a quale colonna e riga della griglia corrisponde la futura posizione.
        // Stringiamo leggermente l'area (hitbox) aggiungendo un margine di 10 pixel
        // per evitare che il personaggio si incastri spigolo contro spigolo.
        int colSinistra = (xFuturo + 10) / gp.tileSize;
        int colDestra = (xFuturo + gp.tileSize - 10) / gp.tileSize;
        int rigaSuperiore = (yFuturo + 10) / gp.tileSize;
        int rigaInferiore = (yFuturo + gp.tileSize - 10) / gp.tileSize;

        // Se il giocatore cerca di uscire dai bordi fisici della finestra, blocchiamolo
        if (colSinistra < 0 || colDestra >= gp.maxScreenCol || rigaSuperiore < 0 || rigaInferiore >= gp.maxScreenRow) {
            return true;
        }

        // Troviamo l'ID del tile (0 o 1) per i quattro angoli della hitbox del giocatore
        int tileInAltoASinistra = gp.tileM.mappaStanza[rigaSuperiore][colSinistra];
        int tileInAltoADestra = gp.tileM.mappaStanza[rigaSuperiore][colDestra];
        int tileInBassoASinistra = gp.tileM.mappaStanza[rigaInferiore][colSinistra];
        int tileInBassoADestra = gp.tileM.mappaStanza[rigaInferiore][colDestra];

        // Se almeno uno degli angoli tocca un tile solido, c'è collisione
        if (gp.tileM.tipiTile[tileInAltoASinistra].collisione ||
                gp.tileM.tipiTile[tileInAltoADestra].collisione ||
                gp.tileM.tipiTile[tileInBassoASinistra].collisione ||
                gp.tileM.tipiTile[tileInBassoADestra].collisione) {
            return true; // Il giocatore sta sbattendo contro un muro
        }

        return false; // Nessuna collisione, via libera
    }
    public int controllaOggetto(int xFuturo, int yFuturo) {
        int indiceOggetto = -1;

        for (int i = 0; i < gp.oggettiMappa.length; i++) {
            if (gp.oggettiMappa[i] != null) {
                // Calcoliamo la distanza tra la posizione futura e l'oggetto
                int distanzaX = Math.abs(xFuturo - gp.oggettiMappa[i].x);
                int distanzaY = Math.abs(yFuturo - gp.oggettiMappa[i].y);

                // Se siamo molto vicini al centro dell'oggetto (meno di mezzo tile di distanza)
                if (distanzaX < gp.tileSize / 2 && distanzaY < gp.tileSize / 2) {
                    indiceOggetto = i;
                    break; // Trovato l'oggetto, fermiamo il ciclo
                }
            }
        }
        return indiceOggetto;
    }
}