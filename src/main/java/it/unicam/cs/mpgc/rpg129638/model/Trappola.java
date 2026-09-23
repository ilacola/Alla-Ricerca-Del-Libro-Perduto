package it.unicam.cs.mpgc.rpg129638.model;

public class Trappola implements ElementoStanza {
    private String nome;
    private int danno;
    private int difficolta;
    private String messSuccesso;
    private String messFallimento;

    public Trappola(String nome, int danno, int difficolta, String messSuccesso, String messFallimento) {
        this.nome = nome;
        this.danno = danno;
        this.difficolta = difficolta;
        this.messSuccesso = messSuccesso;
        this.messFallimento = messFallimento;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String interagisci(Ricercatore ricercatore) {
        if (ricercatore.getIntuito() >= difficolta) {
            return messSuccesso; // Trappola schivata
        } else {
            ricercatore.subisciDanno(danno);
            return messFallimento + " Hai subito " + danno + " danni.";
        }
    }
}