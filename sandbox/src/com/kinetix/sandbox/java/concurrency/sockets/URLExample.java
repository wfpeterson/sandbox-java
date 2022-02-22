package com.kinetix.sandbox.java.concurrency.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLExample {

    public static void main(String[] args){

        try {
            URL url = new URL("https://finance.yahoo.com/quote/ORCL?ltr=1");
            URLConnection myURL = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(myURL.getInputStream()));
            String inputLine;
            String pattern = "<span id=\\\"yfs_l84_orcl\\\">(.+?)</span>";
            Pattern r = Pattern.compile(pattern);
            while((inputLine = in.readLine()) != null){
                //System.out.println(inputLine);
                if(inputLine.contains("yfs_l84_orcl"))
                {
                    Matcher m = r.matcher(inputLine);
                    if(m.find()){
                        System.out.println(m.group(1));
                    }
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
