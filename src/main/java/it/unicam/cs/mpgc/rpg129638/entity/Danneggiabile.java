package it.unicam.cs.mpgc.rpg129638.entity;

public interface Danneggiabile {
    void subisciDanno(int quantita);
    boolean isVivo();
    int getHp();
}