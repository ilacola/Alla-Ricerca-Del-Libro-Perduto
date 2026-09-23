package it.unicam.cs.mpgc.rpg129638.model;

/**
 * Rappresenta un qualsiasi elemento che può essere contenuto in una Stanza
 * (Mostro, Trappola, Tesoro, o il Libro Perduto).
 */
public interface ElementoStanza {
    String getNome();

    /**
     * Gestisce l'interazione tra il Ricercatore e l'elemento della stanza.
     * @param ricercatore il protagonista del gioco
     * @return un messaggio che descrive l'esito dell'interazione
     */
    String interagisci(Ricercatore ricercatore);
}