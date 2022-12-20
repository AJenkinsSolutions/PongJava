package com.jenkins.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controls our player and Ai
 */
public class PlayerController {

    public Rect rect;
    //Give us access to what the user is pressing
    public KL keyListener;

    public PlayerController(Rect rect, KL keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    public void update(double dt){

        if(keyListener.isKeyPressed(KeyEvent.VK_DOWN)){
            if((rect.y + Constants.PADDLE_SPEED * dt) + rect.height < Constants.SCREEN_HEIGHT - Constants.TOOL_BAR_BOTTOM)
                this.rect.y += (Constants.PADDLE_SPEED * dt);
        } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            if(rect.y - Constants.PADDLE_SPEED * dt > Constants.TOOL_BAR_HEIGHT)
                this.rect.y -= (Constants.PADDLE_SPEED * dt);
        }


    }
}
