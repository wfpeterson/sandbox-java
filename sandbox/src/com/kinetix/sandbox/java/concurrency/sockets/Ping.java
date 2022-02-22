package com.kinetix.sandbox.java.concurrency.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ping {

    public static void main(String[] args){

        try{

            String hostAddress = "192.168.0.123";
            InetAddress host = InetAddress.getByName(hostAddress);
            System.out.println(host.isReachable(1000));

            Process p = Runtime.getRuntime().exec("ping " +hostAddress);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String commandOutput = "";
            boolean isReachable = true;
            while((commandOutput = inputStream.readLine()) != null){
                System.out.println(commandOutput);
                if(commandOutput.contains("Request timed out.")){
                    isReachable = false;
                    break;
                }
            }

            if(isReachable){
                System.out.println("Host is reachable");
            }
            else{
                System.out.println("Host is not reachable");
            }

        }
        catch(Exception e){

        }

    }
}
