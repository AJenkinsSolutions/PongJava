package com.jenkins.pong;
import java.awt.*;
import java.awt.Color;
public class Rect {
    private int x, y,width, height;
    private Color color;

    public Rect(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Draws rectangle to screen
     * @param g2
     */
    public void draw(Graphics2D g2){
        g2.setColor(this.color);
        g2.fillRect(this.x, this.y, this.width, this.height);

    }

}
