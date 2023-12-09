package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class leaderboardController implements Initializable {
    @FXML
    private TextField name_1;

    @FXML
    private TextField name_2;

    @FXML
    private TextField name_3;

    @FXML
    private TextField name_4;

    @FXML
    private TextField name_5;
    @FXML
    private TextField score_1;
    @FXML
    private TextField score_2;
    @FXML
    private TextField score_3;
    @FXML
    private TextField score_4;
    @FXML
    private TextField score_5;


    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Collections.sort(DataBase.getPlayerList(),new PlayerComparator());
//        Collections.sort(DataBase.getPlayerList(),Collections.reverseOrder());
        if (DataBase.getPlayerList().size()==1){
            name_1.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getName());
            score_1.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getPlayer_highestScore()));
        }
        else if (DataBase.getPlayerList().size()==2){
            name_1.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getName());
            name_2.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getName());
            score_1.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getPlayer_highestScore()));
            score_2.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getPlayer_highestScore()));
        }
        else if (DataBase.getPlayerList().size()==3){
            name_1.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getName());
            name_2.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getName());
            name_3.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-3).getName());
            score_1.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getPlayer_highestScore()));
            score_2.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getPlayer_highestScore()));
            score_3.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-3).getPlayer_highestScore()));
        }
        else if (DataBase.getPlayerList().size()==4){
            name_1.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getName());
            name_2.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getName());
            name_3.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-3).getName());
            name_4.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-4).getName());
            score_1.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getPlayer_highestScore()));
            score_2.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getPlayer_highestScore()));
            score_3.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-3).getPlayer_highestScore()));
            score_4.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-4).getPlayer_highestScore()));
        }
        else if (DataBase.getPlayerList().size()>=5){
            name_1.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getName());
            name_2.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getName());
            name_3.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-3).getName());
            name_4.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-4).getName());
            name_5.setText(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-5).getName());
            score_1.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-1).getPlayer_highestScore()));
            score_2.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-2).getPlayer_highestScore()));
            score_3.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-3).getPlayer_highestScore()));
            score_4.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-4).getPlayer_highestScore()));
            score_5.setText(String.valueOf(DataBase.getPlayerList().get(DataBase.getPlayerList().size()-5).getPlayer_highestScore()));

        }

//        new leaderboardController();/
    }
    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
