package com.example.ltulibrary;

import javafx.event.ActionEvent;
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


public class startPageController  implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//kopiera dessa två
    }

    @FXML
    private Button cancelButton;
    @FXML
    private Button loanButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button adminButton;
    @FXML
    private Button returnBookButton;
    @FXML
    private Button returnDvdButton;



    @FXML
    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();


    }

    public void onLoad() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) loanButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);
    }

    public void onSearch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) searchButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);

    }

    public void onadminLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminLogin.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) adminButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);
    }
    public void onReturnBook1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("returnBook.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) returnBookButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);
    }
    public void onReturnDvd1() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("returnBook.fxml"));
        Parent myPagesParent = fxmlLoader.load();
        Scene myPagesScene = new Scene(myPagesParent);
        Stage currentStage = (Stage) returnDvdButton.getScene().getWindow();
        currentStage.setScene(myPagesScene);
    }
}