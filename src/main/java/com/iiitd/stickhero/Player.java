package com.iiitd.stickhero;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 3863198867581910777L;
    private GameMain game = null;
    private String name;

    private int character_img=1;

    public int getCharacter_img() {
        return character_img;
    }

    public void setCharacter_img(int character_img) {
        this.character_img = character_img;
    }

    public Player(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }
    private int red_cherry;

    public int getBlue_cherry() {
        return blue_cherry;
    }

    public void setBlue_cherry(int blue_cherry) {
        this.blue_cherry = blue_cherry;
    }

    private int blue_cherry;
    private int curr_score;

    public int getCurr_score() {
        return curr_score;
    }

    public void setCurr_score(int curr_score) {
        this.curr_score = curr_score;
    }

    public int getRed_cherry() {
        return red_cherry;
    }

    public void setRed_cherry(int red_cherry) {
        this.red_cherry = red_cherry;
    }

    private String userId;
    private String password;

    public GameMain getGame() {
        return game;
    }

    public void setGame(GameMain game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    private int player_currentScore = 0;
    private int player_highestScore = 0 ;

    private int number_of_lives = 0;

    public int getNumber_of_lives() {
        return number_of_lives;
    }

    public void setNumber_of_lives(int number_of_lives) {
        this.number_of_lives = number_of_lives;
    }

//    public int getPlayer_currentScore() {
//        return player_currentScore;
//    }

//    public void setPlayer_currentScore(int player_currentScore) {
//        this.player_currentScore = player_currentScore;
//    }

    public int getPlayer_highestScore() {
        return player_highestScore;
    }

    public void setPlayer_highestScore(int player_highestScore) {
        this.player_highestScore = player_highestScore;
    }


}
