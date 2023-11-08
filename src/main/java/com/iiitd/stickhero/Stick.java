package com.iiitd.stickhero;

import javafx.scene.shape.Rectangle;

public class Stick {
    //-----attributes-----\\
    private int stick_size = 0;
    private final int stick_width = 15;
    private Rectangle stick;


    //-----constructor-----\\
    public Stick() {
        stick = new Rectangle();
        stick.setWidth(stick_width);
        stick.setHeight(stick_size);
    }

    //-----methods-----\\


    public Rectangle getStick() {
        return stick;
    }

    public void setStick(Rectangle stick) {
        this.stick = stick;
    }

    public int getStick_width() {
        return stick_width;
    }


    public int getStick_size() {
        return stick_size;
    }

    public void setStick_size(int stick_size) {
        this.stick_size = stick_size;
    }
}
