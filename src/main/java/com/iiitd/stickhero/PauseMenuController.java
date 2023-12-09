package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class PauseMenuController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Circle circle;
    private String username=StickHero.user.getUsername();
    private int RedCherryCount;
    private int BlueCherryCount;
    private int score;


    public void set_data(int red,int blue,int score){
        this.BlueCherryCount=blue;
        this.RedCherryCount=red;
        this.score=score;
    }
    public void storing_values() throws IOException {
        try {
            DataBase.setPlayerList(DataBase.deserialize());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Player p : DataBase.getPlayerList()){
            if(p.getUserId().equals(username)){
//                return true;

                p.setRed_cherry(RedCherryCount);
                p.setBlue_cherry(BlueCherryCount);
                p.setCurr_score(score);
                System.out.println("new");

                if (p.getPlayer_highestScore()<score){
                    p.setPlayer_highestScore(score);
                }
                DataBase.serialize(DataBase.getPlayerList());
                System.out.println("Progress saved");
            }
        }

    }

    public void saveAndExit(ActionEvent event) throws IOException {
        storing_values();
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exit(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
