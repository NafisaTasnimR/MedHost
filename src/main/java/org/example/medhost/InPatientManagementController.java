package org.example.medhost;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.*;

public class InPatientManagementController implements Initializable {


    @FXML
    private ChoiceBox<String> currentStatusChoiceBox;

    @FXML
    private Button homeButton;


    @FXML
    private Button logOutButton;

    @FXML
    private Button searchButton;

    @FXML
    private Text admissionDateText;

    @FXML
    private Text ageText;

    @FXML
    private DatePicker dischargeDatePicker;

    @FXML
    private Text genderText;

    @FXML
    private Text nameText;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text upidText;

    @FXML
    private Text assignedDoctorText;
    @FXML
    private Button SETButton;

    @FXML
    private Button SetDateButton;
    @FXML
    private Text roomNoText;
    @FXML
    private Text wardNoText;


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
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void searchButtonHandler(ActionEvent event) {
        this.searchValueAndShow();

    }
    @FXML
    void SETButtonHandler(ActionEvent event) {
        this.modifyStatusInTextFile();
    }

    @FXML
    void SetDateButtonHandler(ActionEvent event) {
        this.addDischargeDateToFile();

    }

    public boolean searchValueAndShow(){
        boolean validity = false;

        List<Patient> patientList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("PatientData.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 15){
                    String name = data[0];
                    String age = data[1];
                    String gender = data[2];
                    String upid = data[3];
                    String dateOfBirth = data[4];
                    String registrationDate = data[5];
                    String phoneNum = data[6];
                    String ePhoneNum = data[7];
                    String email = data[8];
                    String emergencyEmail = data[9];
                    String homeAddress = data[10];
                    String currentStatus = data[11];
                    String roomNo = data[13];
                    String wardNo = data[14];

                    Patient patient = new Patient(name,age,gender,upid,dateOfBirth,
                            registrationDate,phoneNum,ePhoneNum,email,emergencyEmail,homeAddress,currentStatus,roomNo,wardNo);
                    patientList.add(patient);

                }
                else {
                    System.out.println("Error");
                }

            }
            for (Patient patient:patientList){
                if (Objects.equals(patient.getName(), searchTextField.getText()) || Objects.equals(patient.getUpid(),searchTextField.getText())){
                    validity = true;
                    nameText.setText(patient.getName());
                    ageText.setText(patient.getAge());
                    upidText.setText(patient.getUpid());
                    genderText.setText(patient.getGender());
                    admissionDateText.setText(patient.getRegistrationDate());
                    assignedDoctorText.setText(patient.getAssignedDoctor());
                    roomNoText.setText(patient.getRoomNo());
                    wardNoText.setText(patient.getWardNo());

                    nameText.setVisible(validity);
                    ageText.setVisible(validity);
                    upidText.setVisible(validity);
                    genderText.setVisible(validity);
                    admissionDateText.setVisible(validity);
                    assignedDoctorText.setVisible(validity);
                    roomNoText.setVisible(validity);
                    wardNoText.setVisible(validity);

                    break;
                }
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return validity;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentStatusChoiceBox.getItems().addAll("Admitted","Discharged");
        currentStatusChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if(Objects.equals(currentStatusChoiceBox.getItems().get((Integer) number2),"Discharged")){
                    dischargeDatePicker.setDisable(false);
                }else if (Objects.equals(currentStatusChoiceBox.getItems().get((Integer) number2),"Admitted")){
                    dischargeDatePicker.setDisable(true);
                }

            }
        });

    }


    private void modifyStatusInTextFile(){
        List<Patient> changedPatientInformations = new ArrayList<>();
        if(Objects.equals(currentStatusChoiceBox.getValue(),"Discharged")){
            try(BufferedReader reader1 = new BufferedReader(new FileReader("PatientData.txt"))){
                String line;
                while ((line = reader1.readLine()) != null){
                    String[] data1 = line.split(",");
                    if(data1.length == 15) {
                        String name = data1[0];
                        String age = data1[1];
                        String gender = data1[2];
                        String upid = data1[3];
                        String dateOfBirth = data1[4];
                        String registrationDate = data1[5];
                        String phoneNum = data1[6];
                        String ePhoneNum = data1[7];
                        String email = data1[8];
                        String emergencyEmail = data1[9];
                        String homeAddress = data1[10];
                        String currentStatus = data1[11];
                        String roomNo = data1[13];
                        String wardNo = data1[14];
                        if(Objects.equals(data1[11], "Admitted") && Objects.equals(searchTextField.getText(), name)){
                            currentStatus = "Discharged";
                        }

                        Patient patient2 = new Patient(name,age,gender,upid,dateOfBirth,
                                registrationDate,phoneNum,ePhoneNum,email,emergencyEmail,homeAddress,currentStatus,roomNo,wardNo);
                        changedPatientInformations.add(patient2);
                    }
                }try {
                    reader1.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("InPatientManagementData.txt"))){
                for(Patient patient : changedPatientInformations){
                    writer.write(patient.getName()+","+patient.getAge()+","+patient.getGender()+","+ patient.getUpid()+","+patient.getDateOfBirth()+","+patient.getRegistrationDate()+","+ patient.getPhoneNumber()+","+patient.getEmergencyNumber()+","+patient.getEmail()+","+ patient.getEmergencyEmail()+","+patient.getAddress()+","+patient.getCurrentStatus()+","+patient.getRoomNo()+","+patient.getWardNo());
                    writer.newLine();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private void addDischargeDateToFile() {
        List<Patient> changedPatientInformations = new ArrayList<>();
        if (Objects.equals(currentStatusChoiceBox.getValue(), "Discharged")) {
            try (BufferedReader reader1 = new BufferedReader(new FileReader("PatientData.txt"))) {
                String line;
                while ((line = reader1.readLine()) != null) {
                    String[] data1 = line.split(",");
                    if (data1.length == 15) {
                        String name = data1[0];
                        String age = data1[1];
                        String gender = data1[2];
                        String upid = data1[3];
                        String dateOfBirth = data1[4];
                        String registrationDate = data1[5];
                        String phoneNum = data1[6];
                        String ePhoneNum = data1[7];
                        String email = data1[8];
                        String emergencyEmail = data1[9];
                        String homeAddress = data1[10];
                        String currentStatus = data1[11];
                        String roomNo = data1[13];
                        String wardNo = data1[14];

                        Patient patient2 = new Patient(name, age, gender, upid, dateOfBirth,
                                registrationDate, phoneNum, ePhoneNum, email, emergencyEmail, homeAddress, currentStatus,roomNo,wardNo);
                        changedPatientInformations.add(patient2);
                    }
                }
                try {
                    reader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("InPatientManagement.txt"))){
                for(Patient patient : changedPatientInformations){
                    String dischargeDate = "N/A";
                    if(Objects.equals(patient.getName(),searchTextField.getText())) {
                        dischargeDate = patient.getDischareDate(dischargeDatePicker.getValue());
                        patient.setCurrentStatus("Discharged");
                    }
                        writer.write(patient.getName() + "," + patient.getAge() + "," +
                                patient.getGender() + "," + patient.getUpid() + "," + patient.getDateOfBirth() +
                                "," + patient.getRegistrationDate() + "," + patient.getPhoneNumber() + "," +
                                patient.getEmergencyNumber() + "," + patient.getEmail() + "," +
                                patient.getEmergencyEmail() + "," + patient.getAddress() + "," +
                                patient.getCurrentStatus() + "," +
                                dischargeDate + "," + patient.getRoomNo() + "," + patient.getWardNo());
                        writer.newLine();

                }
            }catch (IOException e){
                e.printStackTrace();
            }


        }
    }

}
