package com.iiitd.stickhero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GamePlayController implements Initializable {
    private boolean isManDown = false;

    public boolean Cherries_ON = false;
    private boolean player_walking = false;

    @FXML
    private AnchorPane ap;
    @FXML
    private Label current_score;
    @FXML
    private Stage stage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @FXML
    private Scene scene;
    private Parent root;
    @FXML
    private Rectangle stick;
    private String username=StickHero.user.getUsername();

    private ImageView BlueCherries = new ImageView(new Image(new FileInputStream("src/main/resources/[removal.ai]_91ab9a1d-43f7-43d2-86a4-328342ef7de1-84739960-cherry-vector-line-icon-isolated-on-white-background-cherry-line-icon-for-infographic-website-or-app.png")));

    private ImageView RedCherries = new ImageView(new Image(new FileInputStream("src/main/resources/pngtree-flat-vector-cherries-cartoon-red-cherry-fruit-illustration-isolated-png-image_2506424-removebg-preview.png")));

    @FXML
    private Label RedCherryCount;
    @FXML
    private Label BlueCherryCount;

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
    Timeline rotation2;
    private double current_platform_length;
    private static int currentScore;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollision(RedCherries,player);
            checkCollision(BlueCherries,player);
            try {
                checkCollisionPlat(player,p2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public GamePlayController() throws FileNotFoundException {
    }

    public void setdata(int red,int blue,int score){
        RedCherryCount.setText(String.valueOf(red));
        BlueCherryCount.setText(String.valueOf(blue));
        current_score.setText(String.valueOf(score));

    }
    private void checkCollision(ImageView Cherries, ImageView player) {
        if(ap.getChildren().contains(Cherries) && player.getBoundsInParent().intersects(Cherries.getBoundsInParent())){
//            System.out.println("Collision");
            ap.getChildren().remove(Cherries);
            if(Cherries.equals(RedCherries)){
                RedCherryCount.setText(String.valueOf(Integer.parseInt(RedCherryCount.getText()) +1));
            }
            else if(Cherries.equals(BlueCherries)){
                BlueCherryCount.setText(String.valueOf(Integer.parseInt(BlueCherryCount.getText()) +1));
            }
        }
    }
    private void checkCollisionPlat(ImageView player, Rectangle p2) throws IOException {
        if(player_walking && isManDown && player.getBoundsInParent().intersects(p2.getBoundsInParent())  ){
            try {
//                System.out.println("player collided with platform");
//                player_fall();

                    game_over();
            }
            catch (Exception e){

            }

        }
    }


    public static int getCurrentScore() {
        return currentScore;
    }

    public void cherry_gen() {
        int cherry_gen_posi = new Random().nextInt((int)(p1.getLayoutX()+p1.getWidth()),(int)(p2.getLayoutX()-40));
        int red_chance = new Random().nextInt(0, 2);
        int blue_chance = new Random().nextInt(0, 4);
        if (red_chance == 1) {
            redCherryGen(cherry_gen_posi);}
        else if(blue_chance==1){
            blueCherryGen(cherry_gen_posi);
        }
    }

    public void blueCherryGen(int posi) {
        int pos=new Random().nextInt(0, 2);
        BlueCherries.setFitWidth(32);
        BlueCherries.setFitHeight(32);
        if  (pos==1){
            BlueCherries.setLayoutY(player.getLayoutY());
        }
        else if (pos==0){
            BlueCherries.setLayoutY(player.getLayoutY()+BlueCherries.getFitHeight());
        }
        BlueCherries.setLayoutX(posi);
        BlueCherries.setLayoutY(player.getLayoutY());
        ap.getChildren().add(BlueCherries);
    }

    public void redCherryGen(int posi) {
        int pos=new Random().nextInt(0, 2);
        RedCherries.setFitWidth(32);
        RedCherries.setFitHeight(32);
        RedCherries.setLayoutX(posi);
        if  (pos==1){
            RedCherries.setLayoutY(player.getLayoutY());
        }
        else if (pos==0){
            RedCherries.setLayoutY(player.getLayoutY()+RedCherries.getFitHeight());
        }
//        RedCherries.setLayoutY(player.getLayoutY());
        ap.getChildren().add(RedCherries);

    }




    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void switchToPause(MouseEvent event) throws IOException {
//        FXMLLoader loader=FXMLLoader.load(getClass().getResource("pause.fxml"));
//        root=loader.load();
//        PauseMenuController pause_menu=new PauseMenuController();
//        pause_menu.set_data(Integer.parseInt(RedCherryCount.getText()),Integer.parseInt(BlueCherryCount.getText()),Integer.parseInt(current_score.getText()));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
public void switchToPause(MouseEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("pause.fxml"));
    Parent root = loader.load();
    System.out.println(RedCherryCount.getText());
    // Access the controller of the loaded FXML
    PauseMenuController pause_menu = loader.getController();
    pause_menu.set_data(Integer.parseInt(RedCherryCount.getText()),
            Integer.parseInt(BlueCherryCount.getText()),
            Integer.parseInt(current_score.getText()));

    // Assuming 'root' is a Parent or Region, set it as the root of the scene
    Scene scene = new Scene(root);

    // Access the stage from the event's source
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    @FXML
    public void handleMousePressed(MouseEvent event1) {
        System.out.println(StickHero.user.getUsername());
        stick.getParent().requestFocus();
        if (!stick_made && !player_walking) {
            if (event1.isPrimaryButtonDown()) {
                stick.setHeight(0);
                stick.setWidth(3);
//                stick.setTranslateX(0);
//                player.setTranslateX(0);
//                player.setLayoutX(p1.getWidth()-player.getFitWidth());
                timeline = new Timeline(new KeyFrame(
                        Duration.millis(10), event -> increaseStickHeight()));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                stick_made = true;
            }
        } else if (player_walking && event1.isPrimaryButtonDown()) {
            double pivot_x_player = player.getX()+ player.getFitWidth();
            double pivot_y_player = player.getY()+player.getFitHeight();
            Rotate rotate = new Rotate(0, pivot_x_player, pivot_y_player);
            player.getTransforms().add(rotate);

            rotation2 = new Timeline(
                    new KeyFrame(Duration.millis(1), new KeyValue(rotate.angleProperty(), -180))
            );
            rotation2.play();
            isManDown=!isManDown;
        }
        else {
            System.out.println("yoyo");
        }

    }

    private void increaseStickHeight() {
        stick.setHeight(stick.getHeight() + 3);
    }

    public void handleMouseReleased(MouseEvent e) {
        if(!player_walking) {
            timeline.stop();
            player_walking=true;
            double pivot_x = stick.getX();
            double pivot_y = stick.getY();
            Rotate rotate = new Rotate(0, pivot_x, pivot_y);
            stick.getTransforms().add(rotate);
            rotation = new Timeline(
                    new KeyFrame(Duration.millis(200), new KeyValue(rotate.angleProperty(), 90))
            );

            rotation.setOnFinished(event ->
            {
                double stick_height = stick.getHeight();
//        stick.setWidth(stick_height);
//        stick.setHeight(2);

//            System.out.println(stick.getX() + " + " + stick.getLayoutX());

                TranslateTransition transition = new TranslateTransition();
                transition.setNode(player);
                transition.setDuration(Duration.millis(1000));

                if (stick_height > (p2.getLayoutX() - p1.getWidth()) && stick_height < (p2.getLayoutX() - p1.getWidth() + p2.getWidth())) {
                    transition.setToX(p2.getLayoutX() - stick.getLayoutX() + p2.getWidth());
                } else {
                    transition.setToX(stick_height);
                }
                stick.setWidth(3);
//            System.out.println(player.getX());
                transition.setOnFinished(event2 -> {
                    player_walking = false;
                    if (stick_height > (p2.getLayoutX() - p1.getWidth()) && stick_height < (p2.getLayoutX() - p1.getWidth() + p2.getWidth())) {
                        current_score.setText(String.valueOf(Integer.parseInt(current_score.getText()) + 1));
                        currentScore = Integer.parseInt(current_score.getText());
                        platform_gen();
                        stick.setHeight(0);
                        stick.setWidth(3);
                        rotate.setAngle(0);
                    } else {
                        player_fall();
                    }

                });
                transition.play();
                player_walking = true;

            });

            rotation.play();
//        stick.setY(0);
        }
        else if(player_walking){
            System.out.println("hello");
        }

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
        TranslateTransition transition = new TranslateTransition(Duration.millis(950), player);
        transition.setToY(player.getTranslateY() + p1.getHeight());
        double pivot_x = stick.getX();
        double pivot_y = stick.getY();
        Rotate rotate = new Rotate(0,pivot_x,pivot_y);
        stick.getTransforms().add(rotate);
        rotation = new Timeline(
                new KeyFrame(Duration.millis(1000),new KeyValue(rotate.angleProperty(),90))
        );
        transition.setOnFinished(event -> {
            try {
                game_over();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        rotation.play();
        transition.play();


    }

    public void game_over() throws IOException {
//        storing_values();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Revive.fxml"));
        Parent root = loader.load();
//        System.out.println(RedCherryCount.getText());
        // Access the controller of the loaded FXML
        ReviveController revive = loader.getController();
        revive.set_data(Integer.parseInt(RedCherryCount.getText()),
                Integer.parseInt(BlueCherryCount.getText()),
                Integer.parseInt(current_score.getText()));
//        over.setscore( Integer.parseInt(current_score.getText()));
        // Assuming 'root' is a Parent or Region, set it as the root of the scene
        Scene scene = new Scene(root);

        // Access the stage from the event's source
        Stage stage = (Stage) player.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
//        root = FXMLLoader.load(getClass().getResource("game_over.fxml"));
//        stage = (Stage) player.getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    public void platform_gen() {
        ap.getChildren().remove(RedCherries);
        ap.getChildren().remove(BlueCherries);
        double a = Math.random() * (150 - 37 + 1) + 37;
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(1000), p2);
        TranslateTransition playerTransition = new TranslateTransition(Duration.millis(1000),player);
        p2.setTranslateX(p2.getLayoutX());
//        player.setTranslateX(player.getLayoutX());
//        player.setLayoutX(p2.getLayoutX());
        p2.setLayoutX(0);
        transition2.setToX(0);
        playerTransition.setToX(p2.getLayoutX());
        transition2.setOnFinished(event -> {
            p1.setWidth(p2.getWidth());
            p1.setLayoutX(0);
            p1.setTranslateX(0);
            p2.setWidth(a);
            current_platform_length = p1.getWidth();
            double gap = Math.random() * (250 - 40 + 1) + 40;
            p2.setLayoutX(gap + p1.getWidth());
//            double playerEdgeX = p1.getX() + p1.getWidth();
//            player.setX(0);
//            player.setTranslateX(0);
            player.setLayoutX(p1.getWidth()-player.getFitWidth()-4);
//            stick.setTranslateX(0);
//            stick.setX(0);
//            stick.setLayoutX(p1.getWidth()+p1.getLayoutX());

            player.getParent().requestLayout();
            stick.setX(player.getLayoutX()-player.getFitWidth()-16);
            cherry_gen();
            stick_made = false;
        });
        transition2.play();
        playerTransition.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            new GamePlayController();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        timer.start();

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