package org.example.medhost;

import javafx.beans.property.SimpleStringProperty;

public class AdmittedPatient {

    private SimpleStringProperty no;
    private SimpleStringProperty upid;
    private SimpleStringProperty pName;
    private SimpleStringProperty roomNo;
    private SimpleStringProperty wardNo;
    private SimpleStringProperty assignedDoctor;
    private SimpleStringProperty payment;
    private SimpleStringProperty contactNo;

    public String getUpid() {
        return upid.get();
    }
    public void setUpid(String upid) {
        this.upid = new SimpleStringProperty(upid);
    }

    public String getPatientName() {
        return pName.get();
    }

    public void setPatientName(String pName) {
        this.pName = new SimpleStringProperty(pName);
    }

    public SimpleStringProperty noProperty() {
        return no;
    }

    public String getRoomNo() {
        return roomNo.get();
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = new SimpleStringProperty(roomNo);
    }

    public String getWardNo() {
        return wardNo.get();
    }
    public void setWardNo(String wardNo) {
        this.wardNo = new SimpleStringProperty(wardNo);
    }

    public String getAssignedDoctor() {
        return assignedDoctor.get();
    }
    public void setAssignedDoctor(String assignedDoctor) {
        this.assignedDoctor = new SimpleStringProperty(assignedDoctor);
    }

    public String getPayment() {
        return payment.get();
    }
    public void setPayment(String payment) {
        this.payment = new SimpleStringProperty(payment);
    }

    public String getContactNo() {
        return contactNo.get();
    }
    public void setContactNo(String contactNo) {
        this.contactNo = new SimpleStringProperty(contactNo);
    }

    public String getNo() {
        return no.get();
    }

    public void setNo(String no) {
        this.no = new SimpleStringProperty(no);
    }

    public AdmittedPatient(String no, String upid, String pName, String roomNo, String wardNo, String assignedDoctor, String payment, String contactNo) {
        this.no = new SimpleStringProperty(no);
        this.upid = new SimpleStringProperty(upid);
        this.pName = new SimpleStringProperty(pName);
        this.roomNo = new SimpleStringProperty(roomNo);
        this.wardNo = new SimpleStringProperty(wardNo);
        this.assignedDoctor = new SimpleStringProperty(assignedDoctor);
        this.payment = new SimpleStringProperty(payment);
        this.contactNo = new SimpleStringProperty(contactNo);

    }
}
