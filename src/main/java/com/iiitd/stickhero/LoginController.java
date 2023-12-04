package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label InvalidCred;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public boolean login(String Username,String Password){
        for(Player p : DataBase.getPlayerList()){
            if(p.getUserId().equals(Username) && p.getPassword().equals(Password)){
                return true;
            }
        }
        return false;
    }

    public void switchToRegister(ActionEvent event) throws IOException {

            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    public void switchToMainmenu(ActionEvent event) throws IOException {
        if(login(Username.getText(),Password.getText())) {
            root = FXMLLoader.load(getClass().getResource("Mainmenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            Username.setText("");
            Password.setText("");
            InvalidCred.setText("Enter Valid Credentials");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Player admin = new Player("Admin","admin","");
        DataBase.getPlayerList().add(admin);
        new LoginController();
        //adding admin
    }
//    public void switchToScene1(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }public void switchToScene2(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }public void switchToScene3(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Main-view.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
}
