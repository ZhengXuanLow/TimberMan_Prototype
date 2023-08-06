module com.example.timberman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.timberman to javafx.fxml;
    exports com.example.timberman;
}