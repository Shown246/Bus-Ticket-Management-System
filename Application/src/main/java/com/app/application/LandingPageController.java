package com.app.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingPageController {
    private Button login;


   public void login(ActionEvent e) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("loginPage.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
       Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.setTitle("Log in");
       stage.show();
   }
}
