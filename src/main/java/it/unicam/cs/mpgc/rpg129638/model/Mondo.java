package it.unicam.cs.mpgc.rpg129638.model;

import java.util.ArrayList;
import java.util.List;

public class Mondo {
    private String nome;
    private List<Stanza> stanze;
    private int stanzaCorrenteIndex;

    public Mondo(String nome) {
        this.nome = nome;
        this.stanze = new ArrayList<>();
        this.stanzaCorrenteIndex = 0; // Iniziamo dalla prima stanza
    }

    /**
     * Aggiunge una stanza al mondo, rispettando il limite di 10 stanze.
     */
    public void aggiungiStanza(Stanza stanza) {
        if (stanze.size() < 10) {
            stanze.add(stanza);
        } else {
            System.out.println("Questo mondo ha già raggiunto il limite di 10 stanze!");
        }
    }

    public Stanza getStanzaCorrente() {
        if (stanze.isEmpty()) {
            return null;
        }
        return stanze.get(stanzaCorrenteIndex);
    }

    /**
     * Permette di passare alla stanza successiva se l'attuale è stata completata.
     * @return true se è possibile avanzare, false altrimenti.
     */
    public boolean avanzaAllaProssimaStanza() {
        if (getStanzaCorrente() != null && getStanzaCorrente().isCompletata()) {
            if (stanzaCorrenteIndex < stanze.size() - 1) {
                stanzaCorrenteIndex++;
                return true;
            }
        }
        return false;
    }

    /**
     * Controlla se il mondo è stato completato (il ricercatore ha superato l'ultima stanza).
     */
    public boolean isCompletato() {
        return stanzaCorrenteIndex == stanze.size() - 1 &&
                getStanzaCorrente() != null &&
                getStanzaCorrente().isCompletata();
    }

    public String getNome() {
        return nome;
    }
}