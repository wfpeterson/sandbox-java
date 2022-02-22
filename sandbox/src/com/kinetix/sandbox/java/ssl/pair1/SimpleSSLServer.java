package com.kinetix.sandbox.java.ssl.pair1;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSSLServer {

    int port = 8443;

    public SimpleSSLServer() throws IOException {
    }

    public void startSSLListener() throws IOException {

        ServerSocketFactory factory = SSLServerSocketFactory.getDefault();
        ServerSocket listener = null;
        try {
            listener = factory.createServerSocket(port);
            SSLServerSocket sslListener = (SSLServerSocket) listener;
            sslListener.setNeedClientAuth(true);
            sslListener.setEnabledCipherSuites(new String[]{"TLS_DHE_DSS_WITH_AES_256_CBC_SHA256"});
            sslListener.setEnabledProtocols(new String[]{"TLSv1.2"});
            while (true) {
                try {
                    System.out.println("Listening...");
                    Socket socket = sslListener.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello World");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            //listener.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleSSLServer sslServer = new SimpleSSLServer();
        sslServer.startSSLListener();
    }

}
