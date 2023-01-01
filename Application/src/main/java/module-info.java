module com.example.btms {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.btms to javafx.fxml;
    exports com.example.btms;
}