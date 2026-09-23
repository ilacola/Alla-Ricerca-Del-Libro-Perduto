package it.unicam.cs.mpgc.rpg129638.item;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;

public class Chiave extends Oggetto {

    public Chiave() {
        this.nome = "Chiave Antica";
    }

    @Override
    public void effetto(Giocatore giocatore) {
        System.out.println("Hai raccolto una chiave! Ti servirà per aprire una porta.");
        // Nel prossimo step aggiungeremo l'inventario al Giocatore per conservarla
    }
}