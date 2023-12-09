package com.iiitd.stickhero;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

//----------------------------------//
//Design Pattern Used -SINGLETON//
//---------------------------------//


public class Char1 extends Character{
    private static Char1 char1=null;
    public static Char1 getInstance()
    {
        if (char1 == null) {
            char1 = new Char1();
        }
        return char1;
    }

    private Char1() {}

    private static int type;

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Char1.type = type;
    }
}
