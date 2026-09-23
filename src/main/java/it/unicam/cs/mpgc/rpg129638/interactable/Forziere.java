package it.unicam.cs.mpgc.rpg129638.interactable;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;

public class Forziere extends ElementoInterattivo {

    public Forziere() {
        this.nome = "Forziere di Legno";
    }

    @Override
    public void interagisci(Giocatore giocatore) {
        if (interazioneCompletata) {
            System.out.println("Hai già svuotato questo forziere.");
            return;
        }

        System.out.println("Apri il forziere e trovi... 100 Monete d'oro!");
        interazioneCompletata = true;
        // In futuro cambieremo l'immagine per mostrarlo aperto
    }
}