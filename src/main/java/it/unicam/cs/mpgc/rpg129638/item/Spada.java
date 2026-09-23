package it.unicam.cs.mpgc.rpg129638.item;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;

public class Spada extends Oggetto {

    public Spada() {
        this.nome = "Spada di Ferro";
    }

    @Override
    public void effetto(Giocatore giocatore) {
        System.out.println("Hai trovato un'arma! Il tuo attacco aumenta.");
        // Aumenteremo la statistica di attacco del giocatore
    }
}