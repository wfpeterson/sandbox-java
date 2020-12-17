package com.kinetix.sandbox.java.strings;

public class B64Encoder{

    final static public char PADDING = '=';

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


    public static String encode(String dataStr) {

        //in
        int inLength = dataStr.length();
        char[] charArray = new char[inLength];
        dataStr.getChars(0, inLength, charArray, 0);
        int cBinary = 0, dBinary = 0;

        //out
        float tmpRet1 = 3.0F, tmpRet2 = 4.0F;
        //byte encoded[]=new byte[(int)(tmpRet1*Math.ceil(inLength/tmpRet2))];
        int outLength = (int) (tmpRet1*Math.ceil(inLength/tmpRet2));
        StringBuilder buffer = new StringBuilder(outLength);
        int pad = 0;

        for(int i = 0; i < outLength; i += 3){
            cBinary = 0;

            if(i + 0 < ){
                cBinary = ((charArray[i + 0] & 0xFF) << 16) & 0xFFFFFF;
            }
            else{
                pad++;
            }
            if(i + 1 < buffer.length()){
                cBinary|= ((charArray[i + 1] & 0xFF) << 8);
            }
            else{
                pad++;
            }
            if(i + 2 < buffer.length()){
                cBinary |= ((charArray[i + 2] & 0xFF));
            }
            else{
                pad++;
            }
            //if(i + 3 < charArray.length){
            //    cBinary |= (charArray[i + 3] & 0xFF);
            //}
            //else{
            //    pad++;
            //}
            for(int j=0; j<4-pad; j++){
                dBinary = 0;
                dBinary = (cBinary & 0xFC0000) >> 18;
                buffer.append(base64Encode[dBinary]);
                cBinary <<= 6;
            }
        }
        for(int n=0; n<pad; n++){
            buffer.append(PADDING);
        }
        return buffer.toString();
    }



    public static String decode(String dataStr) {

        //in
        int inLength = dataStr.length();
        byte[] encoded = dataStr.getBytes();
        int cBinary = 0, dBinary = 0;
        
        //out
        float tmpRet1 = 3.0F, tmpRet2 = 4.0F;
        int outLength = (int) (tmpRet2*Math.ceil(inLength/tmpRet1));

        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        String decodedStr = null;

        for (int i = 0; i < outLength; i += 4) {
            dBinary = 0;
            int num = 0;

            if (i + 0 < encoded.length && base64Decode[encoded[i + 0]] != -1) {
                dBinary = (base64Decode[encoded[i + 0]] & 0xFF) << 18;
                num++;
            }
            if (i + 1 < encoded.length && base64Decode[encoded[i + 1]] != -1) {
                dBinary = dBinary | ((base64Decode[encoded[i + 1]] & 0xFF) << 12);
                num++;
            }
            if (i + 2 < encoded.length && base64Decode[encoded[i + 2]] != -1) {
                dBinary = dBinary | ((base64Decode[encoded[i + 2]] & 0xFF) << 6);
                num++;
            }
            if (i + 3 < encoded.length && base64Decode[encoded[i + 3]] != -1) {
                dBinary = dBinary | (base64Decode[encoded[i + 3]] & 0xFF);
                num++;
            }
            // skip unknown characters      //WFP-deal with this later.
            //else {
            //    i++;
            //    continue;
            //}

            while (num > 0) {
                cBinary = (dBinary & 0xFF0000) >> 18;
                buffer.write((char) cBinary);
                dBinary <<= 8;
                num--;
            }
            //i += 4;
        }
        byte[] decodedBytes = buffer.toByteArray();
        try {
            decodedStr = new String(decodedBytes, 0, decodedBytes.length,
                    "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedStr;
    }


    public static void main(String[] args){

        //String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        String testStr = "This is a test of Base64 encoding/decoding";
        //String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}";
        String encodedResult = B64Encoder.encode(testStr);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());


        String decodedStr = B64Encoder.decode(encodedResult);
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
