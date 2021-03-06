package com.wc.bestgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by wc_an on 5/5/2017.
 */
public class KeyManager implements KeyListener {

    public boolean up, down, left, right, space;
    public boolean aUp, aDown, aLeft, aRight;
    private boolean[] keys, justPressed, cantPress;
    private int PressTime;
    private int Releasetime;

    public KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];

    }

    public void tick() {
        for (int i = 0; i < keys.length; i++) {
            if (cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if (justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;

            }
            if (!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }

            if (keyJustPressed(KeyEvent.VK_E)){
                System.out.println("E just pressed");
            }

        }
        up = keys[KeyEvent.VK_W];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        down = keys[KeyEvent.VK_S];
        space = keys[KeyEvent.VK_SPACE];
        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];

    }

    public boolean keyJustPressed(int keyCode) {
        if (keyCode < 0 || keyCode >= keys.length) return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;

        keys[e.getKeyCode()] = false;

    }

}
