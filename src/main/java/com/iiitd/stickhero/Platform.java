package com.iiitd.stickhero;

public class Platform {
    private int platform_height;
    private int platform_width;

    public void setPlatform_height(int platform_height) {
        this.platform_height = platform_height;
    }

    public Platform(int platform_height, int platform_width) {
        this.platform_height = platform_height;
        this.platform_width = platform_width;
    }

    public int getPlatform_width() {
        return platform_width;
    }

    public void setPlatform_width(int platform_width) {
        this.platform_width = platform_width;
    }

    public int getPlatform_height() {
        return platform_height;
    }
}
