package com.kinetix.sandbox.java.strings;

public class B64Encoder{

    final static public char PADDING = '=';
    final static public float sourceCount = 3.0F, encodedCount = 4.0F;

    private static final char[] base64Encode = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '~', '_'};

    private static final byte[] base64Decode = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, 62, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};


    public static String encode(String dataStr) throws com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException{

        if(dataStr == null){
            throw new com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException("String parameter is null.");
        }

        //in
        int inLength = dataStr.length();
        char[] charArray = new char[inLength];
        dataStr.getChars(0, inLength, charArray, 0);
        int cBinary = 0, dBinary = 0;

        //out
        int outLength = (int) (encodedCount *Math.ceil(inLength/ sourceCount));
        StringBuilder buffer = new StringBuilder(outLength);
        int pad = 0;


        for(int i = 0; i < inLength; i += ((int) sourceCount)){
            cBinary = 0;

            if(i + 0 < charArray.length){
                cBinary = ((charArray[i + 0] & 0xFF) << 16); //& 0xFFFFFF;
            }
            else{
                pad++;
            }
            if(i + 1 < charArray.length){
                cBinary|= ((charArray[i + 1] & 0xFF) << 8);
            }
            else{
                pad++;
            }
            if(i + 2 < charArray.length){
                cBinary |= ((charArray[i + 2] & 0xFF));
            }
            else{
                pad++;
            }
            for(int j=0; j<((int) encodedCount)-pad; j++){
                dBinary = 0;
                dBinary = (cBinary & 0xFC0000) >> 18;
                buffer.append(base64Encode[dBinary]);
                cBinary <<= 6;
            }
        }
        //for(int n=0; n<pad; n++){
        //    buffer.append(PADDING);
        //}
        return buffer.toString();
    }


    public static String decode(String dataStr) throws com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException{

        if(dataStr == null){
            throw new com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException("String parameter is null.");
        }

        //in
        int inLength = dataStr.length();
        byte[] encoded = dataStr.getBytes();
        int cBinary = 0;
        int dBinary = 0;
        
        //out
        int outLength = (int) (sourceCount *Math.ceil(inLength/ encodedCount));
        int num = 0;

        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream(outLength);
        String decodedStr = null;
        int lastDecodedArrayItem = 0;

        for (int i = 0; i < encoded.length; i += ((int) encodedCount)) {
            dBinary = 0;
            num = 0;
            if (base64Decode[encoded[i + 0]] != -1) {
                dBinary = (base64Decode[encoded[i + 0]] & 0x3F) << 18;
            }
            // skip unknown characters
            //else {
            //    i++;
            //    continue;
            //}
            if (i + 1 < encoded.length && base64Decode[encoded[i + 1]] != -1) {
                dBinary |= ((base64Decode[encoded[i + 1]] & 0x3F) << 12);
                num++;
            }
            if (i + 2 < encoded.length && base64Decode[encoded[i + 2]] != -1) {
                dBinary |= ((base64Decode[encoded[i + 2]] & 0x3F) << 6);
                num++;
            }
            if (i + 3 < encoded.length && base64Decode[encoded[i + 3]] != -1) {
                dBinary |= ((base64Decode[encoded[i + 3]] & 0x3F)) ;
                num++;
            }
            while (num > 0) {
                cBinary = ((dBinary & 0xFF0000) >> 16);
                buffer.write((char) cBinary);
                dBinary <<= 8;
                num--;
                lastDecodedArrayItem++;
            }
        }

        byte[] decodedBytes = buffer.toByteArray();
        char[] outputChars = new char[lastDecodedArrayItem];
        for(int j=0; j<lastDecodedArrayItem; j++){
            outputChars[j] = (char) decodedBytes[j];
        }
        decodedStr = new String(outputChars);

        return decodedStr;
    }


    public static void main(String[] args){

        //String testStr = "This is a test of Base64 encoding/decoding";
        //String testStr = "This is a test of Base64 encoding/decodi";
        //String testStr = "This is a test of Base64 encoding/decodi";
        String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.908732180";

        String encodedResult = null;
        try{
            encodedResult = com.kinetix.sandbox.java.strings.B64Encoder.encode(testStr);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException e){
            e.printStackTrace();
        }
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());

        String decodedStr = null;
        try{
            decodedStr = com.kinetix.sandbox.java.strings.B64Encoder.decode(encodedResult);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException e){
            e.printStackTrace();
        }
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
