package com.jenkins.pong;

import java.awt.Color;
public class Constants {
    /**
     * Using this Constants folder is good practise in case we need to chaneg anything in future
     */
    public final static int SCREEN_WIDTH = 800;
    public final static int SCREEN_HEIGHT = 600;
    public final static String SCREEN_TITLE = "Pong";

    /**
     * Paddle Constants
     */
    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 100;
    public static final Color PADDLE_COLOR = Color.white;
    public static final double HZ_PADDOING = 20;

    public static final double PADDLE_SPEED = 250;

    /**
     * Ball Constants
     */
    public static final double BALL_WIDTH = 10;
    public static final double BALL_HEIGHT = 10;
    public static final Color BALL_COLOR = Color.WHITE;


    //insets
    public static  double TOOL_BAR_HEIGHT;
    public static  double TOOL_BAR_BOTTOM;


}
