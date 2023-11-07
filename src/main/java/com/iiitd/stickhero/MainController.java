package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;
    @FXML
    public void up(ActionEvent e){
        myCircle.setCenterY(y-=10);
    }
    @FXML
    public void down(ActionEvent e){
        myCircle.setCenterY(y+=10);
    }
    @FXML
    public void left(ActionEvent e){
        myCircle.setCenterX(x-=10);
    }
    @FXML
    public void right(ActionEvent e){
        myCircle.setCenterX(x+=10);
    }
    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main-view2.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}