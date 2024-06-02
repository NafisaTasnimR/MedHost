package org.example.medhost;

public class InsufficientPasswordCharacterException extends Exception{
    public InsufficientPasswordCharacterException(String message){
        super(message);
    }
}
