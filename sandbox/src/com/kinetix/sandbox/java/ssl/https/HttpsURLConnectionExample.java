package com.kinetix.sandbox.java.ssl.https;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpsURLConnectionExample {

    private HttpsURLConnection getHttpsClient(String url) throws Exception{

        //Security section START
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager(){
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers(){
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType){

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType){

                }
            }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        //security section END

        HttpsURLConnection client = (HttpsURLConnection) new URL(url).openConnection();
        client.setRequestProperty("User-Agent", "Mozilla/5.0");
        return client;
    }

    private void testGet() throws Exception{
        System.out.println("*** Test HTTPS GET request ***");

        String url = "https://www.onlinefreeconverter.com/random-words?n=15";
        HttpsURLConnection client = getHttpsClient(url);
        int responseCode = client.getResponseCode();
        System.out.println("GET request to URL: "+url);
        System.out.println("Response Code: "+client.getResponseCode());

        try(BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
            System.out.println(response.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        HttpsURLConnectionExample obj = new HttpsURLConnectionExample();
        obj.testGet();
    }
}
