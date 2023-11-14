package com.iiitd.stickhero;
public abstract class Character extends GameMain {
    private boolean hero_flip = false; //if flipping is possible
    private boolean isHero_up = true; //if hero up or down

    public static void flip_character(){

    }

    public boolean isHero_flip() {
        return hero_flip;
    }

    public void setHero_flip(boolean hero_flip) {
        this.hero_flip = hero_flip;
    }

    public boolean isHero_up() {
        return isHero_up;
    }

    public void setHero_up(boolean hero_up) {
        isHero_up = hero_up;
    }
}
