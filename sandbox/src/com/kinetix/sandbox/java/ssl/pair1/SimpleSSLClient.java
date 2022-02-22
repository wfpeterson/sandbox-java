package com.kinetix.sandbox.java.ssl.pair1;

import javax.net.SocketFactory;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleSSLClient {

    String host = "localhost";
    int port = 8443;
    public SimpleSSLClient(){

    }

    public String runSSLClient() throws IOException {

        SocketFactory factory = SSLSocketFactory.getDefault();
        Socket connection = null;
        try {
            connection = factory.createSocket(host, port);
            ((SSLSocket) connection).setEnabledCipherSuites(new String[]{"TLS_DHE_DSS_WITH_AES_256_CBC_SHA256"});
            ((SSLSocket) connection).setEnabledProtocols(new String[]{"TLSv1.2"});

            SSLParameters sslParams = new SSLParameters();
            sslParams.setEndpointIdentificationAlgorithm("HTTPS");
            ((SSLSocket) connection).setSSLParameters(sslParams);

            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            return input.readLine();
        } finally {
            //connection.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleSSLClient sslClient = new SimpleSSLClient();
        String receivedOut = sslClient.runSSLClient();
        System.out.println(receivedOut);
        System.exit(0);
    }

}
