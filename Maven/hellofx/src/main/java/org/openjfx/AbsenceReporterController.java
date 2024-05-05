package org.openjfx;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AbsenceReporterController {

    //Unsure of why exactly I had to declare this here but the code got angry if I removed it
    @FXML
    private AnchorPane centerPane;

    //Change Page Functions
    @FXML
    private void SwitchToHomePage() throws IOException {
        App.setRoot("HomePage");
    }

    @FXML
    private void SwitchToCalendar() throws IOException {
        App.setRoot("Calendar");
    }

    @FXML
    private void SwitchToAbsenceReporter() throws IOException {
        App.setRoot("AbsenceReporter");
    }

    //Launch popup window function
    @FXML
    private void launchTool(ActionEvent event) throws IOException {
        //Load the content for the new window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EmailTool.fxml"));
        Parent root = loader.load();

        //Create a new Window
        Stage stage = new Stage();
        stage.setTitle("Tool Window");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("Raider.png")));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
