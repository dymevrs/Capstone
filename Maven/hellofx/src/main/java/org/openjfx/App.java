package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


/**
 ** JavaFX Application
 **/
public class App extends Application {

    static Scene scene;

    //Initialize and create window function
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("HomePage"));
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        stage.getIcons().add(new Image(App.class.getResourceAsStream("Raider.png")));
        stage.setScene(scene);
        stage.setTitle("Parent Resource Application v1.2");
        stage.show();
    }

    //Choose Page
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //Pull fxml files from resource folder
    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}