package com.kinetix.sandbox.java.strings;

public class B32Encoder{

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

    private static final char[] toCAMMAndImageDiskTypeEncode = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
            'a', 'b', 'c', 'd', 'e', 'f', 'M', 'V',
            '-', '|', '{', '}'};

    private static final byte[] toCAMMAndImageDiskTypeDecode = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 24, -1, -1,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1,
            -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, 22, -1, -1,
            -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 16, 17, 18, 19, 20, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 25, 27, -1, -1,
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
        long dBinary = 0L;

        //out
        float tmpRet1 = 5.0F, tmpRet2 = 8.0F;
        int outLength = (int) (tmpRet1 * Math.ceil((inLength / tmpRet2)));
        byte encoded[]=new byte[outLength];
        StringBuilder buffer = new StringBuilder(outLength);
        int pad = 0;
        String result = null;
        //byte convertedData[] = new byte[inLength];


        //convert char[] to byte[] using Base16 decoding
        for (int j = 0; j < inLength; j++) {
            cBinary = 0;
            if (toCAMMAndImageDiskTypeDecode[charArray[j]] != -1) {
                cBinary = (byte) (toCAMMAndImageDiskTypeDecode[charArray[j]] & 0x001F);
                dataBytes[j] = cBinary;
            }
        }

        //pull 6 bytes to populate a single long integer and convert to 5 chars for char[] using Base64 encoding.
        for(int i=0; i<dataBytes.length ; i+=6){
            pad = 0;
            dBinary = 0L;
            /**
            for(int j=0; j<5; j++){
                if(i + j < dataBytes.length){
                    dBinary |= (dataBytes[i + j] & 0xFF);
                    if(j < 4){
                        dBinary = dBinary << 8;
                    }
                }
                else{
                    pad++;
                }
            }
            for(int k=0; k<5-pad; k++){
                eBinary = 0L;
                eBinary = (dBinary & 0x00F800000000L);
                eBinary >>= 35;
                //convertedData[k] = (byte) d;
                encodedResult.append(base64Encode[(byte) eBinary]);
                dBinary = dBinary << 5;
            }**/

            dBinary = (((dataBytes[i + 0] & 0x1F) << 27) & 0xFFFFFFFFL);
            //dBinary = dBinary << 3;
            if (i + 1 < dataBytes.length) {
                dBinary |= ((dataBytes[i + 1] & 0x1F) << 22);
                //dBinary = dBinary << 8;
            } else {
                pad++;
            }
            if (i + 2 < dataBytes.length){
                dBinary |= ((dataBytes[i + 2] & 0x1F) << 17);
                //dBinary = dBinary << 8;
            } else {
                pad++;
            }
            if (i + 3 < dataBytes.length){
                dBinary |= ((dataBytes[i + 3] & 0x1F) << 12);
                //dBinary = dBinary << 8;
            } else {
                pad++;
            }
            if (i + 4 < dataBytes.length){
                dBinary |= ((dataBytes[i + 4] & 0x1F) << 7);
                //dBinary = dBinary << 8;
            } else {
                pad++;
            }
            if (i + 5 < dataBytes.length){
                dBinary |= ((dataBytes[i + 5] & 0x1F) << 2);
                //dBinary = dBinary << 8;
            } else {
                pad++;
            }

            for(int j=0; j<5-pad; j++) {
                byte eBinary = (byte) ((dBinary & 0xFC000000L) >> 26);
                dBinary = dBinary << 6;
                buffer.append(base64Encode[eBinary]);
            }
        }
        //byte d = (byte) ((c & 0x0F0000) >> 14);
        //byte e = (byte) ((c & 0x000C00) >> 10);
        //d |= e;
        //encoded[encodedCount] = d;
        //encodedCount++;
        //byte f = (byte) ((c & 0x000300) >> 4);
        //byte g = (byte) (c & 0x00000F);
        //f |= g;
        //encoded[encodedCount] = f;
        //encodedCount++;
        //convert encoded byte[] to char[] using Base64 table
        //char[] charArray = new char[encoded.length];
        for(int k=0; k<pad; k++){
            buffer.append(PADDING);
        }
        //convert char[] to string
        result = buffer.toString();
        return result;
    }


    public static String decode(String dataStr) {
        String strTemp = new String("");
        String strBinary = new String("");
        String strText = new String("");
        Integer tempInt =new Integer(0);

        //in
        int inLength = dataStr.length();
        byte[] encoded = dataStr.getBytes();
        int cBinary = 0;
        int dBinary = 0;

        //out
        float tmpRet1 = 5.0F, tmpRet2 = 8.0F;
        int outLength = (int) (tmpRet2*Math.ceil(inLength/tmpRet1));
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream(outLength);
        String decodedStr = null;

        for (int i = 0; i < encoded.length; i += 5) {
            dBinary = 0;
            //int num = 0;
            if (base64Decode[encoded[i + 0]] != -1) {
                dBinary = ((base64Decode[encoded[i + 0]] & 0x3F) << 32);
                //num++;
            }
            if (i + 1 < encoded.length && base64Decode[encoded[i + 1]] != -1) {
                dBinary |=  ((base64Decode[encoded[i + 1]] & 0x3F) << 24);
                //num++;
            }
            if (i + 2 < encoded.length && base64Decode[encoded[i + 2]] != -1) {
                dBinary |=  ((base64Decode[encoded[i + 2]] & 0x3F) << 16);
                //num++;
            }
            if (i + 3 < encoded.length && base64Decode[encoded[i + 3]] != -1) {
                dBinary |=  ((base64Decode[encoded[i + 3]] & 0x3F) << 8);
                //num++;
            }
            if (i + 4 < encoded.length && base64Decode[encoded[i + 4]] != -1) {
                dBinary |=  ((base64Decode[encoded[i + 4]] & 0x3F));
                //num++;
            }

            cBinary = ((dBinary & 0x3C00) >> 10);
            buffer.write((char) cBinary);
            cBinary = ((dBinary & 0x0300) >> 6);
            cBinary |= ((dBinary & 0x30) >> 4);
            buffer.write((char) cBinary);
            cBinary = ((dBinary & 0x0F));
            buffer.write((char)cBinary);
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
        String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}";
        String encodedResult = B32Encoder.encode(testStr);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());


        String decodedStr = B32Encoder.decode(encodedResult);
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}