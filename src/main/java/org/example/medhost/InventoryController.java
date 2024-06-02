package org.example.medhost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable{

    @FXML
    private Button homeButton;

    @FXML
    private Button listOfProductButton;

    @FXML
    private Button pendingTransactionButton;

    @FXML
    private Button productDetailsListButton;
    @FXML
    private Button logOutButton;
    @FXML
    void logOutButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);
    }


    @FXML
    void listOfProductButtonHandler(ActionEvent event)throws IOException{
        FXMLLoader goToListOfProduct = new FXMLLoader(Main.class.getResource("listOfTheProduct.fxml"));

        Scene scenelistOfProduct = new Scene(goToListOfProduct.load(),700,600);
        Stage currentStage = (Stage)listOfProductButton.getScene().getWindow();
        currentStage.setScene(scenelistOfProduct);

    }

    @FXML
    void pendingTransactionButtonHandler(ActionEvent event)throws IOException{
        FXMLLoader goToPendingTransaction = new FXMLLoader(Main.class.getResource("transaction.fxml"));

        Scene scenePendingTransaction = new Scene(goToPendingTransaction.load(),700,600);
        Stage currentStage = (Stage)pendingTransactionButton.getScene().getWindow();
        currentStage.setScene(scenePendingTransaction);


    }

    @FXML
    void productDetailsListButtonHandler(ActionEvent event)throws IOException{
        FXMLLoader goToProductDetailsList = new FXMLLoader(Main.class.getResource("productDetailsList.fxml"));

        Scene sceneProductDetailsList = new Scene(goToProductDetailsList.load(),700,600);
        Stage currentStage = (Stage)productDetailsListButton.getScene().getWindow();
        currentStage.setScene(sceneProductDetailsList);

    }

    @FXML
    void homeButtonHandler(ActionEvent event)throws IOException{

            FXMLLoader goToReceptionist = new FXMLLoader(Main.class.getResource("receptionist.fxml"));

            Scene sceneReceptionist = new Scene(goToReceptionist.load(),700,600);
            Stage currentStage = (Stage)homeButton.getScene().getWindow();
            currentStage.setScene(sceneReceptionist);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
