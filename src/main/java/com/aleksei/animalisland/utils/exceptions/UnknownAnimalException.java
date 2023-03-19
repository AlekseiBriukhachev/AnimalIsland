package com.aleksei.animalisland.utils.exceptions;

public class UnknownAnimalException extends Exception {
    public UnknownAnimalException(String message){
        super(message);
    }
    public UnknownAnimalException(String message, Throwable e){
        super(message, e);
    }
    public UnknownAnimalException(Throwable e){
        super(e);
    }

}
