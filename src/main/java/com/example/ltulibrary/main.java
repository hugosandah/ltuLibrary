package com.example.ltulibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("startPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ltu Library");
        stage.setScene(scene);
        stage.show();
        databaseConnection db = new databaseConnection();
        db.connect();

    }

    public static void main(String[] args) {
        launch();
    }
}