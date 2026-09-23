package it.unicam.cs.mpgc.rpg129638.item;

import it.unicam.cs.mpgc.rpg129638.entity.Giocatore;

public class PozioneSalute extends Oggetto {
    private int valoreCura;

    public PozioneSalute() {
        this.nome = "Pozione di Cura";
        this.valoreCura = 20;
        // In futuro qui caricherai l'immagine: image = ImageIO.read(... "/pozione.png");
    }

    @Override
    public void effetto(Giocatore giocatore) {
        giocatore.hp += valoreCura;
        if (giocatore.hp > giocatore.maxHp) {
            giocatore.hp = giocatore.maxHp;
        }
        System.out.println("Hai recuperato " + valoreCura + " HP!");
    }
}