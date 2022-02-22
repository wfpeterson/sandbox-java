package com.kinetix.sandbox.java.concurrency.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutStream {

    public static void main(String[] args){
        try {
            FileOutputStream outputStream = new FileOutputStream("example2.txt", true);
            char H = 'H';
            outputStream.write((char)H);
            String string = "Hello OutputStream";
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
