package com.kinetix.sandbox.java.strings;

public class B16Encoder{

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
        byte cBinary = 0;
        int dBinary = 0;

        //out
        float tmpRet1 = 1.0F, tmpRet2 = 2.0F;
        int outLength = (int) (tmpRet1 * Math.ceil(inLength / tmpRet2));
        byte encoded[] = new byte[outLength];
        //char[] charArray = new char[outLength];
        //dataStr.getChars(0, inLength, charArray, 0);

        StringBuilder buffer = new StringBuilder(outLength);
        int pad = 0;
        String result = null;


        //convert char[] to byte[] using Base8 decoding
        for (int j = 0; j < inLength; j++) {
            cBinary = 0;
            if (toInstanceUIDTypeDecode[dataBytes[j]] != -1) {
                cBinary = (byte) (toInstanceUIDTypeDecode[dataBytes[j]] & 0x00FF);
                dataBytes[j] = cBinary;
            }
        }
        //byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(inLength / tmpRet2))];
        pad = 0;
        //int encodedCount = 0;
        //pull 3 bytes to populate a single integer and convert to 2 chars for char[].
        for (int i = 0; i < dataBytes.length; i += 3) {
            dBinary = 0;
            dBinary = (((dataBytes[i + 0] & 0x3F) << 18) & 0xFFFFFF);
            if (i + 1 < dataBytes.length) {
                dBinary |= ((dataBytes[i + 1] & 0x3F) << 14);
            } else {
                pad++;
            }
            if (i + 2 < dataBytes.length){
                dBinary |= ((dataBytes[i + 2] & 0x3F) << 10);
            } else {
                pad++;
            }
            for(int j=0; j<2-pad; j+=2) {
                byte eBinary = (byte) ((dBinary & 0xFF0000) >> 16);
                buffer.append(base64Encode[eBinary]);

                byte fBinary = (byte) ((dBinary & 0xFF00) >> 10);
                buffer.append(base64Encode[fBinary]);

            }
        }
        for(int k=0; k<pad; k++){
            buffer.append(PADDING);
        }
        //convert char[] to string
        result = buffer.toString();
        return result;
    }


    public static String decode(String dataStr) {
        //in
        int inLength = dataStr.length();
        byte[] encoded = dataStr.getBytes();
        int cBinary = 0;
        int dBinary = 0;

        //out
        float tmpRet1 = 4.0F, tmpRet2 = 3.0F;
        int outLength = (int) (tmpRet2*Math.ceil(inLength/tmpRet1));
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream(outLength);
        String decodedStr = null;

        for (int i = 0; i < encoded.length; i += 2) {
            dBinary = 0;
            int num = 0;
            if (base64Decode[encoded[i + 0]] != -1) {
                dBinary = ((base64Decode[encoded[i + 0]] & 0x3F) << 8);
                //num++;
            }
            //skip unknown characters
            //else {
            //    i++;
            //    continue;
            //}
            if (i + 1 < encoded.length && base64Decode[encoded[i + 1]] != -1) {
                dBinary |=  ((base64Decode[encoded[i + 1]] & 0x3F));
                //num++;
            }

            cBinary = ((dBinary & 0x3C00) >> 10);
            buffer.write((char) cBinary);
            cBinary = ((dBinary & 0x0300) >> 6);
            cBinary |= ((dBinary & 0x30) >> 4);
            buffer.write((char) cBinary);
            cBinary = ((dBinary & 0x0F));
            buffer.write((char)cBinary);



            //while (num > 0) {
            //    int c = (dBinary & 0xFF0000) >> 16;
            //    buffer.write((char) cBinary);
            //    dBinary <<= 8;
            //    num--;
            //}
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

        String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        //String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}";
        String encodedResult = B16Encoder.encode(testStr);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());


        String decodedStr = B16Encoder.decode(encodedResult);
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
