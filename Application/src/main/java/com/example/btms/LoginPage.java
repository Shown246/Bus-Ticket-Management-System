package com.example.btms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LoginPage{
    @FXML
    private TextField usr;
    String username,password;
    @FXML
    private PasswordField pass;

    public void getLogin(ActionEvent e) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("user data.txt","rw");
        String line;
        int ct = 0;
        while((line = randomAccessFile.readLine())!=null) {
            username = line;
            password = randomAccessFile.readLine();

            if (username.equals(usr.getText()) && password.equals(pass.getText())) {
                FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("IndexPage.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Index Page");
                stage.show();

                FileWriter fileWriter = new FileWriter("Purchase History.txt",true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("Passenger Name: "+username+"\n");
                bufferedWriter.close();

                IndexPage indexPage= fxmlLoader.getController();
                indexPage.getIndexPage(e);
                ct++;
                break;

            }
        }
        if (ct==0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wrong Password");
            alert.setHeaderText("You've entered wrong Password");
            alert.setContentText("TRY AGAIN");
            alert.showAndWait();
            usr.setText("");
            pass.setText("");
        }
        randomAccessFile.close();
    }
}
