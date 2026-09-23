package it.unicam.cs.mpgc.rpg129638.model;

public class Tesoro implements ElementoStanza {
    private String nome;
    private String tipoBonus; // Es: "HP", "FORZA", "INTUITO"
    private int valoreBonus;
    private String messaggio;

    public Tesoro(String nome, String tipoBonus, int valoreBonus, String messaggio) {
        this.nome = nome;
        this.tipoBonus = tipoBonus;
        this.valoreBonus = valoreBonus;
        this.messaggio = messaggio;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String interagisci(Ricercatore ricercatore) {
        if (tipoBonus.equalsIgnoreCase("HP")) {
            ricercatore.cura(valoreBonus);
        }
        // In futuro potrai aggiungere setter nella classe Ricercatore per aumentare FORZA o INTUITO
        return messaggio + " Hai recuperato " + valoreBonus + " " + tipoBonus + ".";
    }
}