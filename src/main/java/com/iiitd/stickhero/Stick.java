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
        setStick(stick);
    }

    //-----methods-----\\


    public Rectangle getStick() {
        return stick;
    }

    public void setStick(Rectangle stick) {
        this.stick = stick;
    }




    public double getStick_size() {
        return this.stick.getHeight(); //confirm if getY or getHeight
    }

    public void setStick_size(double stick_size) {
        this.stick.setHeight(stick_size);
    }
}
