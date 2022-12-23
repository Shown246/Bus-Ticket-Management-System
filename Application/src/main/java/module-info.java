module com.app.application {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.application to javafx.fxml;
    exports com.app.application;
}