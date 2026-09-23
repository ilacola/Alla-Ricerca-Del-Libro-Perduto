package it.unicam.cs.mpgc.rpg129638.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, attackPressed;
    public boolean savePressed, loadPressed, enterPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) { upPressed = true; }
        if (code == KeyEvent.VK_S) { downPressed = true; }
        if (code == KeyEvent.VK_A) { leftPressed = true; }
        if (code == KeyEvent.VK_D) { rightPressed = true; }
        if (code == KeyEvent.VK_E) { attackPressed = true; } // NUOVO
        if (code == KeyEvent.VK_I) { savePressed = true; }
        if (code == KeyEvent.VK_O) { loadPressed = true; }
        if (code == KeyEvent.VK_ENTER) { enterPressed = true; }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) { upPressed = false; }
        if (code == KeyEvent.VK_S) { downPressed = false; }
        if (code == KeyEvent.VK_A) { leftPressed = false; }
        if (code == KeyEvent.VK_D) { rightPressed = false; }
        if (code == KeyEvent.VK_E) { attackPressed = false; } // NUOVO
        if (code == KeyEvent.VK_I) { savePressed = false; }
        if (code == KeyEvent.VK_O) { loadPressed = false; }
        if (code == KeyEvent.VK_ENTER) { enterPressed = false; }
    }
}