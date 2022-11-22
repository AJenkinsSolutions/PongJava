package com.jenkins.pong;

import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
public class Window extends JFrame implements Runnable{

    Graphics2D g2;

    public Window(){
        /**
         * Window configuration
         */
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ability to close window
        this.setTitle(Constants.SCREEN_TITLE);

        g2 = (Graphics2D)this.getGraphics(); // returns graphics obj
    }

    public void update(double dt) {
        //Drawing screen background
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

//        System.out.println("" + dt + " seconds passed since the last frame" );
        System.out.println(1 / dt + " fps");

    }
    public void run() {
        double lastFrameTime = 0.0;
        while (true){
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);
            //Capping FPS
            try{
                Thread.sleep(30);
            }catch (Exception e){

            }

        }
    }
}
