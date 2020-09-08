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
                        String inputString = "CM|2|1.26.564456725807975.314859.98972835.1.5.4.7.9.2.2.33.54673.128";
                        byte[] input = inputString.getBytes("UTF-8");

                        // Compress the bytes
                        byte[] output = new byte[input.length];
                        Deflater compresser = new Deflater();
                        compresser.setInput(input);
                        compresser.finish();
                        int compressedDataLength = compresser.deflate(output);
                        compresser.end();

                        //String outTemp = new String(output, 0, compressedDataLength, "UTF-8");
                        byte[] intermediateOut = new byte[compressedDataLength];
                        for(int i=0; i<compressedDataLength; i++){
                                intermediateOut[i] = output[i];
                        }

                        String encodedStr = new String(java.util.Base64.getEncoder().encode(intermediateOut));
                        System.out.println("Deflated Encoded String:" + encodedStr);

                        // Decompress the bytes
                        Inflater decompresser = new Inflater();
                        byte[] decodedStr = java.util.Base64.getDecoder().decode(encodedStr);
                        decompresser.setInput(decodedStr, 0, compressedDataLength);
                        byte[] result = new byte[120];
                        int resultLength = decompresser.inflate(result);
                        decompresser.end();

                        // Decode the bytes into a String
                        outputString = new String(result, 0, resultLength, "UTF-8");
                        System.out.println("inflated: "+outputString);
                }
                catch(java.io.UnsupportedEncodingException ex){
                        System.out.println("Encoding Exception: "+ex.getLocalizedMessage());
                }
                catch(java.util.zip.DataFormatException ex){
                        System.out.println("Data Format Exception: "+ex.getLocalizedMessage());
                }
        }

        public static void main(String[] args){

                StringDeflater compressor = new StringDeflater();
                compressor.inflateDeflateString();

        }

}
