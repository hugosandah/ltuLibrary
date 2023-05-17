module com.example.ltulibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ltulibrary to javafx.fxml;
    exports com.example.ltulibrary;
}