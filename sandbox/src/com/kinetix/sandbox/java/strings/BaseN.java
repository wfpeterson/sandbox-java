package com.kinetix.sandbox.java.strings;

public class BaseN{

    final static public int FOUR_BIT = 4;
    final static public int FIVE_BIT = 5;
    final static public int SIX_BIT = 6;
    final static public int BASE64PAYLOADTYPE = 0;
    final static public int INSTANCEUIDPAYLOADTYPE = 1;
    final static public int DOCUMENTREFPAYLOADTYPE = 2;
    final static public int CAMMANDIMAGEDISKPAYLOADTYPE = 3;
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


    public static String encode(String dataStr, int bit, int payloadType){

        //convert String to char[]
        char dataChar[] = new char[dataStr.length()];
        dataStr.getChars(0, dataStr.length()-1, dataChar, 0);
        byte[] decodedByteValues = new byte[dataChar.length];
        //int length = baseValues.length;
        float tmpRet1 = 0, tmpRet2 = 0;
        StringBuilder encodedResult = new StringBuilder();
        int pad = 0;

        if(bit == 6){
            tmpRet1 = 3.0f;
            tmpRet2 = 4.0f;
        }
        else if(bit == 5){
            tmpRet1 = 5.0f;
            tmpRet2 = 8.0f;
        }

        //new code
        if(bit == FOUR_BIT){
            /**
             byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
             char str[] = new char[length];
             txt.getChars(0, length, str, 0);
             int chaVal = 0;
             String temp;
             String strBinary = new String("");
             for(int i = 0; i < length; i++){
             temp = Integer.toBinaryString(toValue(str[i]));
             while(temp.length() % bit != 0){
             temp = "0" + temp;
             }
             strBinary = strBinary + temp;
             }
             while(strBinary.length() % 8 != 0){
             strBinary = strBinary + "0";
             }
             Integer tempInt = new Integer(0);
             for(int i = 0; i < strBinary.length(); i = i + 8){
             tempInt = tempInt.valueOf(strBinary.substring(i, i + 8), 2);
             encoded[i / 8] = tempInt.byteValue();
             }
             **/
        }
        else if(bit == FIVE_BIT)
        {
            /**
             byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
             char str[] = new char[length];
             txt.getChars(0, length, str, 0);
             int chaVal = 0;
             String temp;
             String strBinary = new String("");
             for(int i = 0; i < length; i++){
             temp = Integer.toBinaryString(toValue(str[i]));
             while(temp.length() % bit != 0){
             temp = "0" + temp;
             }
             strBinary = strBinary + temp;
             }
             while(strBinary.length() % 8 != 0){
             strBinary = strBinary + "0";
             }
             Integer tempInt = new Integer(0);
             for(int i = 0; i < strBinary.length(); i = i + 8){
             tempInt = tempInt.valueOf(strBinary.substring(i, i + 8), 2);
             encoded[i / 8] = tempInt.byteValue();
             }
             **/

            /*****************New Code ***********/
            byte convertedData[] = new byte[(int) (tmpRet1 * Math.ceil(decodedByteValues.length / tmpRet2))];
            //int encodedCount = 0;

            //convert char[] to byte[] using Base16 decoding
            for (int j = 0; j < dataChar.length; j++) {
                byte b = 0;
                if (toCAMMAndImageDiskTypeDecode[dataChar[j]] != -1) {
                    b = (byte) (toCAMMAndImageDiskTypeDecode[dataChar[j]] & 0x001F);
                    decodedByteValues[j] = b;
                }
            }

            long c = 0L;
            //int decodedByteLoopCount = -1;
            //pull 5 bytes to populate a single long integer and convert to 5 chars for char[].  Use Base64 encoding.
            for(int i=0, m=0; i<decodedByteValues.length || m<convertedData.length; i+=5, m+=8){
                pad = 0;
                c = 0L;
                for(int j=0; j<5; j++){
                    if(i + j < decodedByteValues.length){
                        c |= (decodedByteValues[i + j] & 0xFF);
                        if(j < 4){
                            c = c << 8;
                        }
                    }
                    else{
                        pad++;
                    }
                }
                /**
                if(i + 2 < decodedByteValues.length){
                    c |= (decodedByteValues[i + 2] & 0xFF);
                    c = c << 8;
                }
                else{
                    pad++;
                }
                if(i + 3 < decodedByteValues.length){
                    c |= (decodedByteValues[i + 3] & 0xFF);
                    c = c << 8;
                }
                else{
                    pad++;
                }
                if(i + 4 < decodedByteValues.length){
                    c |= (decodedByteValues[i + 4] & 0xFF);
                }
                else{
                    pad++;
                }
                **/

                //
                for(int n=0; n<8; n++){
                    long d = (c & 0x00F800000000L);
                    d >>= 35;
                    convertedData[n + m] = (byte) d;
                    c = c << 5;
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
            for(int j = 0; j < convertedData.length-pad ; j++){
                encodedResult.append(base64Encode[convertedData[j]]);
            }
            for(int j = 0; j < pad; j++){
                encodedResult.append(PADDING);
            }
        }

        else if(bit == SIX_BIT){
            byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(decodedByteValues.length / tmpRet2))];
            /**
            char str[] = new char[length];
            txt.getChars(0, length, str, 0);
            int chaVal = 0;
            String temp;
            String strBinary = new String("");

            for(int i = 0; i < length; i++){
                temp = Integer.toBinaryString(toValue(str[i]));
                while(temp.length() % bit != 0){
                    temp = "0" + temp;
                }
                strBinary = strBinary + temp;
            }
            while(strBinary.length() % 8 != 0){
                strBinary = strBinary + "0";
            }
            Integer tempInt = new Integer(0);
            for(int i = 0; i < strBinary.length(); i = i + 8){
                tempInt = tempInt.valueOf(strBinary.substring(i, i + 8), 2);
                encoded[i / 8] = tempInt.byteValue();
            }
             **/

            /*****************New Code ***********/
            for(int i = 0; i < decodedByteValues.length; i += 3){
                pad = 0;
                int b = ((decodedByteValues[i] & 0xFF) << 16) & 0xFFFFFF;
                if(i + 1 < decodedByteValues.length){
                    b |= (decodedByteValues[i + 1] & 0xFF) << 8;
                }
                else{
                    pad++;
                }
                if(i + 2 < decodedByteValues.length){
                    b |= (decodedByteValues[i + 2] & 0xFF);
                }
                else{
                    pad++;
                }
                for(int j = 0; j < 4 - pad; j++){
                    int c = (b & 0xFC0000) >> 18;
                    encodedResult.append(base64Encode[c]);
                    b <<= 6;
                }
            }
            for(int j = 0; j < pad; j++){
                encodedResult.append(PADDING);
            }
        }
        return encodedResult.toString();
    }


    public static String decode(String dataStr, int bit, int payloadType){
        String strTemp = new String("");
        String strBinary = new String("");
        String strText = new String("");
        Integer tempInt =new Integer(0);
        int intTemp=0;
        byte[] encodedData = dataStr.getBytes();
        int length = encodedData.length;
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        String decodedStr = null;


        if(bit == FOUR_BIT){
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
        }
        else if(bit == FIVE_BIT){
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

        }
        else if(bit == SIX_BIT){
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
                strText = strText + toChar(tempInt.intValue());
            }
             **/

            /*************** New Code  ************************/
            for (int i = 0; i < length; ) {
                int b = 0;
                if (base64Decode[encodedData[i]] != -1) {
                    b = (base64Decode[encodedData[i]] & 0xFF) << 18;
                }
                // skip unknown characters
                else {
                    i++;
                    continue;
                }

                int num = 0;
                if (i + 1 < length && base64Decode[encodedData[i + 1]] != -1) {
                    b = b | ((base64Decode[encodedData[i + 1]] & 0xFF) << 12);
                    num++;
                }
                if (i + 2 < length && base64Decode[encodedData[i + 2]] != -1) {
                    b = b | ((base64Decode[encodedData[i + 2]] & 0xFF) << 6);
                    num++;
                }
                if (i + 3 < length && base64Decode[encodedData[i + 3]] != -1) {
                    b = b | (base64Decode[encodedData[i + 3]] & 0xFF);
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

        }
        return decodedStr;
    }



    public static void main(String[] args){

        //String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}";
        String encodedResult = BaseN.encode(testStr, FIVE_BIT, 3);
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());

        //String decodedStr = BaseN.decode(encodedResult, FIVE_BIT, 0);
        //System.out.println("Decoded result: " + decodedStr);
        //System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
