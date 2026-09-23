package it.unicam.cs.mpgc.rpg129638.model;

public class Ricercatore {
    private int hp;
    private int hpMax; // Utile per non superare la vita massima con le pozioni
    private int forza;
    private int intuito;
    private int esperienza;
    private int livello;

    public Ricercatore(int hpMax, int forza, int intuito) {
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.forza = forza;
        this.intuito = intuito;
        this.esperienza = 0;
        this.livello = 1;
    }

    // Getters e Setters base
    public int getHp() { return hp; }
    public int getForza() { return forza; }
    public int getIntuito() { return intuito; }
    public int getEsperienza() { return esperienza; }

    public void subisciDanno(int danno) {
        this.hp -= danno;
        if (this.hp < 0) this.hp = 0;
    }

    public void cura(int ammontare) {
        this.hp += ammontare;
        if (this.hp > hpMax) this.hp = hpMax;
    }

    public void guadagnaEsperienza(int exp) {
        this.esperienza += exp;
        controllaAumentoLivello();
    }

    private void controllaAumentoLivello() {
        // Logica per salire di livello (es. ogni 100 exp)
        if (this.esperienza >= 100 * livello) {
            this.livello++;
            this.forza += 2; // Esempio di potenziamento al level up
            this.intuito += 1;
            this.hpMax += 10;
            this.hp = hpMax; // Ripristina la salute
        }
    }
}
