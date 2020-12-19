package com.kinetix.sandbox.java.strings;

import java.io.UnsupportedEncodingException;

public class Base64Merge {

    final static public int FOUR_BIT = 4;
    final static public int FIVE_BIT = 5;
    final static public int SIX_BIT = 6;
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

    private static final char[] toInstanceUIDTypeChar = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'V', 'A', 'C', 'M', '.', '|'};

    private static final byte[] toInstanceUIDTypeValue = {
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

    private static final char[] toDocumentRefTypeChar = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'X', 'R', '.', '|', '-', '_'};

    private static final byte[] toDocumentRefTypeValue = {
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

    private static final char[] toCAMMAndImageDiskTypeChar = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
        'a', 'b', 'c', 'd', 'e', 'f', 'M', 'V',
        '-', '|', '{', '}'};

    private static final byte[] toCAMMAndImageDiskTypeValue = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, -1,
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1,
        -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, 22, -1, -1,
        -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, 16, 17, 18, 19, 20, 21, -1, -1, -1, -1, 26, -1, 27, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
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
        char[] charValues = new char[length];
        dataStr.getChars(0, length, charValues, 0);
        byte[] baseValues = dataStr.getBytes();
        //int length = baseValues.length;
        float tmpRet1 = 0, tmpRet2 = 0;
        StringBuilder buffer = new StringBuilder();

        if (bit == 4) {
            tmpRet1 = 2.0f;
            tmpRet2 = 3.0f;
        } else if (bit == 5) {
            tmpRet1 = 8.0f;
            tmpRet2 = 5.0f;
        } else if (bit == 6) {
            tmpRet1 = 4.0f;
            tmpRet2 = 3.0f;
        }

        //convert String to char[]
        //char str[] = new char[length];


        String result = null;
        //check bit depth
        if (bit == 4) {
            //convert char[] to byte[] using Base8 decoding
            for (int j = 0; j < length; j++) {
                byte b = 0;
                if (toInstanceUIDTypeValue[charValues[j]] != -1) {
                    b = (byte) (toInstanceUIDTypeValue[charValues[j]] & 0x000F);
                    baseValues[j] = b;
                }
            }
            byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
            int pad = 0;
            int encodedCount = 0;
            //pull 3 bytes to populate a single integer and convert to 2 chars for char[].
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
                charArray[j] = base64Encode[encoded[j]];
            }
            //convert char[] to string
            result = new String(charArray);
        }
        else if (bit == 5) {
            //convert char[] to byte[] using Base16 decoding
            //for (int j = 0; j < str.length; j++) {
            //    byte b = 0;
            //    if (toCAMMAndImageDiskTypeValue[str[j]] != -1) {
            //        b = (byte) (toCAMMAndImageDiskTypeValue[str[j]] & 0x001F);
            //        baseValues[j] = b;
            //    }
            //}
            byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
            int pad = 0;
            int encodedCount = 0;
            //pull 5 bytes to populate a single long integer and convert to 5 chars for char[].  Use Base64 encoding.
            for (int i = 0; i < baseValues.length; i += 5) {
                long c = (long)((baseValues[i] & 0x1F) << 40);
                if (i + 1 < baseValues.length) {
                    c |= (long)((baseValues[i + 1] & 0x1F) << 32);
                } else {
                    pad++;
                }
                if (i + 2 < baseValues.length) {
                    c |= (long)((baseValues[i + 2] & 0x1F) << 24);
                } else {
                    pad++;
                }
                if (i + 3 < baseValues.length) {
                    c |= (long)((baseValues[i + 3] & 0x1F) << 16);
                } else {
                    pad++;
                }
                if (i + 4 < baseValues.length) {
                    c |= (long)((baseValues[i + 4] & 0x1F) << 8);
                } else {
                    pad++;
                }
                if (i + 5 < baseValues.length) {
                    c |= (long)((baseValues[i + 5] & 0x1F));
                } else {
                    pad++;
                }
                //if (i + 6 < baseValues.length) {
                //    b |= ((baseValues[i + 6] & 0x1F));
                //} else {
                //    pad++;
                //}

                encoded[encodedCount] = (byte) (c);
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //encoded[encodedCount] = c;
                //encodedCount++;

                //byte c = (byte) ((b & 0x0F0000) >> 14);
                //byte d = (byte) ((b & 0x000C00) >> 10);
                //c |= d;
                //encoded[encodedCount] = c;
                //encodedCount++;
                //byte e = (byte) ((b & 0x000300) >> 4);
                //byte f = (byte) (b & 0x00000F);
                //e |= f;
                //encoded[encodedCount] = e;
                //encodedCount++;
            }
            //convert encoded byte[] to char[] using Base64 table
            char[] charArray = new char[encoded.length];
            for (int j = 0; j < encoded.length; j++) {
                charArray[j] = base64Encode[encoded[j]];
            }

            //convert char[] to string
            result = new String(charArray);
        }
        else if (bit == 6){
            //convert char[] to byte[]
            //for (int j = 0; j < str.length; j++) {
            //    byte b = 0;
            //    if (base64Decode[str[j]] != -1) {
            //        b = (byte) (base64Decode[str[j]] & 0x000F);
            //        baseValues[j] = b;
            //    }
            //}

            //StringBuilder buffer = new StringBuilder();
            int pad = 0;
            for(int i = 0; i < baseValues.length; i += 3){
                int b = ((baseValues[i] & 0xFF) << 16) & 0xFFFFFF;
                if(i + 1 < baseValues.length){
                    b |= (baseValues[i + 1] & 0xFF) << 8;
                }
                else{
                    pad++;
                }
                if(i + 2 < baseValues.length){
                    b |= (baseValues[i + 2] & 0xFF);
                }
                else{
                    pad++;
                }

                for(int j = 0; j < 4 - pad; j++){
                    int c = (b & 0xFC0000) >> 18;
                    buffer.append(base64Encode[c]);
                    b <<= 6;
                }
            }
            for(int j = 0; j < pad; j++){
                buffer.append("=");
            }

        }
            /**
            byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
            int pad = 0;
            int encodedCount = 0;
            char[] charArray = new char[encoded.length];
            //pull 3 bytes to populate a single integer and convert to 2 chars for char[].
            // Use Base64 encoding.
            for (int i = 0; i < baseValues.length; i += tmpRet2) {
                int b = ((baseValues[i] & 0xFF) << 16) & 0xFFFFFF;
                if (i + 1 < baseValues.length) {
                    b |= (baseValues[i + 1] & 0xFF) << 8;
                } else {
                    pad++;
                }
                if (i + 2 < baseValues.length) {
                    b |= (baseValues[i + 2] & 0xFF);
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

                //convert encoded byte[] to char[] using Base64 table
                //for (int j = 0; j < 4 - pad; j++) {
                //  int c = (b & 0xFC0000) >> 18;
                //    charArray[j] = base64Encode[c];
                //    b <<= 6;
                //    encodedCount = j;
                //}

            }
            //convert encoded byte[] to char[] using Base64 table
            //for (int j = 0; j < encoded.length; j++) {
            //    charArray[j] = base64Encode[encoded[j]];
            //
            //}

            //for (int k = 0; k < pad; k++) {
            //    charArray[++encodedCount]= '=';
            //}
            //convert char[] to string
            result = new String(charArray);

        }
        **/
        return buffer.toString();
        //return result;
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
            tmpRet1 = 4.0f;
            tmpRet2 = 3.0f;
        }

        //convert string to char[]
        char[] charArray = new char[data.length()];
        data.getChars(0, data.length(), charArray, 0);
        String decodedStr = null;

        if(bit == 4){

        }
        else if(bit == 5){

        }
        else if(bit == 6){

            /**
            //convert char[] to encoded byte[] using Base64 table
            byte[] decoded = new byte[charArray.length];
            int baseValuesLength = (int) (tmpRet2 * Math.ceil(charArray.length / tmpRet1));
            for(int j = 0; j < charArray.length; j++){
                decoded[j] = base64Decode[charArray[j]];
            }

            //pull 2 bytes from encoded byte[] and merge them into a single integer.
            byte[] baseValues = new byte[baseValuesLength];
            int decodedCount = 0;
            for(int i = 0; i < decoded.length; i += 2){
                int b = 0;
                byte c, d, e, f = 0;

                c = (byte) ((decoded[i] & 0xFC) >> 2);
                d = (byte) ((decoded[i] & 0x03) << 2);
                e = (byte) ((decoded[i + 1] & 0x0F));
                f = (byte) ((decoded[i + 1] & 0x30) >> 4);
                d |= f;

                //convert 3 bytes in single integer to 8bits and push each 8bit byte into byte[]
                baseValues[decodedCount] = (byte) toInstanceUIDTypeChar[c];
                baseValues[decodedCount + 1] = (byte) toInstanceUIDTypeChar[d];
                baseValues[decodedCount + 2] = (byte) toInstanceUIDTypeChar[e];
                decodedCount += 3;
            }

             }
        String result = null;
        try {
            result = new String(baseValues, 0, baseValues.length, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
        **/
            byte[] bytes = data.getBytes();
            java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
            //byte[] buffer = new byte[bytes.length];
            for (int i = 0; i < bytes.length; ) {
                int b = 0;
                if (base64Decode[bytes[i]] != -1) {
                    b = (base64Decode[bytes[i]] & 0xFF) << 18;
                }
                // skip unknown characters
                else {
                    i++;
                    continue;
                }

                int num = 0;
                if (i + 1 < bytes.length && base64Decode[bytes[i + 1]] != -1) {
                    b = b | ((base64Decode[bytes[i + 1]] & 0xFF) << 12);
                    num++;
                }
                if (i + 2 < bytes.length && base64Decode[bytes[i + 2]] != -1) {
                    b = b | ((base64Decode[bytes[i + 2]] & 0xFF) << 6);
                    num++;
                }
                if (i + 3 < bytes.length && base64Decode[bytes[i + 3]] != -1) {
                    b = b | (base64Decode[bytes[i + 3]] & 0xFF);
                    num++;
                }

                while (num > 0) {
                    int c = (b & 0xFF0000) >> 16;
                    buffer.write((char) c);
                    //buffer[i] = (byte) c;
                    b <<= 8;
                    num--;
                }
                i += 4;
            }
            byte[] decodedBytes = buffer.toByteArray();
            try {
                decodedStr = new String(decodedBytes, 0, decodedBytes.length,
                        "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return decodedStr;
        //return buffer.toByteArray();
    }


    public static void main(String[] args){

        //String testStr = "This is a test of Base64 encoding/decoding";
        String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}";
        String encodedResult = Base64Merge.encode(testStr, FOUR_BIT);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());


        String decodedStr = Base64Merge.decode(encodedResult, FOUR_BIT);
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
