package com.example.btms;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BusList{
   Map<Integer, String[]> bus = new HashMap<>();


   public BusList(){
       bus.put(1, new String[]{"Dhaka", "Dinajpur","10:15"});
       bus.put(2, new String[]{"Dhaka", "Chittagong","12:00"});
       bus.put(3, new String[]{"Chittagong", "Dinajpur","14:15"});
       bus.put(4, new String[]{"Chittagong", "Dhaka","18:00"});
       bus.put(5, new String[]{"Dianjpur", "Dhaka","20:15"});
       bus.put(6, new String[]{"Dinajpur", "Chittagong", "22:15"});

   }
    @FXML
    private Label f;
    @FXML
    private Label t;
    @FXML
    private Label time;
    @FXML
    private Label d;

    String location,destination,timing, dt;
    @FXML
    public void checkRoute(String from , String to, String date){
       Integer i = 1;
       int ct=0;
       while (i<7) {
           String[] locations = bus.get(i);
           location = locations[0];
           destination = locations[1];
           timing = locations[2];
           dt = date;
           if (from.equals(location) && to.equals(destination)) {
               this.f.setText(location);
               this.t.setText(destination);
               this.time.setText(timing);
               this.d.setText(dt);

               ct++;
               break;
           }
           i++;
       }
       if (ct==0){
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Incorrect route");
           alert.setHeaderText("There's no bus in this route");
           alert.setContentText("TRY AGAIN");
           alert.showAndWait();
       }

   }

   public void ConfirmBooking() throws IOException {
       FileWriter fileWriter = new FileWriter("Purchase History.txt",true);
       BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
       bufferedWriter.write("From: "+location+"\n");
       bufferedWriter.write("To: "+destination+"\n");
       bufferedWriter.write("Date: "+dt+"\n");
       bufferedWriter.write("Time: "+timing+"\n\n");

       bufferedWriter.close();

       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Confirmed");
       alert.setHeaderText("Your ticket has been confirmed.");
       alert.setContentText("Have a good journey!");
       alert.showAndWait();
   }
}