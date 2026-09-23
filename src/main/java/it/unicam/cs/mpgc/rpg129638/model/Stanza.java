package it.unicam.cs.mpgc.rpg129638.model;

public class Stanza {
    private String descrizione;
    private ElementoStanza contenuto; // Mostro, Trappola, o Tesoro
    private boolean completata;

    public Stanza(String descrizione, ElementoStanza contenuto) {
        this.descrizione = descrizione;
        this.contenuto = contenuto;
        this.completata = false;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public boolean isCompletata() {
        return completata;
    }

    /**
     * Permette al ricercatore di affrontare ciò che c'è nella stanza.
     */
    public String esplora(Ricercatore ricercatore) {
        if (completata) {
            return "La stanza è già stata esplorata e messa in sicurezza.";
        }

        String risultatoInterazione = contenuto.interagisci(ricercatore);

        // Se il ricercatore è sopravvissuto, possiamo considerare la stanza completata
        if (ricercatore.getHp() > 0) {
            this.completata = true;
        }

        return risultatoInterazione;
    }
}
