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

public class ReviveController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int RedCherryCount;
    private int BlueCherryCount;
    private int score;
    @FXML
    private Label error;

    public void set_data(int red,int blue,int score){
        this.BlueCherryCount=blue;
        this.RedCherryCount=red;
        this.score=score;
//        final_score.setText(String.valueOf(score));
    }

    @FXML
    public void switchToNewGame(ActionEvent event) throws IOException {
        if (BlueCherryCount >= 3) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewGame.fxml"));
            Parent root = loader.load();
            GamePlayController revive = loader.getController();
            revive.setdata(RedCherryCount, BlueCherryCount-3, score);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else{
            error.setText("NOT ENOUGH BLUE CHERRIES");


        }

    }
    @FXML
    public void switchToGameOver(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_over.fxml"));
        Parent root = loader.load();
        GameOverController revive = loader.getController();
        revive.set_data(RedCherryCount, BlueCherryCount, score);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }}
