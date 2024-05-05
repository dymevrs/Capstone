package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CalendarController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {}

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

    //Establish Hyperlink
    @FXML
    void hyperLink(ActionEvent event) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(java.net.URI.create("https://rvms.gccschools.com/home/calendar/"));

    }

}