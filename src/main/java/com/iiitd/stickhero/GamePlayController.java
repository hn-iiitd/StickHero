package com.iiitd.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

public class GamePlayController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    private Parent root;
    @FXML
    private Rectangle stick;
    @FXML
    private ImageView player;
    private Timeline stick_inc;
    private boolean stick_made=false;
    @FXML
    private Rectangle p1;
    @FXML
    private Rectangle p2;
    private boolean player_moved=false;
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleMousePressed(MouseEvent event) {
        if (!stick_made){
        if (event.isPrimaryButtonDown()) {
//            stick.setHeight(0);
            player.setX(p1.getWidth()-35);
            stick.setWidth(2);
            stick_inc=new Timeline();

            double newHeight = stick.getHeight() + 200;
            double newY = stick.getY() - 200;

            stick.setY(newY);
            stick.setHeight(newHeight);
            stick.getParent().requestLayout();
            stick_made=true;

        }}
        else{
            System.out.println("yoyo");
        }

    }
//    public void handleMouseReleased(MouseEvent e) {
//        if (stick_made){
//        stick.setWidth(stick.getHeight());
//        double h = stick.getHeight();
//        stick.setHeight(2);
//        stick.setY(0);
////        System.out.println("old" + stick.getParent().getTranslateY());
//        Timeline timeline = new Timeline();
//        double startLayerY = stick.getParent().getTranslateY();
//        double endLayerY = 0;
//        int animationDuration = 1000;
//
//        KeyFrame keyFrame = new KeyFrame(
//                Duration.millis(animationDuration),
//                new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        double progress = timeline.getCurrentTime().toMillis() / animationDuration;
//                        double newTranslateY = startLayerY + (endLayerY - startLayerY) * progress;
//                        stick.getParent().setTranslateY(newTranslateY);
//
//                        double newPlayerX = player.getX() + stick.getWidth() * progress;
//                        player.setX(newPlayerX);
//                        stick.getParent().requestLayout();
//                        player_moved=true;
//                    }
//                });
//        timeline.getKeyFrames().add(keyFrame);
//
//        timeline.play();
//
//        stick_made=false;
//
////            timeline.stop();
//
//    }
//        if (player_moved){
//            platform_gen();
//            player_moved=false;
//        }
//       }
    public void handleMouseReleased(MouseEvent e){
//        player.setX(p1.getWidth()-35);

        stick.setWidth(stick.getHeight());
        double h = stick.getHeight();
        stick.setHeight(2);
        stick.setY(0);
//        player.setX(p1.getWidth()-35);
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(player);
        transition.setDuration(Duration.millis(1000));
//        transition.setFromX(p1.getWidth());
        transition.setByX(stick.getWidth());

        System.out.println(player.getX());
        transition.setOnFinished(event -> {
            platform_gen();
            // You can perform additional actions here after the transition is complete
        });
        transition.play();
//        player.setX(p1.getX() + p1.getWidth()) ;
//        platform_gen();

    }
    public void platform_gen(){
        double a = Math.random() * (150 - 37 + 1) + 37;
        p1.setWidth(p2.getWidth());
        p2.setWidth(a);
        double playerEdgeX = p1.getX() + p1.getWidth(); // Calculate the right edge of p1
        player.setX(0);
        player.setTranslateX(p1.getWidth()-35);
//        player.setX(playerEdgeX);
        stick.setLayoutX(0);
        stick.setTranslateX(playerEdgeX);
        System.out.println(p1.getWidth());
        player.getParent().requestLayout();
        stick_made=false;
    }

//    @FXML
//    public void handleMouseReleased(MouseEvent e){
//        stick.setWidth(stick.getHeight());
//        double h=stick.getHeight();
//        System.out.println("old"+stick.getY());
//        stick.setHeight(2);
//        stick.setY(0);
//        player.setX(player.getX()+stick.getWidth());
//        System.out.println("new"+stick.getY());
//        System.out.println(stick.getHeight());
//        stick.getParent().requestLayout();
//////        stick.
//    }
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
