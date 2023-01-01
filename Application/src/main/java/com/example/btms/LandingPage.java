package com.example.btms;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingPage {
    FXMLLoader loader;
    public void login(ActionEvent e) throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Log in");
        stage.show();
    }

    public void createAccount(ActionEvent f) throws IOException {
        loader = new FXMLLoader(this.getClass().getResource("createAccount.fxml"));
        Scene scene2 = new Scene(loader.load());
        Stage stage2 = (Stage) ((Node) f.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.setTitle("Create new account");
        stage2.show();

    }
}
