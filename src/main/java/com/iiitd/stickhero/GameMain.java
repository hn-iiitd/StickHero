package com.iiitd.stickhero;

import java.io.*;

public class GameMain implements Serializable {
    private static Player p1;
    public static void startGame(Player p1){
        setP1(p1);

    }
    public static void serialize() throws IOException {
//        ObjectOutputStream out=null;
//        try {
//            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
//            out.writeObject(currentd);
//        }
//        finally {
//            out.close();
//            System.out.println("Saved!");
//            System.exit(0);
//        }
    }
    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException {
//        ObjectInputStream in = null;
//        try {
//            in=new ObjectInputStream (new FileInputStream("database.txt"));
//            currentd=(Database) in.readObject();
//            in.close();
//        }
//        catch (FileNotFoundException e){
//            currentd=new Database();
//        }
//        catch (NullPointerException e) {
//            currentd=new Database();
//            //System.out
    }
    public static void endGame(){

    }
    public static void revive(){

    }

    public static Player getP1() {
        return p1;
    }

    public static void setP1(Player p1) {
        GameMain.p1 = p1;
    }
}
