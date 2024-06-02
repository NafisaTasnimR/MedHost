package org.example.medhost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DoctorAppointmentController implements Initializable {

    @FXML
    private TextField ageTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField contactTextField;

    @FXML
    private Label doctorInformationLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private Button homeButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private TextField DoctorsNameTextField;


    @FXML
    private Label patientInformationLabel;

    @FXML
    private DatePicker scheduledDateDatePicker;

    @FXML
    private TextField specializationTextField;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextField uidTextField;
    @FXML
    void homeButtonHandler(ActionEvent event)throws IOException{
        FXMLLoader goToReceptionist = new FXMLLoader(Main.class.getResource("receptionist.fxml"));

        Scene sceneReceptionist = new Scene(goToReceptionist.load(),700,600);
        Stage currentStage = (Stage)homeButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void logOutButtonHandler(ActionEvent event) throws IOException{
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)homeButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void confirmButtonHandler(ActionEvent event) {
        List<Appointment> appointmentList = new ArrayList<>();

        appointmentList.add(new Appointment(new Patient(patientNameTextField.getText(), ageTextField.getText(),genderChoiceBox.getValue(),
                contactTextField.getText(), emailTextField.getText()),
                new Doctor(DoctorsNameTextField.getText(), specializationTextField.getText(),uidTextField.getText()),
                timeTextField.getText(),scheduledDateDatePicker.getValue()));
        Appointment appointment = new Appointment();
        appointment.makeAppointment(appointmentList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderChoiceBox.getItems().addAll("Male","Female","Other");
    }

}
