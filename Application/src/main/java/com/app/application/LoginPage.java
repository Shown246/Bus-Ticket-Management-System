package com.app.application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginPage {
    @FXML
    private TextField usr;
    String username,password;
    @FXML
    private PasswordField pass;
    public void getLogin() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("user data.txt","r");
        String line;
        int ct = 0;
        while((line = randomAccessFile.readLine())!=null) {
            username = line;
            password = randomAccessFile.readLine();
            if (username.equals(usr.getText()) && password.equals(pass.getText())) {
              System.out.println("Hello World");
              ct++;
            }
        }
        if (ct==0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wrong Password");
            alert.setHeaderText("You've entered wrong Password");
            alert.setContentText("TRY AGAIN");
            alert.showAndWait();
        }
        randomAccessFile.close();
    }
}