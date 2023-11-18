package com.iiitd.stickhero;
public abstract class Character extends GameMain {
    private boolean can_hero_flip = false; //if flipping is possible
    private boolean isHero_up = true; //if hero up or down

    public void flip_character(){

    }

    public boolean can_Hero_flip() {
        return can_hero_flip;
    }

    public void set_can_Hero_flip(boolean hero_flip) {
        this.can_hero_flip = hero_flip;
    }

    public boolean isHero_up() {
        return isHero_up;
    }

    public void setHero_up(boolean hero_up) {
        isHero_up = hero_up;
    }
}
