package org.example.medhost;

import javafx.beans.property.SimpleStringProperty;

public class ScheduledAppointment {
    String patientName;
    String date;
    String time;

    private SimpleStringProperty SN;
    private SimpleStringProperty tablePatientName;
    private SimpleStringProperty tableDate;
    private SimpleStringProperty tableTime;

    public String getTableTime() {
        return tableTime.get();
    }

    public void setTableTime(String tableTime) {
        this.tableTime = new SimpleStringProperty(tableTime);
    }

    public String getTableDate() {
        return tableDate.get();
    }

    public void setTableDate(String tableDate) {
        this.tableDate = new SimpleStringProperty(tableDate);
    }

    public String getSN() {
        return SN.get();
    }

    public void setSN(String SN) {
        this.SN = new SimpleStringProperty(SN);
    }

    public String getTablePatientName() {
        return tablePatientName.get();
    }

    public void setTablePatientName(String tablePatientName) {
        this.tablePatientName = new SimpleStringProperty(tablePatientName);
    }

    public ScheduledAppointment(String patientName, String date, String time) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
    }

    public ScheduledAppointment(String sn, String tablePatientName, String tableDate, String tableTime){
        this.SN = new SimpleStringProperty(sn);
        this.tablePatientName = new SimpleStringProperty(tablePatientName);
        this.tableDate = new SimpleStringProperty(tableDate);
        this.tableTime = new SimpleStringProperty(tableTime);

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
