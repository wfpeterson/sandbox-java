package com.kinetix.sandbox.java.strings;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class Base64Merge {

    final static public int FOUR_BIT = 4;
    final static public int SIX_BIT = 6;
    final static public int FIVE_BIT = 5;

    private static char[] base64Encodetbl = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '~', '_'};

    private static char[] toInstanceUIDTypeChartbl = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'V', 'A', 'C', 'M', '.', '|'};

    private static byte[] toInstanceUIDTypeValuetbl = {
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


    private static byte[] base64Decodetbl = {
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

    public static String encode(String dataStr, int bit) {
        int length = dataStr.length();
        float tmpRet1 = 0, tmpRet2 = 0;
        if (bit == 4) {
            tmpRet1 = 2.0f;
            tmpRet2 = 3.0f;
        } else if (bit == 5) {
            tmpRet1 = 5.0f;
            tmpRet2 = 6.0f;
        } else if (bit == 6) {
            tmpRet1 = 1.0f;
            tmpRet2 = 1.0f;
        }

        //convert String to char[]
        char str[] = new char[length];
        dataStr.getChars(0, length, str, 0);

        byte[] baseValues = new byte[length];
        String result = null;
        //check bit depth
        if (bit == 4) {
            //convert char[] to byte[] using Base16 decoding
            for (int j = 0; j < str.length; j++) {
                byte b = 0;
                if (toInstanceUIDTypeValuetbl[str[j]] != -1) {
                    b = (byte) (toInstanceUIDTypeValuetbl[str[j]] & 0x000F);
                    baseValues[j] = b;
                }
            }
            byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
            int pad = 0;
            int encodedCount = 0;
            //pull 3 bytes to populate a single integer and convert to 2 chars for char[].  Use Base64 encoding.
            for (int i = 0; i < baseValues.length; i += 3) {
                int b = ((baseValues[i] & 0x0F) << 16) & 0xFFFFFF;
                if (i + 1 < baseValues.length) {
                    b |= (baseValues[i + 1] & 0x0F) << 8;
                } else {
                    pad++;
                }
                if (i + 2 < baseValues.length) {
                    b |= (baseValues[i + 2] & 0x0F);
                } else {
                    pad++;
                }
                byte c = (byte) ((b & 0x0F0000) >> 14);
                byte d = (byte) ((b & 0x000C00) >> 10);
                c |= d;
                encoded[encodedCount] = c;
                encodedCount++;
                byte e = (byte) ((b & 0x000300) >> 4);
                byte f = (byte) (b & 0x00000F);
                e |= f;
                encoded[encodedCount] = e;
                encodedCount++;
            }
            //convert encoded byte[] to char[] using Base64 table
            char[] charArray = new char[encoded.length];
            for (int j = 0; j < encoded.length; j++) {
                charArray[j] = base64Encodetbl[encoded[j]];
            }
            //convert char[] to string
            result = new String(charArray);
        }
        return result;
    }


    public static String decode(String data, int bit) {
        float tmpRet1 = 0, tmpRet2 = 0;
        if (bit == 4) {
            tmpRet1 = 2.0f;
            tmpRet2 = 3.0f;
        } else if (bit == 5) {
            tmpRet1 = 5.0f;
            tmpRet2 = 6.0f;
        } else if (bit == 6) {
            tmpRet1 = 1.0f;
            tmpRet2 = 1.0f;
        }

        //convert string to char[]
        char[] charArray = new char[data.length()];
        data.getChars(0, data.length(), charArray, 0);

        //convert char[] to encoded byte[] using Base64 table
        byte[] decoded = new byte[charArray.length];
        int baseValuesLength = (int) (tmpRet2 * Math.ceil(charArray.length/ tmpRet1));
        for(int j=0; j<charArray.length; j++){
            decoded[j] = base64Decodetbl[charArray[j]];
        }

        //pull 2 bytes from encoded byte[] and merge them into a single integer.
        byte[] baseValues = new byte[baseValuesLength];
        int decodedCount = 0;
        for (int i = 0; i < decoded.length; i+=2) {
            int b = 0;
            byte c, d, e, f = 0;

            c = (byte) ((decoded[i] & 0xFC) >> 2);
            d = (byte) ((decoded[i] & 0x03) << 2);
            e = (byte) ((decoded[i+1] & 0x0F));
            f = (byte) ((decoded[i+1] & 0x30) >> 4);
            d |= f;

            //convert 3 bytes in single integer to 8bits and push each 8bit byte into byte[]
            baseValues[decodedCount] = (byte) toInstanceUIDTypeChartbl[c];
            baseValues[decodedCount + 1] = (byte) toInstanceUIDTypeChartbl[d];
            baseValues[decodedCount + 2] = (byte) toInstanceUIDTypeChartbl[e];
            decodedCount += 3;
        }
        String result = null;
        try {
            result = new String(baseValues, 0, baseValues.length, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args){
        /**
        String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        String encodedResult = Base64Merge.encode(testStr, FOUR_BIT);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());
        **/

        String testStr = "zfLx4uVG41J5EgNkOY5AWWgSNOU24uXk4eHiPjTpCHMhhG";

        String decodedStr = Base64Merge.decode(testStr, FOUR_BIT);
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
