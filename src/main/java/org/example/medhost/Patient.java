package org.example.medhost;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Patient {
    private String name;
    private String age;
    private String gender;
    private String upid;
    private String dateOfBirth;
    private String phoneNumber;
    private String emergencyNumber;
    private String email;
    private String emergencyEmail;
    private String address;
    private String registrationDate;

    private String assignedDoctor;

    private String currentStatus;

    private String dischareDate;
    private String roomNo;
    private String wardNo;




    public Patient(){}

    public Patient(String name,String age,String gender,String contact,String email){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = contact;
        this.email = email;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public Patient(String name,String upid) {
        this.name = name;
        this.upid = upid;
    }
    public Patient(String name,String age,String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public Patient(String name,String age,String gender,String upid) {
        this.name = name;
        this.upid = upid;
        this.age = age;
        this.gender = gender;
    }

    public String getAssignedDoctor() {
        return assignedDoctor;
    }


    public Patient(String name, String age, String gender, LocalDate dateOfBirth, LocalDate registrationDate, String phoneNumber, String emergencyNumber, String email, String emergencyEmail, String address) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.upid = this.provideUniqueID();
            this.dateOfBirth = this.convertDateToSpecificString(dateOfBirth);
            this.registrationDate = this.convertDateToSpecificString(registrationDate);
            this.phoneNumber = phoneNumber;
            this.emergencyNumber = emergencyNumber;
            this.email = email;
            this.emergencyEmail = emergencyEmail;
            this.address = address;
            this.assignedDoctor = "dr.M";
            this.currentStatus = "Admitted";
    }

    public String getWardNo() {
        return wardNo;
    }

    public void setWardNo(String wardNo) {
        this.wardNo = wardNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Patient(String name, String age, String gender, String upid, String dateOfBirth,
                   String registrationDate, String phoneNumber, String emergencyNumber,
                   String email, String emergencyEmail, String address, String currentStatus, String roomNo, String wardNo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.upid = upid;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;

        this.phoneNumber = phoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.email = email;
        this.emergencyEmail = emergencyEmail;
        this.address = address;

        this.assignedDoctor = "dr.M";
        this.currentStatus = currentStatus;
        this.roomNo = roomNo;
        this.wardNo = wardNo;
    }


    public String getAddress() {
        return address;
    }

    public String getEmergencyEmail() {
        return emergencyEmail;
    }

    public String getEmail() {
        return email;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUpid() {
        return upid;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setDischareDate(String dischareDate) {
        this.dischareDate = dischareDate;
    }

    public String getDischareDate(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        dischareDate = formattedString;
        return dischareDate;
    }
    public String convertDateToSpecificString(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }
    public String provideUniqueID(){
        String uniqueID = "ab"+String.valueOf(new Random().nextInt(2000));
        return uniqueID;
    }



}
