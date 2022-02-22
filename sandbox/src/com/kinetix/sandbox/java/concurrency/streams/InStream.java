package com.kinetix.sandbox.java.concurrency.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InStream {

    public static void main(String[] args){
        try {
            FileInputStream inputStream = new FileInputStream("example1.txt");
            int data = inputStream.read();
            while(data != -1){
                System.out.print((char)data);
                data = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
