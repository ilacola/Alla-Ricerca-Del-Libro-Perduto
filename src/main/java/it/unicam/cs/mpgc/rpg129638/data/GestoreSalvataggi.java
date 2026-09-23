package it.unicam.cs.mpgc.rpg129638.data;

import it.unicam.cs.mpgc.rpg129638.view.GamePanel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestoreSalvataggi {
    GamePanel gp;
    String fileDiSalvataggio = "salvataggio.txt";

    public GestoreSalvataggi(GamePanel gp) {
        this.gp = gp;
    }

    public void salvaPartita() {
        // BufferedWriter scrive il testo su un file fisico
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileDiSalvataggio))) {

            // Salviamo X, Y e HP separati da una virgola
            String dati = gp.giocatore.x + "," + gp.giocatore.y + "," + gp.giocatore.hp;
            bw.write(dati);

            System.out.println("Partita SALVATA con successo! Dati: " + dati);

        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file!");
            e.printStackTrace();
        }
    }

    public void caricaPartita() {
        // BufferedReader legge il testo dal file
        try (BufferedReader br = new BufferedReader(new FileReader(fileDiSalvataggio))) {

            String riga = br.readLine(); // Legge la riga salvata
            if (riga != null) {
                // Dividiamo i dati usando la virgola come separatore
                String[] valori = riga.split(",");

                // Aggiorniamo le statistiche del giocatore convertendo il testo in numeri (Integer)
                gp.giocatore.x = Integer.parseInt(valori[0]);
                gp.giocatore.y = Integer.parseInt(valori[1]);
                gp.giocatore.hp = Integer.parseInt(valori[2]);

                System.out.println("Partita CARICATA con successo! Bentornato.");
            }

        } catch (IOException e) {
            System.out.println("Nessun file di salvataggio trovato (oppure errore di lettura).");
        }
    }
}