package org.example.medhost;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.medhost.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppointmentController implements Initializable {

    @FXML
    private TableColumn<ScheduledAppointment, String > appointmentDatecolumn;

    @FXML
    private TableColumn<ScheduledAppointment, String > appointmentTimeColumn;

    @FXML
    private Button homeButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TableColumn<ScheduledAppointment, String > patientNamecolumn;

    @FXML
    private TableColumn<ScheduledAppointment, String > snColumn;

    @FXML
    private TableView<ScheduledAppointment> appointmentTableView;

    @FXML
    void logOutButtonHandler(ActionEvent event) throws IOException{
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }


    @FXML
    void homeActionHandler(ActionEvent event) throws IOException {
        FXMLLoader goTohome = new FXMLLoader(Main.class.getResource("doctor.fxml"));
        Scene scenehome = new Scene(goTohome.load(), 700, 600);
        Stage currentStage = (Stage) homeButton.getScene().getWindow();
        currentStage.setScene(scenehome);

    }

    private ObservableList<ScheduledAppointment> scheduledAppointmentObservableList = FXCollections.observableArrayList(this.addDataToTable());

    private List<ScheduledAppointment> addDataToTable() {
        List<ScheduledAppointment> scheduledAppointmentList = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("AppointmentRecord.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 4){
                    String sn = data[0];
                    String patientName = data[1];
                    String date = data[2];
                    String time = data[3];

                    ScheduledAppointment scheduledAppointment = new ScheduledAppointment(sn,patientName,date,time);
                    scheduledAppointmentList.add(scheduledAppointment);
                }
                else {
                    System.out.println("Error");
                }

         }
//            try {
//                reader.close();
//            }catch (IOException e){
//                e.printStackTrace();
//            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return scheduledAppointmentList;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        snColumn.setCellValueFactory(new PropertyValueFactory<>("SN"));
        patientNamecolumn.setCellValueFactory(new PropertyValueFactory<>("TablePatientName"));
        appointmentDatecolumn.setCellValueFactory(new PropertyValueFactory<>("TableDate"));
        appointmentTimeColumn.setCellValueFactory(new PropertyValueFactory<>("TableTime"));

        appointmentTableView.setItems(scheduledAppointmentObservableList);
    }
}

