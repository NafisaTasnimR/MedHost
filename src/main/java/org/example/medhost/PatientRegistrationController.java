package org.example.medhost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class PatientRegistrationController implements Initializable {

    @FXML
    private TextField ageTextField;

    @FXML
    private DatePicker dateOfBirthDatePicker;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField emergencyEmailTextField;

    @FXML
    private TextField emergencyPhoneNumberTextField;

    @FXML
    private TextField homeAddressTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneNumber;

    @FXML
    private DatePicker registrationDateDatePicker;

    @FXML
    private TextField upid;


    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private Button homeButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label messageLabel;



    @FXML
    void homeButtonHandler(ActionEvent event)throws IOException{
        FXMLLoader goToReceptionist = new FXMLLoader(Main.class.getResource("receptionist.fxml"));

        Scene sceneReceptionist = new Scene(goToReceptionist.load(),700,600);
        Stage currentStage = (Stage)homeButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void logOutButtonHandler(ActionEvent event)throws IOException{
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void registerButtonHandler(ActionEvent event) {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient(nameTextField.getText(),
                ageTextField.getText(),gender.getValue(),dateOfBirthDatePicker.getValue(),
                registrationDateDatePicker.getValue(),phoneNumber.getText(),emergencyPhoneNumberTextField.getText(),
                emailTextField.getText(),emergencyEmailTextField.getText(),homeAddressTextField.getText()));

        String filepath = "PatientData.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true))){
            for (Patient patient:patientList){
                writer.write(patient.getName()+","+patient.getAge()+","+patient.getGender()+","+
                        patient.getUpid()+","+patient.getDateOfBirth()+","+patient.getRegistrationDate()+","+
                        patient.getPhoneNumber()+","+patient.getEmergencyNumber()+","+patient.getEmail()+","+
                        patient.getEmergencyEmail()+","+patient.getAddress()+","+patient.getCurrentStatus());
                writer.newLine();
            }

            System.out.println("data has been written to file");
        }catch (IOException e){
            e.printStackTrace();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Male","Female","Other");
    }



}
