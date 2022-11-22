package com.jenkins.pong;

public class MainDriver {
    public static void main(String[] args){
        Window window = new Window();
        Thread t1 = new Thread(window);
        t1.start();
    }
}
