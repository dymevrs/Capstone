module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires javafx.web;
    requires java.desktop;


    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}