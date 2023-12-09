package com.iiitd.stickhero;

import javafx.scene.Group;


//----------------------------------//
//Design Pattern Used -SINGLETON//
//---------------------------------//


public class Char2 extends Character{
    private static Char2 char2=null;
    public static Char2 getInstance()
    {
        if (char2 == null) {
            char2 = new Char2();
        }
        return char2;
    }

    private Char2() {}

    private static int type;

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Char2.type = type;
    }
}
