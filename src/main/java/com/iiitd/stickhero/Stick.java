package com.iiitd.stickhero;

import javafx.scene.shape.Rectangle;

public class Stick implements GameComponents{
    //-----attributes-----\\
    private int stick_size = 0;
    private final int stick_width = 2;
    private Rectangle stick;
    private double posi;


    //-----constructor-----\\
    public Stick(Rectangle stick) {
        this.stick=stick;
//        stick.setWidth(stick_width);
//        stick.setHeight(stick_size);
//        setStick(stick);
    }

    //-----methods-----\\


    public Rectangle getStick() {
        return stick;
    }

    private void setStick(Rectangle stick) {
        this.stick = stick;
    }




    public double getStick_size() {
        return this.stick.getHeight(); //confirm if getY or getHeight
    }

    public void setStick_size(double stick_size) {
        this.stick.setHeight(stick_size);
    }



    @Override
    public void setPosi(double posi) {

    }

    @Override
    public double getPosi() {
        return 0;
    }
}
