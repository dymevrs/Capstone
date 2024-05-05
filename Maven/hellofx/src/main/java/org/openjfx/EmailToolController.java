package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmailToolController {

    @FXML
    private DatePicker DatePicker;

    @FXML
    private Button GenerateEmailButton;

    @FXML
    private TextField ChildNameText;

    @FXML
    private TextField AdultNameText;

    @FXML
    private TextArea ReasonText;

    @FXML
    public static String ChildName;
    @FXML
    public static String AdultName;
    @FXML
    public static String Date;
    @FXML
    public static String Reason;

    @FXML
    void Submit(ActionEvent event) {
        // Retrieve the values from the UI components
        ChildName = ChildNameText.getText();
        AdultName = AdultNameText.getText();
        Reason = ReasonText.getText();
        LocalDate selectedDate = DatePicker.getValue();

        // Check if a date is selected
        if (selectedDate != null) {
            // Define the desired date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

            // Format the date
            Date = ((LocalDate) selectedDate).format(formatter);
        } else {
            selectedDate = LocalDate.now();
        }

        // You can now use the variables as needed, pass them to another class, etc.
        System.out.println("Date: " + Date);
        System.out.println("Child's Name: " + ChildName);
        System.out.println("Adult's Name: " + AdultName);
        System.out.println("Reason: " + Reason);


        EmailSender.Activate();
    }

    @FXML
    public String getChildName() {
        return ChildName;
    }

    @FXML
    public String getAdultName() {
        return AdultName;
    }

    @FXML
    public String getReason() {
        return Reason;
    }

    @FXML
    public String getDate() {
        return Date;
    }
}