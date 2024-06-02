package org.example.medhost;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Appointment {
//    String patientName;
//    String doctorName;
//    String patientAge;
//    String patientGender;
//    String patientContact;
//    String patientEmail;
//    String doctorsSpecialization;
//    String doctorsUID;
    String time;
    String scheduledDate;
    Doctor doctor;
    Patient patient;

    public String getScheduledDate() {
        return scheduledDate;
    }

    public String getTime() {
        return time;
    }

    public Appointment(){}

    public Appointment(Patient patient,Doctor doctor,String time,LocalDate scheduledDate){
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.scheduledDate = convertDateToSpecificString(scheduledDate);
    }

    public void makeAppointment(List<Appointment> appointmentList){
        String filepath = "DoctorAppointmentData.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true))){
            for (Appointment appointment : appointmentList){
                writer.write("Patient's Information"+","+appointment.patient.getName() +","+
                        appointment.patient.getAge()+","+appointment.patient.getGender()+","+
                        appointment.patient.getPhoneNumber()+","+appointment.patient.getEmail()+","+"Doctor's Information"+","+
                        appointment.doctor.getName()+","+appointment.doctor.getSpecialization()+","+
                        appointment.doctor.getUid()+","+appointment.getTime()+","+appointment.getScheduledDate());
                writer.newLine();
            }

            System.out.println("data has been written to file");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String convertDateToSpecificString(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedString = localDate.format(formatter);
        return formattedString;
    }
}
