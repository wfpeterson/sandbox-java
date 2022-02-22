package com.kinetix.sandbox.java.ssl.example.baeldung;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SimpleSSLSocket {


    public static void main(String[] args) throws Exception {
        String host = "50.19.115.98";
        Integer port = 344;

        SSLSocketFactory sslSocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslsocket;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            sslsocket = (SSLSocket) sslSocketfactory.createSocket(host, port);
            inputStream = sslsocket.getInputStream();
            outputStream = sslsocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        outputStream.write(1);
        while (inputStream.available() > 0) {
            System.out.println(inputStream.read());
        }
        System.out.println("Secured connection performed successfully");
    }
}

