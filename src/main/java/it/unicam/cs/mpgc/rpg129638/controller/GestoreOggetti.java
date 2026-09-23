package it.unicam.cs.mpgc.rpg129638.controller;

import it.unicam.cs.mpgc.rpg129638.item.Chiave;
import it.unicam.cs.mpgc.rpg129638.item.PozioneSalute;
import it.unicam.cs.mpgc.rpg129638.view.GamePanel;

public class GestoreOggetti {
    GamePanel gp;

    public GestoreOggetti(GamePanel gp) {
        this.gp = gp;
    }

    public void posizionaOggetti() {
        // Creiamo una pozione e la mettiamo alla coordinata (colonna 8, riga 4)
        gp.oggettiMappa[0] = new PozioneSalute();
        gp.oggettiMappa[0].x = 8 * gp.tileSize;
        gp.oggettiMappa[0].y = 4 * gp.tileSize;

        // Creiamo una chiave alla coordinata (colonna 3, riga 7)
        gp.oggettiMappa[1] = new Chiave();
        gp.oggettiMappa[1].x = 3 * gp.tileSize;
        gp.oggettiMappa[1].y = 7 * gp.tileSize;
    }
}