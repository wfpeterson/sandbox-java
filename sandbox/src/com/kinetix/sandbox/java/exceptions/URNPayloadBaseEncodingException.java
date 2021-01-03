package com.kinetix.sandbox.java.exceptions;

public class URNPayloadBaseEncodingException
        extends Exception{

    public URNPayloadBaseEncodingException(){
    }

    public URNPayloadBaseEncodingException(String message){
        super(message);
    }

    public URNPayloadBaseEncodingException(String message, Throwable cause){
        super(message, cause);
    }

    public URNPayloadBaseEncodingException(Throwable cause){
        super(cause);
    }

    public URNPayloadBaseEncodingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
