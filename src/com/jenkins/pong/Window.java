package com.jenkins.pong;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable{

    public Window(){
        /**
         * Window configuration
         */
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ability to close window
        this.setTitle(Constants.SCREEN_TITLE);
    }
    public void run() {
        while (true){

        }
    }
}
