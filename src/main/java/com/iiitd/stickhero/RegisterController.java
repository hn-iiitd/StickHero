package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField Email_ID;
    @FXML
    private TextField User_ID;
    @FXML
    private TextField Password;
    @FXML
    private Label match_passwords;
    @FXML
    private Label UserIDexists;
    @FXML
    public TextField Confirm_Password;
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchTologin(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            DataBase.setPlayerList(DataBase.deserialize());
        }
        catch (Exception e){
            System.out.println("Database Not found");
        }
        if(check_AvailableUserID(User_ID.getText()) && passwords_matched(Password.getText(),Confirm_Password.getText())){
            DataBase.getPlayerList().add(Player.createNewPlayer(Email_ID.getText(),User_ID.getText(),Password.getText()));
            DataBase.serialize(DataBase.getPlayerList());
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}}

    private boolean passwords_matched(String text, String text1) {
        if(text.equals(text1)){
            return true;
        }
        match_passwords.setText("Password not matching!");
        return false;
    }

    private boolean check_AvailableUserID(String text) {
        for(Player p1 : DataBase.getPlayerList()){
            if(p1.getUserId().equals(text)){
                UserIDexists.setText("Username Already Exists!");
                return false;
            }
        }
        return true;
    }
}
