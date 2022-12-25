package com.app.application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

public class CreateAccountPage {
    @FXML
    private TextField usr;
    String username,password;
    @FXML
    private PasswordField pass;
    public void getAccount() throws IOException {
        username = usr.getText();
        password = pass.getText();
        FileWriter fileWriter = new FileWriter("user data.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(username+"\n");
        bufferedWriter.write(password+"\n");


        bufferedWriter.close();
    }
}