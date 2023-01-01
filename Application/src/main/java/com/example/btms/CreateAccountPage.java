package com.example.btms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class CreateAccountPage {
    @FXML
    private TextField usr;
    String username,password;
    @FXML
    private PasswordField pass;
    public void getAccount(ActionEvent e) throws IOException {
        username = usr.getText();
        password = pass.getText();
        FileWriter fileWriter = new FileWriter("user data.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(username+"\n");
        bufferedWriter.write(password+"\n");

        bufferedWriter.close();

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("loginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Log in");
        stage.show();
    }
}