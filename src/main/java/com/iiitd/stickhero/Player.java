package com.iiitd.stickhero;

public class Player{
    private String name;

    public Player(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    private String userId;
    private String password;

    private int player_currentScore = 0;
    private int player_highestScore = 0 ;

    private int number_of_lives = 0;

    public int getNumber_of_lives() {
        return number_of_lives;
    }

    public void setNumber_of_lives(int number_of_lives) {
        this.number_of_lives = number_of_lives;
    }

    public int getPlayer_currentScore() {
        return player_currentScore;
    }

    public void setPlayer_currentScore(int player_currentScore) {
        this.player_currentScore = player_currentScore;
    }

    public int getPlayer_highestScore() {
        return player_highestScore;
    }

    public void setPlayer_highestScore(int player_highestScore) {
        this.player_highestScore = player_highestScore;
    }


}
