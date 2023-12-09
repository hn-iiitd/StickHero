package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContinueGameMenuController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label red_cherry;
    @FXML
    private Label blue_cherry;
    @FXML
    private Label score;

    public void switchToSavedGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewGame.fxml"));
        Parent root = loader.load();

        // Access the controller of the loaded FXML
        GamePlayController game = loader.getController();
        for (Player p : DataBase.getPlayerList()) {

            if (p.getUserId().equals(StickHero.user.getUsername())) {
//                return true;
                System.out.println(p.getBlue_cherry());
                System.out.println(p.getPlayer_highestScore());
                System.out.println(p.getRed_cherry());
                System.out.println(p.getCurr_score());
                game.setdata(p.getRed_cherry(),p.getBlue_cherry(),p.getCurr_score());
            }
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Player p : DataBase.getPlayerList()) {

            if (p.getUserId().equals(StickHero.user.getUsername())) {
//                return true;
                red_cherry.setText(String.valueOf(p.getRed_cherry()));
                blue_cherry.setText(String.valueOf(p.getBlue_cherry()));
                score.setText(String.valueOf(p.getCurr_score()));
            }
        }
    }
}
