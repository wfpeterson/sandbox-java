package com.kinetix.sandbox.java.concurrency.streams;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrtStream {

    public static void main(String[] args){

        try {
            PrintStream out = new PrintStream("example8.txt");

            int var1 = 10;

            out.println("The value of var1 is: "+var1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
