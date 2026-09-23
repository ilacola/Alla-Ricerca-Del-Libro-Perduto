package it.unicam.cs.mpgc.rpg129638.model;

public class Mostro implements ElementoStanza {
    private String nome;
    private int hp;
    private int forzaAttacco;
    private int esperienzaRilasciata;

    public Mostro(String nome, int hp, int forzaAttacco, int esperienzaRilasciata) {
        this.nome = nome;
        this.hp = hp;
        this.forzaAttacco = forzaAttacco;
        this.esperienzaRilasciata = esperienzaRilasciata;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String interagisci(Ricercatore ricercatore) {
        // Simulazione di un combattimento a turni semplificato per ora
        ricercatore.subisciDanno(forzaAttacco);

        if (ricercatore.getHp() > 0) {
            ricercatore.guadagnaEsperienza(esperienzaRilasciata);
            return "Hai sconfitto " + nome + " guadagnando " + esperienzaRilasciata + " exp, ma hai subito " + forzaAttacco + " danni.";
        } else {
            return "Sei stato sconfitto da " + nome + "...";
        }
    }
}