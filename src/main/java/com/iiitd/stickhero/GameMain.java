package com.iiitd.stickhero;

import java.io.*;

public class GameMain implements Serializable {

    private Player p1;
    public void startGame(Player p1){
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

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public static void generateNew_stick(){

    }
    public static void calculateDistance(){

    }
    public static void showRedCherry(int posi){
        RewardCherries c1 = new RedCherry();
        c1.show_cherry(posi);
    } public static void showBlueCherry(int posi){
        RewardCherries c1 = new BlueCherry();
        c1.show_cherry(posi);
    }
    public static void genStick(){

    }
    public static void stopStick_Gen(){

    }
}
