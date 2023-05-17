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

public class adminLoginController  implements Initializable {




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button adminLoginButton;



    public void OnAdminLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminPage.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) adminLoginButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);

    }
}
