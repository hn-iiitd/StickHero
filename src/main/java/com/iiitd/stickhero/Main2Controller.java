package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;

import javafx.stage.Stage;


import java.io.IOException;

public class Main2Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;


    private Group root2;

    private Circle head;
    private Circle leftEye;
    private Circle rightEye;

    private Arc mouth;

    private Rectangle torso;
    private Line leftArm;
    private Line rightArm;
    private Line leftLeg;

    private Line rightLeg;

    public void moveLeft() {
        root2.setLayoutX(root2.getLayoutX() - 10);
    }

    public void moveRight() {
        root2.setLayoutX(root2.getLayoutX() + 10);
    }

    public void moveUp() {
        root2.setLayoutY(root2.getLayoutY() - 10);
    }

    public void moveDown() {
        root2.setLayoutY(root2.getLayoutY() + 10);
    }

    public void switchToScene1(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
