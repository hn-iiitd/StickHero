package com.iiitd.stickhero;
import javafx.fxml.FXML;
import org.junit.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StickHeroTest{


    @Test( )
    public void Test2() throws IOException, ClassNotFoundException {
        ArrayList<Player> ap = (ArrayList<Player>)DataBase.deserialize();
        for (Player p : ap){
            DataBase.getPlayerHashMap().put(p.getUserId(),p);
        }
        Player ad = Player.createNewPlayer("admin","admin","");
        assertNull(ad);
    }
    @Test
    public void Test1(){
        Player ad = Player.createNewPlayer("admin","admin","");
        ad.setPlayer_highestScore(4);
        Player p2 = Player.createNewPlayer("Harsh1","h2","dadad");
        p2.setPlayer_highestScore(1);
        Player p3 = Player.createNewPlayer("Harsh2","h3","dadad");
        p3.setPlayer_highestScore(2);
        ArrayList<Player> expected = new ArrayList<>();
        ArrayList<Player> final_ = new ArrayList<>();
        final_.add(p2);
        final_.add(p3);
        final_.add(ad);
        expected.add(ad);
        expected.add(p2);
        expected.add(p3);
        Collections.sort(expected, new PlayerComparator());
        assertEquals(expected,final_);


    }
}
