package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {
    @FXML
    private Label final_score;
    private String username=StickHero.user.getUsername();
    private int RedCherryCount;
    private int BlueCherryCount;
    private int score;
    private Stage stage;
    @FXML
    private Label highScore;


    @FXML
    private Scene scene;
    private Parent root;
    public void set_data(int red, int blue, int score, int best){
        this.BlueCherryCount=blue;
        this.RedCherryCount=red;
        this.score=score;
        final_score.setText(String.valueOf(score));
        highScore.setText(String.valueOf(best));
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
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLeader(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
