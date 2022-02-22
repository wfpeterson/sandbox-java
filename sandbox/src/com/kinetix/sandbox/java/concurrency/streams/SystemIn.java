package com.kinetix.sandbox.java.concurrency.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn {

    public static void main(String[] args){

        System.out.println("Please enter the port number: ");

        InputStreamReader in = new InputStreamReader(System.in);

        BufferedReader reader = new BufferedReader(in);

        boolean isValid = false;
        int port = 0;

        while(!isValid){
            String portString = null;
            try {
                portString = reader.readLine();
                port = Integer.parseInt(portString);
                System.out.println("Port is accepted!");
                isValid = true;


            } catch (IOException e) {
                System.out.println("Please insert a number!");
                System.out.println("Please enter the port number: ");
            }
        }

        System.out.println("Please enter Server IP Address: ");

        String ipAddress = "";

        try {
            ipAddress = reader.readLine();

        } catch (IOException e) {
            System.out.println("Cannot read the ip address!");
        }

        System.out.println("");
        System.out.println("_________________________");
        System.out.println("");

        System.out.println("Trying to connect to IP: " +ipAddress+ " on port: "+port+"...");

    }
}
