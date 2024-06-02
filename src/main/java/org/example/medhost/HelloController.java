package org.example.medhost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button nextButton;

    @FXML
    void nextButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToLogInLoader = new FXMLLoader(Main.class.getResource("login.fxml"));

        Scene sceneReceptionist = new Scene(goToLogInLoader.load(),700,600);
        Stage currentStage = (Stage)nextButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

}