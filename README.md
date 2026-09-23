# Alla Ricerca del Libro Perduto

Un videogioco RPG 2D (stile dungeon crawler) sviluppato in Java, realizzato come progetto accademico. Il gioco presenta esplorazione tile-based, sistema di combattimento, inventario, elementi interattivi e persistenza dei dati.

## ⚙️ Come avviare il gioco

Il progetto è gestito tramite Gradle. Per avviare l'applicazione:
1. Assicurati di avere il JDK 17 (o superiore) installato.
2. Clona il repository o scarica i sorgenti.
3. Apri il terminale nella root del progetto ed esegui:
   `./gradlew run`

## 🎮 Comandi di Gioco

*   **W / A / S / D:** Movimento del giocatore
*   **E:** Azione (Attacca nemici / Raccogli oggetti / Interagisci con porte e forzieri)
*   **I:** Salva la partita
*   **O:** Carica l'ultimo salvataggio
*   **INVIO:** Seleziona opzioni nel Menu Principale

## 🏗️ Architettura e Principi di Design (SOLID)

Il progetto è stato strutturato ponendo forte enfasi sui principi della programmazione orientata agli oggetti e sull'architettura pulita (circa 30 classi totali).

*   **Pattern MVC (Model-View-Controller):** Netta separazione tra la logica dei dati (package `entity`, `item`, `interactable`), la grafica (`view` e UI) e i gestori degli input/eventi (`controller`).
*   **Single Responsibility Principle:** Classi come `GestoreCollisioni`, `GestoreSalvataggi` e `KeyHandler` hanno una singola responsabilità ben definita, alleggerendo il `GamePanel`.
*   **Interface Segregation & Dependency Inversion:** Sono state implementate interfacce specifiche per definire i "contratti" delle entità:
    *   `Interagibile`: Per gli elementi dello scenario che rispondono alle azioni (es. `Porta`, `Forziere`).
    *   `Danneggiabile`: Per le entità che possono subire colpi, garantendo un sistema di combattimento polimorfico.
    *   `Disegnabile`: Per standardizzare il rendering grafico.
*   **Polimorfismo:** Gestione unificata di oggetti a terra e interattivi tramite array di superclassi (`Oggetto[]`, `ElementoInterattivo[]`), dove ogni sottoclasse implementa in modo unico il proprio comportamento.

## 💾 Funzionalità Implementate

*   **Macchina a Stati:** Gestione fluida delle transizioni tra Menu Principale (`titleState`) e Partita in corso (`playState`).
*   **Gestione Collisioni Predittiva:** Calcolo anticipato della hitbox per impedire il compenetramento con muri e ostacoli solidi.
*   **Sistema Inventario:** Raccolta dinamica e conservazione degli oggetti trovati sulla mappa.
*   **Persistenza dei Dati (I/O):** Salvataggio e caricamento dello stato del giocatore (coordinate e HP) su file di testo (`salvataggio.txt`).