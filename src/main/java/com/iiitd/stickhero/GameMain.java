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

//    private Player p1;
//    public static void startGame(Player p1){
//        setP1(p1);
//
//    }
//    public static void serialize() throws IOException {
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
//    }
//    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException {
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
//    }
//    public static void endGame(){
//
//    }
//    public static void revive(){
//
//    }
//
//    public Player getP1() {
//        return p1;
//    }
//
//    public static void setP1(Player p1) {
//    }
//
//    public static void generateNew_stick(){
//
//    }
//    public static void calculateDistance(){
//
//    }
//    public static void showRedCherry(int posi){
//        RewardCherries c1 = new RedCherry();
//        c1.show_component(posi);
//    } public static void showBlueCherry(int posi){
//        RewardCherries c1 = new BlueCherry();
//        c1.show_component(posi);
//    }
//    public static void genStick(){
//
//    }
//    public static void stopStick_Gen(){
//
//    }
}
