package com.iiitd.stickhero;

import java.util.ArrayList;

public class DataBase{
    private static ArrayList<Player> playerList = new ArrayList<>();



    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public static void setPlayerList(ArrayList<Player> playerList) {
        DataBase.playerList = playerList;
    }
}
