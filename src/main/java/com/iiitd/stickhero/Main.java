package com.iiitd.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    @Override

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //----to_add_css-----
//        String css = this.getClass().getResource("Style.css").toExternalForm();
//        scene.getStylesheets().add(css);
        //----------------------------


        stage.setTitle("StickHero");
        Image icon = new Image("unnamed.png");

        stage.getIcons().add(icon);
        stage.setHeight(520);
        stage.setWidth(460);
//        stage.setResizable(false);
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}