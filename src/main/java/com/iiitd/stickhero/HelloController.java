package com.iiitd.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    public void up(ActionEvent e){
        System.out.println("UP");

    }
    @FXML
    public void down(ActionEvent e){
        System.out.println("DOWN");

    }
    @FXML
    public void left(ActionEvent e){
        System.out.println("LEFT");
    }
    @FXML
    public void right(ActionEvent e){
        System.out.println("RIGHT");
    }

}