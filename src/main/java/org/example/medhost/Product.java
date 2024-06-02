package org.example.medhost;

import javafx.beans.property.SimpleStringProperty;

public class Product {
    String itemNo;
    String productName;
    String supplier;
    String currentStock;
    String docDate;
    String expireDate;

    private SimpleStringProperty SN;
    private SimpleStringProperty tableItemNo;
    private SimpleStringProperty tableProductName;
    private SimpleStringProperty tableExpireDate;

    public Product(String SN, String tableItemNo, String tableProductName, String ExpireDate) {
        this.SN = new SimpleStringProperty(SN);
        this.tableItemNo = new SimpleStringProperty(tableItemNo);
        this.tableProductName = new SimpleStringProperty(tableProductName);
        this.tableExpireDate = new SimpleStringProperty(ExpireDate);

    }


    public String getTableExpireDate() {
        return tableExpireDate.get();
    }

    public String getTableProductName() {
        return tableProductName.get();
    }

    public String getTableItemNo() {
        return tableItemNo.get();
    }
    public void setTableExpireDate(String tableExpireDate) {
        this.tableExpireDate = new SimpleStringProperty(tableExpireDate);
    }
    public void setTableProductName(String tableProductName) {
        this.tableProductName = new SimpleStringProperty(tableProductName);
    }
    public void setTableItemNo(String tableItemNo) {
        this.tableItemNo = new SimpleStringProperty(tableItemNo);
    }

    public String getSN() {
        return SN.get();
    }
    public void setSN(String SN) {
        this.SN = new SimpleStringProperty(SN);
    }


    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(String currentStock) {
        this.currentStock = currentStock;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String ItemNo) {
        this.itemNo = ItemNo;
    }

    public Product(){}

    public Product(String itemNo,String productName,
    String supplier, String currentStock, String docDate, String expireDate) {
        this.itemNo = itemNo;
        this.productName = productName;
        this.supplier = supplier;
        this.currentStock = currentStock;
        this.docDate = docDate;
        this.expireDate = expireDate;
    }

    public Product(String itemNo,String productName,String expireDate) {
        this.itemNo = itemNo;
        this.productName = productName;
        this.expireDate = expireDate;
    }
}
