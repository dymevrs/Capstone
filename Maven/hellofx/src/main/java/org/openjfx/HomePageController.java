package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomePageController {

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

}
