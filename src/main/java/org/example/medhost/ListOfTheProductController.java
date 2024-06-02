package org.example.medhost;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListOfTheProductController implements Initializable{

    @FXML
    private TableColumn<Product, String> expireDateColumn;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<Product, String> itemNoColumn;

    @FXML
    private Button logOutButton;

    @FXML
    private Label productListLabel;
    @FXML
    private TableView<Product> productTable;


    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, String> snColumn;

    @FXML
    void homeButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToInventoryLoader = new FXMLLoader(Main.class.getResource("inventory.fxml"));

        Scene sceneReceptionist = new Scene(goToInventoryLoader.load(),700,600);
        Stage currentStage = (Stage)homeButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);

    }

    @FXML
    void logOutButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);
    }

   private ObservableList<Product> tableProductList = FXCollections.observableArrayList(this.addDataToTable());

   private List<Product> addDataToTable() {
        List<Product> productList = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("ProductListData.txt"))){
            String line;
            int i=0;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 6){
                    String itemNo = data[0];
                    String productName = data[1];
                    String expireDate = data[5];


                    Product product = new Product(Integer.toString(i++),itemNo,productName,expireDate);
                    productList.add(product);
                }
                else {
                    System.out.println("Error");
                }
            }


        }catch (IOException e){
            e.printStackTrace();
        }
        return productList;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        snColumn.setCellValueFactory(new PropertyValueFactory<>("SN"));
        itemNoColumn.setCellValueFactory(new PropertyValueFactory<>("TableItemNo"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("TableProductName"));
        expireDateColumn.setCellValueFactory(new PropertyValueFactory<>("TableExpireDate"));
        //this.addDataToTable(tableProductList);
        productTable.setItems(tableProductList);
    }
}
