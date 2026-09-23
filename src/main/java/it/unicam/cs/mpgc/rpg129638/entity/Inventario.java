package it.unicam.cs.mpgc.rpg129638.entity;

import it.unicam.cs.mpgc.rpg129638.item.Oggetto;
import java.util.ArrayList;

public class Inventario {
    public ArrayList<Oggetto> borsa = new ArrayList<>();
    public final int capienzaMax = 10;

    public boolean aggiungiOggetto(Oggetto obj) {
        if (borsa.size() < capienzaMax) {
            borsa.add(obj);
            System.out.println("Raccolto: " + obj.nome);
            return true;
        } else {
            System.out.println("Inventario pieno! Non puoi raccogliere " + obj.nome);
            return false;
        }
    }
}