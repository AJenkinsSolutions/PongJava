package com.jenkins.pong;

public class Time {
    /**
     * Time started
     * Using nanoTime is the most accurate way of our getting our systems time
     */
    public static double timeStarted = System.nanoTime();

    /**
     * Current time - time started * 1E-9 will convert the time into seconds
     * @return
     */
    public static double getTime (){
        return (System.nanoTime() - timeStarted) * 1E-9;
    }
}
