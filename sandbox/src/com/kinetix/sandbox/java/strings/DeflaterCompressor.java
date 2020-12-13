package com.kinetix.sandbox.java.strings;

import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class DeflaterCompressor{

    public DeflaterCompressor(){

    }

    public static void main(String[] args)throws Exception { // main method
        // Encode a String into bytes
        String inputString = "CM|2|1.26.564456725807975.314859.98972835.1.5.4.7.9.2.2.33.54673.128";
        byte[] input = inputString.getBytes("UTF-8");

        DeflaterCompressor deflaterCompressor = new DeflaterCompressor();
        // Compress the bytes
        byte[] output1 = new byte[input.length];
        Deflater compresser = new Deflater();
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output1);
        compresser.end();

        byte[] intermediateOut = new byte[compressedDataLength];
        for(int i=0; i<compressedDataLength; i++){
            intermediateOut[i] = output1[i];
        }
        String str = new String(Base64.getEncoder().encode(intermediateOut));
        System.out.println("Deflated Encoded String:" + str);
        //String compressedStr = new String(output1, 0, compressedDataLength, "UTF-8");
        //System.out.println("Deflated String:" + compressedStr);

        byte[] output2 = Base64.getDecoder().decode(str);

        // Decompress the bytes
        Inflater decompresser = new Inflater();
        decompresser.setInput(output2);
        byte[] result = str.getBytes();
        int resultLength = decompresser.inflate(result);
        decompresser.end();

        // Decode the bytes into a String
        String outputString = new String(result, 0, resultLength, "UTF-8");
        System.out.println("Inflated String:" + outputString);

    }
}
