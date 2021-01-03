package com.kinetix.sandbox.java.exceptions;

public class URNPayloadBaseDecodingException
        extends Exception{

    public URNPayloadBaseDecodingException(){
    }

    public URNPayloadBaseDecodingException(String message){
        super(message);
    }

    public URNPayloadBaseDecodingException(String message, Throwable cause){
        super(message, cause);
    }

    public URNPayloadBaseDecodingException(Throwable cause){
        super(cause);
    }

    public URNPayloadBaseDecodingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
