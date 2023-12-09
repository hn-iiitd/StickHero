package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeCharController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label message;
    private int RedCherryCount;
    private String username = StickHero.user.getUsername();
    private int BlueCherryCount;
    private int score;
    @FXML
    private Label error;

    public void set_data(int red, int blue, int score) {
        this.BlueCherryCount = blue;
        this.RedCherryCount = red;
        this.score = score;
//        final_score.setText(String.valueOf(score));
    }

    public void ChangeToYoda(MouseEvent event) throws IOException {
        try {
            DataBase.setPlayerList(DataBase.deserialize());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Player p : DataBase.getPlayerList()) {
            if (p.getUserId().equals(username)) {
//                return true;

                p.setCharacter_img(1);

                DataBase.serialize(DataBase.getPlayerList());
            }
        }
        message.setText("Character changed to YODA");

    }

    public void ChangeToDefault(MouseEvent event) throws IOException {
        try {
            DataBase.setPlayerList(DataBase.deserialize());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Player p : DataBase.getPlayerList()) {
            if (p.getUserId().equals(username)) {
                p.setCharacter_img(0);
                DataBase.serialize(DataBase.getPlayerList());
            }
        }
        message.setText("Character changed to DEFAULT");

    }

    public void switchToMainmenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
