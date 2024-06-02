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

public class ProductDetailsListController {

    @FXML
    private Text currentStockText;

    @FXML
    private Text docDateText;

    @FXML
    private Text expireDateText;

    @FXML
    private Button homeButton;

    @FXML
    private Text itemNoText;

    @FXML
    private Button logOutButton;

    @FXML
    private Text productNameText;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text supplierText;

    @FXML
    void homeButtonHandler(ActionEvent event)throws IOException {
        FXMLLoader goToInventoryLoader = new FXMLLoader(Main.class.getResource("inventory.fxml"));

        Scene sceneReceptionist = new Scene(goToInventoryLoader.load(),700,600);
        Stage currentStage = (Stage)homeButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);


    }


    public boolean searchValueAndShow(){
        boolean validity = false;

        List<Product> productList = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new FileReader("ProductListData.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 6){
                    String itemNo = data[0];
                    String productName = data[1];
                    String supplier = data[2];
                    String currentStock = data[3];
                    String docDate = data[4];
                    String expireDate = data[5];

                    Product product = new Product(itemNo,productName,supplier,currentStock,docDate,expireDate);
                    productList.add(product);
                }
                else {
                    System.out.println("Error");
                }
            }


            for (Product product:productList){
                if (Objects.equals(product.getProductName(), searchTextField.getText()) || Objects.equals(product.getItemNo(),searchTextField.getText())){
                    validity = true;
                    itemNoText.setText(product.getItemNo());
                    productNameText.setText(product.getProductName());
                    supplierText.setText(product.getSupplier());
                    currentStockText.setText(product.getCurrentStock());
                    docDateText.setText(product.getDocDate());
                    expireDateText.setText(product.getExpireDate());

                    itemNoText.setVisible(validity);
                    productNameText.setVisible(validity);
                    supplierText.setVisible(validity);
                    currentStockText.setVisible(validity);
                    docDateText.setVisible(validity);
                    expireDateText.setVisible(validity);

                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return validity;

    }

    public void logOutButtonHandler(ActionEvent actionEvent)throws IOException {
        FXMLLoader goToHelloLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));

        Scene sceneReceptionist = new Scene(goToHelloLoader.load(),700,600);
        Stage currentStage = (Stage)logOutButton.getScene().getWindow();
        currentStage.setScene(sceneReceptionist);
    }

    public void searchButtonActionHandler(ActionEvent actionEvent) {
        this.searchValueAndShow();
    }
}
