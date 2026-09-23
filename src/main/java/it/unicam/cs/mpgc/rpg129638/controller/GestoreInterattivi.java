package it.unicam.cs.mpgc.rpg129638.controller;

import it.unicam.cs.mpgc.rpg129638.interactable.Forziere;
import it.unicam.cs.mpgc.rpg129638.interactable.Porta;
import it.unicam.cs.mpgc.rpg129638.view.GamePanel;

public class GestoreInterattivi {
    GamePanel gp;

    public GestoreInterattivi(GamePanel gp) {
        this.gp = gp;
    }

    public void posizionaElementi() {
        // Piazziamo una porta davanti al passaggio (es. colonna 10, riga 5)
        gp.interattivi[0] = new Porta();
        gp.interattivi[0].x = 10 * gp.tileSize;
        gp.interattivi[0].y = 5 * gp.tileSize;

        // Piazziamo un forziere in un angolo (es. colonna 13, riga 2)
        gp.interattivi[1] = new Forziere();
        gp.interattivi[1].x = 13 * gp.tileSize;
        gp.interattivi[1].y = 2 * gp.tileSize;
    }
}