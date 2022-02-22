package com.kinetix.sandbox.java.concurrency.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CharacterStream {

    public static void main(String[] args){

        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("example5.txt"));
            InputStreamReader in = new InputStreamReader(new FileInputStream("example5.txt"));

            System.out.println(out.getEncoding());
            out.write("reading using InputStreamReader");

            //out.flush();
            //out.close();

            //out.write("another string");

            out.flush();
            out.close();

            int data = in.read();
            while(data != -1){
                System.out.print((char)data);
                data = in.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
