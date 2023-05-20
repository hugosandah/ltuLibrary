package com.example.ltulibrary;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class returnDvdController {

    @FXML
    private TextField BarcodeDvdButton;

    @FXML
    private Button returnDvdConfirmButton;

    private Connection connection;

    public void initialize() {
        try {
            connection = DatabaseConnection.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onReturnDvdConfirm() {
        String barcode = BarcodeDvdButton.getText();

        try {
            // Retrieve loan information based on the barcode
            String query = "SELECT * FROM DVD_lan WHERE barcode_DVD = ? AND dvd_Status = 'Borrowed'";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, barcode);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int loanId = resultSet.getInt("dvd_lan_Id");
                int Kund_Id = resultSet.getInt("lan_Id");

                // Update loan status and return date
                query = "UPDATE DVD_lan SET dvd_Status = 'Returned', datum_Faktisk_retur = CURRENT_DATE() WHERE dvd_lan_Id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, loanId);
                statement.executeUpdate();

                // Update DVD availability
                query = "UPDATE DVD SET availability = 'Available' WHERE barcode_DVD = ?";
                statement = connection.prepareStatement(query);
                statement.setString(1, barcode);
                statement.executeUpdate();

                // Display success message to the customer
                System.out.println("DVD returned successfully.");

                // Clear the barcode text field
                BarcodeDvdButton.clear();
            } else {
                // Display error message indicating an invalid loan or incorrect barcode
                System.out.println("Invalid loan or barcode.");
            }

        } catch (SQLException e) {
            // Handle any potential exceptions
            e.printStackTrace();
        }
    }

    // Other methods, if any...
}

