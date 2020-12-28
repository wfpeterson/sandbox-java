package com.kinetix.sandbox.java.strings;

public class B16Encoder{

    final static public char PADDING = '$';
    final static public float sourceCount = 3.0F, encodedCount = 2.0F;

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

    private static final char[] toInstanceUIDTypeEncode = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'V', 'A', 'C', 'M', '.', '|'};

    private static final byte[] toInstanceUIDTypeDecode = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1,
            -1, 11, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1,
            -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private static final char[] toDocumentRefTypeEncode = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'X', 'R', '.', '|', '-', '_'};

    private static final byte[] toDocumentRefTypeDecode = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, 12, -1,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, 11, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, 15,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1,
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
        byte[] dataBytes = dataStr.getBytes();
        char[] charArray = new char[inLength];
        dataStr.getChars(0, inLength, charArray, 0);
        byte cBinary = 0;
        int dBinary = 0;

        //out
        int outLength = (int) ((encodedCount * Math.ceil(inLength/sourceCount)));   // - (inLength % sourceCount));
        int temp1 = (int) (inLength % sourceCount);
        int temp2 = (int) (inLength % encodedCount);

        System.out.println("calculated encoding length: "+outLength);
        StringBuilder buffer = new StringBuilder(outLength);
        int pad = 0;


        //convert char[] to byte[] using Base8 decoding
        for (int j = 0; j < inLength; j++) {
            cBinary = 0;
            if (toInstanceUIDTypeDecode[charArray[j]] != -1) {
                cBinary = (byte) (toInstanceUIDTypeDecode[charArray[j]] & 0x000F);
                dataBytes[j] = cBinary;
            }
        }
        //pull 3 bytes to populate a single integer and convert to 2 chars for char[].
        for (int i = 0; i < dataBytes.length; i += ((int) sourceCount)) {
            dBinary = 0;
            pad = 0;
            if(i + 0 < dataBytes.length){
                dBinary = (((dataBytes[i + 0] & 0x0F) << 12)); //& 0xFFFF);
            }
            //else{
            //    pad++;
            //}
            if (i + 1 < dataBytes.length) {
                dBinary |= ((dataBytes[i + 1] & 0x0F) << 8);
            }
            else {
                pad++;
            }
            if (i + 2 < dataBytes.length){
                dBinary |= ((dataBytes[i + 2] & 0x0F) << 4);
            }
            else {
                pad++;
            }
            for(int j=0; j<((int) encodedCount)-pad; j++) {
                byte eBinary = (byte) ((dBinary & 0xFC00) >> 10);
                dBinary = dBinary << 6;
                buffer.append(base64Encode[eBinary]);

            }
        }
        for(int k=0; k<pad; k++){
            buffer.append(PADDING);
        }

        //convert char[] to string
        return buffer.toString();
    }


    public static String decode(String dataStr) {
        //in
        int inLength = dataStr.length();
        byte[] encoded = dataStr.getBytes();
        int cBinary = 0;
        int dBinary = 0;
        int padded = 0;

        //out
        int outLength = (int) ((sourceCount *Math.ceil(inLength/encodedCount)));        // - (inLength % encodedCount));
        int temp3 = (int) (outLength % sourceCount);
        int temp4 = (int) (outLength % encodedCount);

        System.out.println("calculated decoding length: " + outLength);
        int num = 0;
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream(outLength);
        String decodedStr = null;

        for (int i = 0; i < encoded.length; i += ((int) encodedCount)) {
            dBinary = 0;
            num = 0;
            padded = 0;
            if (base64Decode[encoded[i + 0]] != -1){
                dBinary = ((base64Decode[encoded[i + 0]] & 0x3F) << 10);
            }
            //else{
            //    padded++;
            //}
            if (i + 1 < encoded.length && base64Decode[encoded[i + 1]] != -1){
                dBinary |= ((base64Decode[encoded[i + 1]] & 0x3F) << 4);
            }
            else{
                padded++;
            }
            while ((num < ((int)sourceCount) - padded)) {
                cBinary = (int) ((dBinary & 0xF000) >> 12);
                buffer.write((char) cBinary);
                dBinary <<= 4;
                num++;
            }
        }
        byte[] decodedBytes = buffer.toByteArray();
        char[] outputChars = new char[decodedBytes.length];
        for(int j=0; j<decodedBytes.length; j++){
            outputChars[j] = toInstanceUIDTypeEncode[decodedBytes[j]];
        }
        decodedStr = new String(outputChars);

        return decodedStr;
    }


    public static void main(String[] args){

        //String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.908732184";
        //String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        System.out.println("Initial string: "+ testStr);
        System.out.println("Initial string length: "+testStr.length());

        String encodedResult = B16Encoder.encode(testStr);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());


        String decodedStr = B16Encoder.decode(encodedResult);
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
