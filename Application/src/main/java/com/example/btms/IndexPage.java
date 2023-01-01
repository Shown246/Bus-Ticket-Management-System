package com.example.btms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class IndexPage implements Initializable {

    @FXML
    private ChoiceBox<String> from;
    @FXML
    private ChoiceBox<String> to;
    @FXML
    private DatePicker date;
    String[] strings = {"Dhaka", "Dinajpur","Chittagong"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        from.getItems().addAll(strings);
        to.getItems().addAll(strings);
        from.setOnAction(this::getIndexPage);
        to.setOnAction(this::getIndexPage);
    }


    public void getIndexPage(ActionEvent e){
    }

    public String getFrom() {
        return from.getValue();
    }
    public String getTo() {
        return to.getValue();
    }
    public static LocalDate localDate;
    public void setDate(){
           localDate = date.getValue();
    }
    public String getLocalDate(){
        LocalDateStringConverter localDateStringConverter = new LocalDateStringConverter();
        return localDateStringConverter.toString(localDate);
    }

    public void searchBus(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BusList.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Available Buses");
            stage.show();

            BusList busList = fxmlLoader.getController();
            busList.checkRoute(this.getFrom(), this.getTo(),this.getLocalDate());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
