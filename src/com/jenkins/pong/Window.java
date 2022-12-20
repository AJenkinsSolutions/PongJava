package com.jenkins.pong;

import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame implements Runnable{

    /**
     * Declaring the Graphics object
     */
    public Graphics2D g2;
    /**
     * Key listen object
     */
    public KL keyListener = new KL();
    //Declare our players
    public Rect playerOne, ai, ball;

    public PlayerController playerController;


    public Window(){
        /**
         * Window configuration
         */
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ability to close window
        this.setTitle(Constants.SCREEN_TITLE);

        /**
         * Getting and Casting the graphics object to g2
         */
        g2 = (Graphics2D)this.getGraphics(); // returns graphics obj

        /**
         * Register key listene to our window object
         */
        this.addKeyListener(keyListener);
        Constants.TOOL_BAR_HEIGHT = this.getInsets().top;
        Constants.TOOL_BAR_BOTTOM = this.getInsets().bottom;


        //Initialize player objects
        playerOne = new Rect(Constants.HZ_PADDOING,40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        playerController = new PlayerController(playerOne, keyListener);


        ai = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDOING, 40, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Constants.PADDLE_COLOR);
        ball = new Rect(Constants.SCREEN_WIDTH /2, Constants.SCREEN_HEIGHT /2, Constants.BALL_WIDTH, Constants.BALL_HEIGHT, Constants.BALL_COLOR);



    }

    public void update(double dt) {

        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();

        this.draw(dbg);
        g2.drawImage(dbImage, 0,0, this);



        playerController.update(dt);



        /**
         * Listen to the user input
         */
//        if(keyListener.isKeyPressed(KeyEvent.VK_UP)){
//            System.out.println("The user is press the up arrow" + KeyEvent.VK_UP);
//        }else if(keyListener.isKeyPressed(KeyEvent.VK_DOWN)){
//            System.out.println("The user is press the down arrow" + KeyEvent.VK_DOWN);
//        }



        /**
         * Display our Current frames per second (FPS) to the screen
         */
//        System.out.println("" + dt + " seconds passed since the last frame" );
        System.out.println(1 / dt + " fps");

    }

    /**
     * drawing everything off screen
     * swapping the buffer for a smoother image
     * @param g
     */
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        /**
         * We Set the area in which we want our background color to fill
         * Set the background color using the g2 object
         */
        g2.setColor(Color.black);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        //Pass graphic object to draw object
        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);
    }
    public void run() {
        /**
         * Time the last frame was displayed
         */
        double lastFrameTime = 0.0;


        while (true){
            /**
             *Delta time is the difference(Delta) between the last frame
             */
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;

            /**
             * Uodate lastTime with current time for accuracy
             */
            lastFrameTime = time;
            /**
             * We need to call our update method
             * It contains the elements such as the drawings that allows us to see the screen every frame
             */
            update(deltaTime);

            /**
             * This try catch will give use the ability to cap Fps at 30
             * To avoid overloading the system
             */
            try{
                Thread.sleep(30);
            }catch (Exception e){

            }

        }
    }
}
