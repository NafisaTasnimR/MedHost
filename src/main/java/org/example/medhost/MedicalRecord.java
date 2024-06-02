package org.example.medhost;

public class MedicalRecord {
    String disease;
    String prescribedMedicine;
    String testReport;

    Patient patient;

    public MedicalRecord(){}

    public MedicalRecord(Patient patient,String disease, String prescribedMedicine, String testReport){
        this.patient = patient;
        this.disease = disease;
        this.testReport = testReport;
        this.prescribedMedicine = prescribedMedicine;

    }
    public String getTestReport() {
        return testReport;
    }

    public void setTestReport(String testReport) {
        this.testReport = testReport;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(String prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

}
