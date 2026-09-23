package it.unicam.cs.mpgc.rpg129638.interactable;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;
import it.unicam.cs.mpgc.rpg129638.item.Oggetto;

public class Porta extends ElementoInterattivo {

    public Porta() {
        this.nome = "Porta Misteriosa";
    }

    @Override
    public void interagisci(Giocatore giocatore) {
        if (interazioneCompletata) return;

        boolean haChiave = false;
        Oggetto chiaveDaUsare = null;

        // Cerca la chiave nell'inventario del giocatore
        for (Oggetto obj : giocatore.inventario.borsa) {
            if (obj.nome.equals("Chiave Antica")) {
                haChiave = true;
                chiaveDaUsare = obj;
                break;
            }
        }

        if (haChiave) {
            System.out.println("Hai inserito la Chiave Antica. La porta si apre scricchiolando!");
            giocatore.inventario.borsa.remove(chiaveDaUsare); // Consuma la chiave
            interazioneCompletata = true;
            // In futuro qui potrai far cambiare stanza al giocatore!
        } else {
            System.out.println("La porta è chiusa a chiave. Ti serve la Chiave Antica.");
        }
    }
}