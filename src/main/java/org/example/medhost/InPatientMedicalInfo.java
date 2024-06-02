package org.example.medhost;

public class InPatientMedicalInfo extends Patient{
    int doctorsBill;
    int surgeryBill;
    int imagingBill;
    int totalCost;

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getImagingBill() {
        return imagingBill;
    }

    public void setImagingBill(int imagingBill) {
        this.imagingBill = imagingBill;
    }

    public int getSurgeryBill() {
        return surgeryBill;
    }

    public void setSurgeryBill(int surgeryBill) {
        this.surgeryBill = surgeryBill;
    }

    public int getDoctorsBill() {
        return doctorsBill;
    }

    public void setDoctorsBill(int doctorsBill) {
        this.doctorsBill = doctorsBill;
    }

    public InPatientMedicalInfo(String name, String age, String gender, String upid, int doctorsBill, int surgeryBill, int imagingBill, int totalCost) {
        super(name, age, gender, upid);
        this.doctorsBill = doctorsBill;
        this.surgeryBill = surgeryBill;
        this.imagingBill = imagingBill;
        this.totalCost = totalCost;

    }

}
