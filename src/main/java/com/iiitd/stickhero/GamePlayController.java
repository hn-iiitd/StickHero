package com.iiitd.stickhero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
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
    private boolean stick_made = false;
    @FXML
    private Rectangle p1;
    @FXML
    private Rectangle p2;
    Timeline timeline;
    Timeline rotation;


    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleMousePressed(MouseEvent event1) {
        if (!stick_made) {
            if (event1.isPrimaryButtonDown()) {
                stick.setHeight(0);
                stick.setWidth(3);
                player.setLayoutX(p2.getWidth()+player.getFitWidth());
                timeline = new Timeline(new KeyFrame(
                        Duration.millis(10), event -> increaseStickHeight()));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();

//                stick.setWidth(2);
//                stick_inc = new Timeline();

//                double newHeight = stick.getHeight() + ((double) (System.currentTimeMillis() - time_initial) /10);
//                stick.setHeight(newHeight);
                stick_made = true;
            }
        } else {
            System.out.println("yoyo");
        }

    }

    private void increaseStickHeight() {
        stick.setHeight(stick.getHeight() + 3);
    }

    public void handleMouseReleased(MouseEvent e) {
        timeline.stop();
        double pivot_x = stick.getX();
        double pivot_y = stick.getY();
        Rotate rotate = new Rotate(0,pivot_x,pivot_y);
        stick.getTransforms().add(rotate);
        rotation = new Timeline(
                new KeyFrame(Duration.millis(100),new KeyValue(rotate.angleProperty(),90))
                );
        rotation.setOnFinished(event ->
        {
            double stick_height = stick.getHeight();
//        stick.setWidth(stick_height);
//        stick.setHeight(2);
            System.out.println(p2.getLayoutX() + " + " + stick.getLayoutX());

            TranslateTransition transition = new TranslateTransition();
            transition.setNode(player);
            transition.setDuration(Duration.millis(1000));
            transition.setToX(stick_height);
            stick.setWidth(3);
            System.out.println(player.getX());
            transition.setOnFinished(event2 -> {
                if (stick_height > (p2.getLayoutX() - stick.getLayoutX()) && stick_height > (p2.getLayoutX() - stick.getLayoutX())) {
                    platform_gen();
                    stick.setY(player.getY()+player.getFitHeight());
                    stick.setX(player.getX()-player.getFitWidth());
                    stick.setHeight(0);
                    stick.setWidth(3);
                    rotate.setAngle(0);
                } else {
                    player_fall();
                }
            });
            transition.play();
        });
        rotation.play();
//        stick.setY(0);


    }


    //    public void platform_gen() {
//        double a = Math.random() * (150 - 37 + 1) + 37;
//
//
//        TranslateTransition transition2 = new TranslateTransition();
//        TranslateTransition transition3 = new TranslateTransition();
//
//        transition2.setNode(p2);
//        transition2.setDuration(Duration.millis(1000));
//        transition3.setNode(p1);
//        transition3.setDuration(Duration.millis(1000));
//
//        p2.setTranslateX(p2.getLayoutX());
//        p2.setLayoutX(0);
//        p1.setTranslateX(0);
////        p1.setLayoutX();
////    p1.setWidth(0);
//        transition2.setToX(0);
//        transition3.setToX(-p1.getWidth());
////        p1.setLayoutX(0);
//        transition2.setOnFinished(event -> {
//            p1.setWidth(p2.getWidth());
//            p1.setLayoutX(0);
//            p1.setTranslateX(0);
//            p2.setWidth(a);
////            p2.setLayoutX(p1.getWidth());
//            double gap = Math.random() * (250 - 40 + 1) + 40;
//            p2.setLayoutX(gap + p1.getWidth());
//            double playerEdgeX = p1.getX() + p1.getWidth();
//            player.setX(0);
//            player.setTranslateX(p1.getWidth() - 35);
////        player.setX(playerEdgeX);
//            stick.setLayoutX(0);
//            stick.setTranslateX(playerEdgeX);
//            System.out.println(p1.getWidth());
//            player.getParent().requestLayout();
//            stick_made = false;
//
//            // You can perform additional actions here after the transition is complete
//        });
////        transition3.setOnFinished(event -> {
////
////        });
//        transition2.play();
//        transition3.play();
//    }
    public void player_fall() {
//        stick.setHeight(stick.getWidth());

//        stick.setY(stick.getY()+stick.getHeight());
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000), player);
        transition.setToY(player.getTranslateY() + p1.getHeight());

        transition.setOnFinished(event -> {
            try {
                game_over();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        transition.play();

    }

    public void game_over() throws IOException {
        root = FXMLLoader.load(getClass().getResource("game_over.fxml"));
        stage = (Stage) player.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void platform_gen() {

        double a = Math.random() * (150 - 37 + 1) + 37;
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(1000), p2);
        p2.setTranslateX(p2.getLayoutX());
        p2.setLayoutX(0);
        transition2.setToX(0);
        transition2.setOnFinished(event -> {
            p1.setWidth(p2.getWidth());
            p1.setLayoutX(0);
            p1.setTranslateX(0);
            p2.setWidth(a);
            double gap = Math.random() * (250 - 40 + 1) + 40;
            p2.setLayoutX(gap + p1.getWidth());
            double playerEdgeX = p1.getX() + p1.getWidth();
            player.setX(0);
            player.setTranslateX(playerEdgeX - 35);
            stick.setLayoutX(0);
            stick.setTranslateX(playerEdgeX);
            player.getParent().requestLayout();

            stick_made = false;
        });
        transition2.play();
    }


    // After the first transition, move the platform back
//        transition2.setOnFinished(event -> movePlatformBack());
//        p2.setWidth(a);
//        p2.setLayoutX(p1.getWidth());
//        double gap=Math.random()*(280-40+1)+40;
//        p2.setX(gap);
//        double playerEdgeX = p1.getX() + p1.getWidth();
//        player.setX(0);
//        player.setTranslateX(p1.getWidth()-35);
////        player.setX(playerEdgeX);
//        stick.setLayoutX(0);
//        stick.setTranslateX(playerEdgeX);
//        System.out.println(p1.getWidth());
//        player.getParent().requestLayout();
//        stick_made=false;


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
