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

public class MainmenuController
{
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Circle circle;

    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOption(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Option.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToAfterPLay(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AfterPLAYClicking.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

//        System.out.println("Switching to new game!");
    }
    @FXML
    public void switchToNewGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}
    public void switchtoContinue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ContinueGameMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}