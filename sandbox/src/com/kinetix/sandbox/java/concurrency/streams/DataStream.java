package com.kinetix.sandbox.java.concurrency.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

    public static void main(String[] args){

        File file = new File("example3.txt");
        if(file.exists()) {
            System.out.println("File already exist"+file.getName());
        }
        else{
            try {
                if(file.createNewFile()){
                    System.out.println("file was created");
                    System.out.println("file path: "+file.getAbsolutePath());
                }
                else{
                    System.out.println("cannot create file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file.getName()));
            DataInputStream in = new DataInputStream(new FileInputStream(file.getName()));
            out.writeInt(72);
            out.writeDouble(678.00);
            out.writeFloat(123.45F);

            int var1 = in .readInt();
            double var2 = in.readDouble();
            float var3 = in.readFloat();

            System.out.println("integer: "+var1);
            System.out.println("double: "+var2);
            System.out.println("float: "+var3);

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
