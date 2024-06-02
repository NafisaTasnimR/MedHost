package org.example.medhost;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistController {

    @FXML
    private Button billingButton;

    @FXML
    private Button doctorAppointmentButton;

    @FXML
    private Button inPatientManagementButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button patientRegistrationButton;
    @FXML
    private Button logOutButton;


    @FXML
    void logOutButtonHandler()throws IOException{
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);
    }

    @FXML
    void billingButtonHandler(ActionEvent event) throws IOException {
        FXMLLoader goToBilling = new FXMLLoader(Main.class.getResource("billing.fxml"));

        Scene sceneBilling = new Scene(goToBilling.load(),700,600);
        Stage currentStage = (Stage)billingButton.getScene().getWindow();
        currentStage.setScene(sceneBilling);

    }

    @FXML
    void doctorAppointmentButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToDoctorAppointment = new FXMLLoader(Main.class.getResource("doctorAppointment.fxml"));

        Scene sceneDoctorAppointment = new Scene(goToDoctorAppointment.load(),700,600);
        Stage currentStage = (Stage)doctorAppointmentButton.getScene().getWindow();
        currentStage.setScene(sceneDoctorAppointment);

    }

    @FXML
    void inPatientManagementButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToInPatientManagement = new FXMLLoader(Main.class.getResource("inPatientManagement.fxml"));

        Scene sceneInPatientManagement = new Scene(goToInPatientManagement.load(),700,600);
        Stage currentStage = (Stage)inPatientManagementButton.getScene().getWindow();
        currentStage.setScene(sceneInPatientManagement);

    }

    @FXML
    void inventoryButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToInventory = new FXMLLoader(Main.class.getResource("inventory.fxml"));


        Scene sceneInventory = new Scene(goToInventory.load(),700,600);
        Stage currentStage = (Stage)inventoryButton.getScene().getWindow();
        currentStage.setScene(sceneInventory);

    }

    @FXML
    void patientRegistrationButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToPatientRegistration = new FXMLLoader(Main.class.getResource("patientRegistration.fxml"));

        Scene scenePatientRegistration = new Scene(goToPatientRegistration.load(),700,600);
        Stage currentStage = (Stage)patientRegistrationButton.getScene().getWindow();
        currentStage.setScene(scenePatientRegistration);

    }
}

