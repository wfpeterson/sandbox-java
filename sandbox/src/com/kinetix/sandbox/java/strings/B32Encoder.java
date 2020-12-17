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
        char[] charArray = new char[inLength];
        dataStr.getChars(0, inLength, charArray, 0);
        byte bBinary = 0;
        long cBinary = 0L, dBinary = 0L;

        //out
        float tmpRet1 = 5.0F, tmpRet2 = 8.0F;
        //byte encoded[]=new byte[(int)(tmpRet1*Math.ceil(inLength/tmpRet2))];
        int pad = 0;
        StringBuilder encodedResult = new StringBuilder((int)(tmpRet1*Math.ceil(inLength/tmpRet2)));
        //String result = null;
        byte convertedData[] = new byte[inLength];


        //convert char[] to byte[] using Base16 decoding
        for (int j = 0; j < charArray.length; j++) {
            bBinary = 0;
            if (toCAMMAndImageDiskTypeDecode[charArray[j]] != -1) {
                bBinary = (byte) (toCAMMAndImageDiskTypeDecode[charArray[j]] & 0x001F);
                convertedData[j] = bBinary;
            }
        }

        //pull 5 (8-bit) bytes to populate a single long integer and convert to 5 chars for char[].  Use Base64 encoding.
        for(int i=0; i<convertedData.length ; i += 8){
            pad = 0;
            cBinary = 0L;
            for(int j=0; j<8; j++){
                if(i + j < convertedData.length){
                    cBinary |= (convertedData[i + j] & 0xFF);
                    if(j < 4){
                        cBinary = cBinary << 8;
                    }
                }
                else{
                    pad++;
                }
            }
            for(int k=0; k<5-pad; k++){
                dBinary = 0L;
                dBinary = (cBinary & 0x00F800000000L);
                dBinary >>= 35;
                //convertedData[k] = (byte) d;
                encodedResult.append(base64Encode[(byte) dBinary]);
                cBinary = cBinary << 5;
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
        for(int m = 0; m < pad; m++){
            encodedResult.append(PADDING);
        }
        return encodedResult.toString();
    }


    public static String decode(String dataStr) {
        String strTemp = new String("");
        String strBinary = new String("");
        String strText = new String("");
        Integer tempInt =new Integer(0);
        int intTemp=0;
        byte[] encodedData = dataStr.getBytes();
        int length = encodedData.length;
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        String decodedStr = null;

        /**
         for(int i = 0; i < encodedData.length; i++){
         if(encodedData[i] < 0){
         intTemp = (int) encodedData[i] + 256;
         }
         else
         intTemp = (int) encodedData[i];
         strTemp = Integer.toBinaryString(intTemp);
         while(strTemp.length() % 8 != 0){
         strTemp = "0" + strTemp;
         }
         strBinary = strBinary + strTemp;
         }
         for(int i = 0; i < strBinary.length(); i = i + bit){
         tempInt = tempInt.valueOf(strBinary.substring(i, i + bit), 2);
         //strText = strText + toChar(tempInt.intValue());
         }
         **/

        /******************** New Code *****************************/
        for (int i = 0; i < length; ) {
            int b = 0;
            if (toCAMMAndImageDiskTypeDecode[encodedData[i]] != -1) {
                b = (toCAMMAndImageDiskTypeDecode[encodedData[i]] & 0xFF) << 18;
            }
            // skip unknown characters
            else {
                i++;
                continue;
            }

            int num = 0;
            if (i + 1 < length && toCAMMAndImageDiskTypeDecode[encodedData[i + 1]] != -1) {
                b = b | ((toCAMMAndImageDiskTypeDecode[encodedData[i + 1]] & 0xFF) << 12);
                num++;
            }
            if (i + 2 < length && toCAMMAndImageDiskTypeDecode[encodedData[i + 2]] != -1) {
                b = b | ((toCAMMAndImageDiskTypeDecode[encodedData[i + 2]] & 0xFF) << 6);
                num++;
            }
            if (i + 3 < length && toCAMMAndImageDiskTypeDecode[encodedData[i + 3]] != -1) {
                b = b | (toCAMMAndImageDiskTypeDecode[encodedData[i + 3]] & 0xFF);
                num++;
            }

            while (num > 0) {
                int c = (b & 0xFF0000) >> 16;
                buffer.write((char) c);
                b <<= 8;
                num--;
            }
            i += 4;
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
