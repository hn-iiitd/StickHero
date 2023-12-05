package com.iiitd.stickhero;

import java.io.*;
import java.util.ArrayList;

public class DataBase{
    private static ArrayList<Player> playerList = new ArrayList<>();

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public static void setPlayerList(ArrayList<Player> playerList) {
        DataBase.playerList = playerList;
    }
    public static void serialize(ArrayList<Player> p1) throws IOException {
        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("src/database.txt"));
            out.writeObject(p1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
            System.out.println("player Data Saved");
        }
    }
    public static ArrayList<Player> deserialize() throws ClassNotFoundException, IOException {
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("src/database.txt"));
            return (ArrayList<Player>) in.readObject();
        }
        catch (FileNotFoundException | NullPointerException ignored){
            return null;
        }
    }

    }

