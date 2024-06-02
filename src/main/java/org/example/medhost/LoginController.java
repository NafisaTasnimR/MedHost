package org.example.medhost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoginController {
    @FXML
    private Button submitButton;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    @FXML
    public void submitActionHandler(ActionEvent event) throws IOException {
        boolean doctorValidity = this.DoctorChecker();
        boolean receptionistValidity = this.ReceptionistChecker();

        if (receptionistValidity){
            FXMLLoader goToReceptionist = new FXMLLoader(Main.class.getResource("receptionist.fxml"));

            Scene sceneReceptionist = new Scene(goToReceptionist.load(),700,600);
            Stage currentStage = (Stage)submitButton.getScene().getWindow();
            currentStage.setScene(sceneReceptionist);
        }
        else if (doctorValidity)
            {
                FXMLLoader goToDoctor = new FXMLLoader(Main.class.getResource("doctor.fxml"));

                Scene sceneDoctor = new Scene(goToDoctor.load(),700,600);
                Stage currentStage = (Stage)submitButton.getScene().getWindow();
                currentStage.setScene(sceneDoctor);
            }

    }


    public boolean DoctorChecker(){
        boolean bool = false;

        List<Doctor> doctorList = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("DoctorData.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 5){
                    String name = data[0];
                    String pass = data[4];
                    Doctor doctor = new Doctor(name,pass);
                    doctor.passwordChecker(password.getText());
                    doctorList.add(doctor);
                }
                else {
                    System.out.println("Error");
                }
            }
            for (Doctor doctor:doctorList){
                if (Objects.equals(doctor.getName(), username.getText()) && Objects.equals(doctor.getPassword(), password.getText())){
                    bool = true;
                    break;
                }
            }

        }catch (InsufficientPasswordCharacterException insufficientPasswordCharacterException){
            System.out.println("Invalid Password!");
            insufficientPasswordCharacterException.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return bool;
    }
    public boolean ReceptionistChecker(){
        boolean validity = false;
        List<Receptionist> receptionists = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("StaffData.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 5){
                    String name = data[0];
                    String pass = data[4];
                    Receptionist receptionist = new Receptionist(name,pass);
                    receptionist.passwordChecker(password.getText());
                    receptionists.add(receptionist);
                } else {System.out.println("Error");}
            }
            for (Receptionist receptionist:receptionists){
                if (Objects.equals(receptionist.getName(), username.getText()) && Objects.equals(receptionist.getPassword(), password.getText())){
                    validity = true;
                    break;
                }
            }
        }catch (InsufficientPasswordCharacterException passwordCharacterException){
            passwordCharacterException.printStackTrace();
            System.out.println("Invalid Password!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return validity;
    }

}
