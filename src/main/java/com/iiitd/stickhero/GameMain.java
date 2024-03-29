package com.iiitd.stickhero;

import java.io.*;

public class GameMain implements Serializable {
    private int blue_cherries;
    private int red_cherries;
    private int current_score;

    public int getBlue_cherries() {
        return blue_cherries;
    }

    public void setBlue_cherries(int blue_cherries) {
        this.blue_cherries = blue_cherries;
    }

    public int getRed_cherries() {
        return red_cherries;
    }

    public void setRed_cherries(int red_cherries) {
        this.red_cherries = red_cherries;
    }

    public int getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(int current_score) {
        this.current_score = current_score;
    }

    private float platform1_width;
    private float platform2_width;

    public float getPlatform1_width() {
        return platform1_width;
    }

    public void setPlatform1_width(float platform1_width) {
        this.platform1_width = platform1_width;
    }

    public float getPlatform2_width() {
        return platform2_width;
    }

    public void setPlatform2_width(float platform2_width) {
        this.platform2_width = platform2_width;
    }

    public float getPlatforms_gap() {
        return platforms_gap;
    }

    public void setPlatforms_gap(float platforms_gap) {
        this.platforms_gap = platforms_gap;
    }

    private float platforms_gap;

}