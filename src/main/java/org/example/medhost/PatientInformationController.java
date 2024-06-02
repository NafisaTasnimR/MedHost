package org.example.medhost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PatientInformationController {

    @FXML
    private Text ageText;

    @FXML
    private Text diseaseText;

    @FXML
    private Text genderText;

    @FXML
    private Button homeButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Text nameText;

    @FXML
    private Text prescribedMedicineText;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text testReportText;


    @FXML
    void homeActionHandler(ActionEvent event) throws IOException {
        FXMLLoader goTohome = new FXMLLoader(Main.class.getResource("doctor.fxml"));
        Scene scenehome = new Scene(goTohome.load(),700,600);
        Stage currentStage = (Stage)homeButton.getScene().getWindow();
        currentStage.setScene(scenehome);

    }

    @FXML
    void logOutButtonActionHandler(ActionEvent event)throws IOException{
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void searchButtonHandler(ActionEvent event) {
        this.searchValueAndShow();

    }

    public void searchValueAndShow(){
        boolean validity  = false;

        List<MedicalRecord> medicalRecords = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("PatientMedicalRecord.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 6){
                    String name = data[0];
                    String age = data[1];
                    String gender = data[2];
                    String disease = data[3];
                    String prescribedMedicine = data[4];
                    String testReport = data[5];

                    MedicalRecord medicalRecord = new MedicalRecord(new Patient(name,age,gender),
                            disease,prescribedMedicine,testReport);
                    medicalRecords.add(medicalRecord);
                }
                else {
                    System.out.println("Error");
                }
            }


            for (MedicalRecord medicalRecord: medicalRecords){
                if (Objects.equals(medicalRecord.patient.getName(), searchTextField.getText())){
                    validity = true;
                    nameText.setText(medicalRecord.patient.getName());
                    ageText.setText(medicalRecord.patient.getAge());
                    genderText.setText(medicalRecord.patient.getGender());
                    diseaseText.setText(medicalRecord.getDisease());
                    prescribedMedicineText.setText(medicalRecord.getPrescribedMedicine());
                    testReportText.setText(medicalRecord.getTestReport());

                    nameText.setVisible(validity);
                    ageText.setVisible(validity);
                    genderText.setVisible(validity);
                    diseaseText.setVisible(validity);
                    prescribedMedicineText.setVisible(validity);
                    testReportText.setVisible(validity);

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

    }


}

