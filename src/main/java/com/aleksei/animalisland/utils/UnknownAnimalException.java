package com.aleksei.animalisland.utils;

public class UnknownAnimalException extends RuntimeException {
    public UnknownAnimalException(String message, Throwable cause){
        super(message, cause);
    }
    public UnknownAnimalException(String message){
        super(message);
    }
}
