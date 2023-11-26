package com.iiitd.stickhero;

import java.util.ArrayList;

public class DataBase{
    private static ArrayList<Player> leaderBoard = new ArrayList<>(); //ArrayList of all players in order of rank
    private GameMain game;

    public static ArrayList<Player> getLeaderBoard() {
        return leaderBoard;
    }

    public static void setLeaderBoard(ArrayList<Player> leaderBoard) {
        DataBase.leaderBoard = leaderBoard;
    }

    public GameMain getGame() {
        return game;
    }

    public void setGame(GameMain game) {
        this.game = game;
    }
}
