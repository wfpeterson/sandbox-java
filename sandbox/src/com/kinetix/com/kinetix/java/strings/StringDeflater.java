package com.kinetix.java.strings;

import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class StringDeflater{

        public StringDeflater(){
        }

        public void inflateDeflateString(){
                String outputString = null;
                try{
                        // Encode a String into bytes
                        String inputString = "1.22.564456777888875.333333.98977888.1.5.4.7.9.2.2.33.54677.11";
                        byte[] input = inputString.getBytes("UTF-8");

                        // Compress the bytes
                        byte[] output = new byte[100];
                        Deflater compresser = new Deflater();
                        compresser.setInput(input);
                        compresser.finish();
                        int compressedDataLength = compresser.deflate(output);
                        compresser.end();

                        String outTemp = new String(output, 0, compressedDataLength, "UTF-8");
                        System.out.println("deflated: "+  outTemp);

                        // Decompress the bytes
                        Inflater decompresser = new Inflater();
                        decompresser.setInput(output, 0, compressedDataLength);
                        byte[] result = new byte[100];
                        int resultLength = decompresser.inflate(result);
                        decompresser.end();

                        // Decode the bytes into a String
                        outputString = new String(result, 0, resultLength, "UTF-8");
                        System.out.println("inflated: "+outputString);
                }
                catch(java.io.UnsupportedEncodingException ex){
                        System.out.println("Exception: "+ex.getLocalizedMessage());
                }
                catch(java.util.zip.DataFormatException ex){
                        System.out.println("Exception: "+ex.getLocalizedMessage());
                }
        }

        public static void main(String[] args){

                StringDeflater compressor = new StringDeflater();
                compressor.inflateDeflateString();

        }

}
