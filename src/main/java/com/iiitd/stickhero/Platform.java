package com.iiitd.stickhero;

import javafx.scene.shape.Rectangle;

public class Platform implements GameComponents {
    private Rectangle r1;
    //implement platform design
    private int platform_width;


    public Platform( int platform_width) {
        this.platform_width = platform_width;
    }

    public int getPlatform_width() {
        return platform_width;
    }

    public void setPlatform_width(int platform_width) {
        this.platform_width = platform_width;
    }


    @Override
    public void setPosi(double posi) {

    }

    @Override
    public double getPosi() {
        return 0;
    }
}
