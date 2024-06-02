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

public class BillingController {

    @FXML
    private Text ageText;

    @FXML
    private Text doctorBillText;

    @FXML
    private Text genderText;

    @FXML
    private Button homeButton;

    @FXML
    private Text imagingBillText;

    @FXML
    private Button logOutButton;

    @FXML
    private Text nameText;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text surgeryBillText;

    @FXML
    private Text totalCostText;

    @FXML
    private Text upidText;

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
    void searchButtonHandler(ActionEvent event) {
        this.searchValueAndShow();
    }

    public boolean searchValueAndShow(){
        boolean validity = false;

        List<InPatientMedicalInfo> BillList = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("MedicalBillData.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 8){
                    String name = data[0];
                    String age = data[1];
                    String gender = data[2];
                    String upid = data[3];
                    String docBill = data[4];
                    String imagingBill = data[5];
                    String surgeryBill = data[6];
                    String totalCost = data[7];

                    InPatientMedicalInfo medicalBIll = new InPatientMedicalInfo(name,age,gender,upid,Integer.parseInt(docBill),Integer.parseInt(imagingBill),Integer.parseInt(surgeryBill),Integer.parseInt(totalCost));
                    BillList.add(medicalBIll);
                }
                else {
                    System.out.println("Error");
                }
            }

            for (InPatientMedicalInfo medicalBIll: BillList){
                if (Objects.equals(medicalBIll.getName(), searchTextField.getText()) || Objects.equals(medicalBIll.getUpid(),searchTextField.getText())){
                    validity = true;
                    nameText.setText(medicalBIll.getName());
                    ageText.setText(medicalBIll.getAge());
                    upidText.setText(medicalBIll.getUpid());
                    genderText.setText(medicalBIll.getGender());
                    doctorBillText.setText(Integer.toString(medicalBIll.getDoctorsBill()));
                    imagingBillText.setText(Integer.toString(medicalBIll.getImagingBill()));
                    surgeryBillText.setText(Integer.toString(medicalBIll.getSurgeryBill()));
                    totalCostText.setText(Integer.toString(medicalBIll.getTotalCost()));

                    nameText.setVisible(validity);
                    ageText.setVisible(validity);
                    upidText.setVisible(validity);
                    genderText.setVisible(validity);
                    doctorBillText.setVisible(validity);
                    imagingBillText.setVisible(validity);
                    surgeryBillText.setVisible(validity);
                    totalCostText.setVisible(validity);

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

}
