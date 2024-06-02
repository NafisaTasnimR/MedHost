package org.example.medhost;

//import com.sun.javafx.tk.quantum.PaintRenderJob;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorController {

    @FXML
    private Button scheduledAppointment;

    @FXML
    private Button logoutButton;

    @FXML
    private Button patientInformationButton;

    @FXML
    void appointmentActionHandler(ActionEvent event) throws IOException{
        FXMLLoader goToappointment = new FXMLLoader(Main.class.getResource("appointment.fxml"));
        Scene sceneappointment = new Scene(goToappointment.load(),700,600);
        Stage currentStage = (Stage)scheduledAppointment.getScene().getWindow();
        currentStage.setScene(sceneappointment);
    }

    @FXML
    void patientInformationActionHandler(ActionEvent event)throws IOException{
        FXMLLoader goTopatientInformation= new FXMLLoader(Main.class.getResource("patientInformation.fxml"));
        Scene scenepatientInformation = new Scene(goTopatientInformation.load(),700,600);
        Stage currentStage = (Stage)patientInformationButton.getScene().getWindow();
        currentStage.setScene(scenepatientInformation);
    }

    @FXML
    void logOutButtonHandler(ActionEvent event) throws IOException{
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logoutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }


}
