package com.iiitd.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class StickHero extends Application {

    private static ArrayList<Player> leaderBoard = new ArrayList<>(); //ArrayList of all players in order of rank

    //player_selects_character --create method

    @Override

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //----to_add_css-----
//        String css = this.getClass().getResource("Style.css").toExternalForm();
//        scene.getStylesheets().add(css);
        //----------------------------


        stage.setTitle("StickHero");
        Image icon = new Image("unnamed.png");

        stage.getIcons().add(icon);
        stage.setHeight(600);
        stage.setWidth(463);
//        stage.setResizable(false);

        stage.setScene(scene);

        stage.setResizable(false);
//        stage.sets;
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}
class DataBase{

    private GameMain game;

    public GameMain getGame() {
        return game;
    }

    public void setGame(GameMain game) {
        this.game = game;
    }
}