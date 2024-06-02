package org.example.medhost;

public class Doctor {
    private String name;
    private String age;
    private String uid;
    private String specialization;
    private String password;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor(){}
    public Doctor(String name,String password) {
        this.name = name;
        this.password = password;
    }
    public Doctor(String name,String age,String uid,String specialization,String password) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.uid = uid;
        this.specialization = specialization;
    }
    public Doctor(String name,String specialization,String uid){
        this.name = name;
        this.specialization = specialization;
        this.uid = uid;
    }
    public void passwordChecker(String password)throws InsufficientPasswordCharacterException{

        if(password.length() < 4){
            throw new InsufficientPasswordCharacterException("Character number less than 4");
        }
    }

}
