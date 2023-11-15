package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class GamePlayController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    private Parent root;
    @FXML
    private Rectangle stick;

    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void increase_length(){
        scene.setOnKeyPressed(e->{
            if (e.getCode()== KeyCode.SPACE){
                stick.setHeight(stick.getHeight()+10);
            }
        });
    }

//    scene.setOnKeyPressed(e->)
}
