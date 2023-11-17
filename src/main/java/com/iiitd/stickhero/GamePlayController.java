package com.iiitd.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private ImageView img;

    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

        @FXML
    public void handleMousePressed(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
//            stick.setHeight(0);
            stick.setWidth(2);
            double newHeight = stick.getHeight() + 100;
            double newY = stick.getY() - 100;
            System.out.println(stick.getY());
            stick.setY(newY);
            stick.setHeight(newHeight);
            stick.getParent().requestLayout();

        }
    }
    @FXML
    public void handleMouseReleased(MouseEvent e){
//        stick.setWidth(stick.getHeight());
//        stick.setHeight(2);
//        stick.setLayoutY(600-81.5);
//        System.out.println(stick.getHeight());
//        stick.getParent().requestLayout();
////        stick.
    }
//    public void handleMousePressed(MouseEvent event) {
//        if (event.isPrimaryButtonDown()) {
//            // Create a timeline and add a keyframe for the height of the stick
//            Timeline timeline = Timeline.create();
//            timeline.getKeyFrames().add(
//                    new KeyFrame(0, stick.getHeight(), 500, stick.getHeight() + 100));
//
//            // Start the timeline when the mouse button is pressed
//            timeline.play();
//        }
//    }
//
//    public void handleMouseReleased(MouseEvent event) {
//        // Stop the timeline when the mouse button is released
//        timeline.stop();
//    }
}
