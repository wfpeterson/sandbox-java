package com.kinetix.sandbox.java.ssl.example;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class SimpleSSLContext {

    public static void main(String[] args) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, KeyManagementException {

        String keyPassphrase = "password";

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("c:\\sslkey\\exampledomain.jks"), keyPassphrase.toCharArray());

        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, null).build();

        CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
        HttpResponse response = (HttpResponse) httpClient.execute(new HttpGet("https://example.com"));

    }
}
