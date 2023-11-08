package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Stick stick = new Stick();
    @FXML
    Rectangle stick1 = stick.getStick();
    private double x;
    private double y;
    @FXML
    public void keycode(KeyEvent e){
        if(e.getCode()== KeyCode.UP){
            stick1.setHeight(stick1.getHeight()+10);
        }
        else if(e.getCode()== KeyCode.DOWN){
            stick1.setHeight(stick1.getHeight()-10);
        }
        else{
            stick1.setWidth(stick1.getWidth()+1);
        }
    }

    @FXML

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main-view2.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}