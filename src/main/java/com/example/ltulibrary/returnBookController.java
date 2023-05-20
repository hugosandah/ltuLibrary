package com.example.ltulibrary;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class returnBookController {

    @FXML
    private TextField BarcodeBookButton;

    @FXML
    private Button returnBookComfirmButton;

    private Connection connection;

    public void initialize() {
        try {
            connection = DatabaseConnection.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onReturnBookComfirm() {
        String barcode = BarcodeBookButton.getText();

        try {
            // Retrieve loan information based on the barcode
            String query = "SELECT * FROM Bok_lan WHERE barcode_Bok = ? AND bok_Status = 'Borrowed'";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, barcode);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int loanId = resultSet.getInt("bok_lan_Id");
                int Kund_Id = resultSet.getInt("lan_Id");

                // Update loan status and return date
                query = "UPDATE Bok_lan SET bok_Status = 'Returned', datum_Faktisk_retur = CURRENT_DATE() WHERE bok_lan_Id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, loanId);
                statement.executeUpdate();

                // Update book availability
                query = "UPDATE Bok SET availability = 'Available' WHERE barcode_Bok = ?";
                statement = connection.prepareStatement(query);
                statement.setString(1, barcode);
                statement.executeUpdate();

                // Display success message to the customer
                System.out.println("Book returned successfully.");

                // Clear the barcode text field
                BarcodeBookButton.clear();
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
