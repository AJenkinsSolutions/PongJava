package com.jenkins.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Key Listener Class
 * This class will handle user input
 * @role Tell us if the user has hit a key
 * @role Ask if the user has inputted a certain key
 * Implements from the Java.awt.event.keulisterner libary
 */
public class KL implements KeyListener {


    /**
     * Array of 128 characters pull directly from ascii 128 charcter code
     */
    private  boolean[]  keyPressed = new boolean[128];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * When a key pressed this function will get called
     * This function is inheritanly part of the window
     * When a user presses a key it will call this fucnton for us
     * @param event the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent event) {
        keyPressed[event.getKeyCode()] = true;
    }

    /**
     * If the key is released set keypress to false
     * @param event the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent event) {
        keyPressed[event.getKeyCode()] = false;
    }


    /*
        helper functions i can use
     */

    /**
     * We can call this function to tell us if a key was pressed
     * public access it can be called from anywhere
     * @param keycode
     * @return
     */
    public boolean isKeyPressed(int keycode){
        return keyPressed[keycode];
    }
}
