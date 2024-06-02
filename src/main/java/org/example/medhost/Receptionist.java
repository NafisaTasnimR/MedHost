package org.example.medhost;

import java.util.ArrayList;

public class Receptionist {
    private String name;
    private String age;
    private String uid;
    private String PhoneNumber;
    private String password;

    public Receptionist(){}
    public Receptionist(String name,String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void passwordChecker(String password)throws InsufficientPasswordCharacterException{

        if(password.length() < 4){
            throw new InsufficientPasswordCharacterException("Character number less than 4");
        }
    }
}
