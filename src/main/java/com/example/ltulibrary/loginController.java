package com.example.ltulibrary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    public void onLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loan.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);

    }

        public void onRegister() throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
            Parent myPagesParent = fxmlLoader.load();
            Scene myPagesScene = new Scene(myPagesParent);
            Stage currentStage = (Stage) registerButton.getScene().getWindow();
            currentStage.setScene(myPagesScene);

    }
}