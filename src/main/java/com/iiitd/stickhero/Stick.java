package com.iiitd.stickhero;

public class Stick {
    //-----attributes-----\\
    private int stick_size = 0;
    private final int stick_width = 2;

    //-----constructor-----\\
    public Stick() {

    }

    //-----methods-----\\

    public int getStick_width() {
        return stick_width;
    }


    public void resetStick(){
        stick_size = 0;
    }

    public int getStick_size() {
        return stick_size;
    }

    public void setStick_size(int stick_size) {
        this.stick_size = stick_size;
    }
}
