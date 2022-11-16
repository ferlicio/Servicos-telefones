package com.Servicos.Services.Exceptions;

public class DataIntegrityViolationException  extends RuntimeException{

    public DataIntegrityViolationException(String msg){
        super(msg);
    }
}
