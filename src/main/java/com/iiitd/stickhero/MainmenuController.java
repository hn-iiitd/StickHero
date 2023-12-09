package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainmenuController implements Initializable
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Circle circle;
    private MediaPlayer mediaPlayer;

    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOption(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        root = FXMLLoader.load(getClass().getResource("Option.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAfterPLay(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        root = FXMLLoader.load(getClass().getResource("AfterPLAYClicking.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void switchToNewGame(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    public void switchtoContinue(ActionEvent event) throws IOException {
        mediaPlayer.stop();
        root = FXMLLoader.load(getClass().getResource("ContinueGameMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToCharacter(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        root = FXMLLoader.load(getClass().getResource("ChangeChar.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String audioFile = "src/main/resources/main_menu.mp3"; // Replace with the actual path to your audio file
        Media sound = new Media(new File(audioFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void switchToLeaderboard(MouseEvent event) throws IOException{
        mediaPlayer.stop();
        root = FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}