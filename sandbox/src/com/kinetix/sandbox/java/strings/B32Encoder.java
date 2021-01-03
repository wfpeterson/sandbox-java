package com.kinetix.sandbox.java.strings;

public class B32Encoder{

    final static public char PADDING = '=';
    final static public float sourceCount = 6.0F, encodedCount = 5.0F;

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

    public static String encode(String dataStr) throws com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException{

        if(dataStr == null){
            throw new com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException("String parameter is null.");
        }

        //in
        int inLength = dataStr.length();
        byte[] dataBytes = new byte[inLength];
        char[] charArray = new char[inLength];
        dataStr.getChars(0, inLength, charArray, 0);
        byte cBinary = 0;
        long dBinary = 0L;

        //out
        int outLength = (int) (encodedCount * Math.ceil((inLength/ sourceCount)));
        StringBuilder buffer = new StringBuilder(outLength);
        int pad = 0;

        //convert char[] to byte[] using Base16 decoding
        for (int j = 0; j < inLength; j++) {
            cBinary = 0;
            if (toCAMMAndImageDiskTypeDecode[charArray[j]] != -1) {
                cBinary = (byte) (toCAMMAndImageDiskTypeDecode[charArray[j]] & 0x001F);
                dataBytes[j] = cBinary;
            }
        }

        //pull 6 bytes to populate a single long integer and convert to 5 chars for char[] using Base64 encoding.
        for(int i=0; i<dataBytes.length ; i+=((int) sourceCount)){
            pad = 0;
            dBinary = 0L;
            dBinary = (((dataBytes[i + 0] & 0x1F) << 27)); //& 0xFFFFFFFFL);
            if (i + 1 < dataBytes.length) {
                dBinary |= ((dataBytes[i + 1] & 0x1F) << 22);
            }
            //else {
            //    pad++;
            //}
            if (i + 2 < dataBytes.length){
                dBinary |= ((dataBytes[i + 2] & 0x1F) << 17);
            }
            //else {
            //    pad++;
            //}
            if (i + 3 < dataBytes.length){
                dBinary |= ((dataBytes[i + 3] & 0x1F) << 12);
            } else {
                pad++;
            }
            if (i + 4 < dataBytes.length){
                dBinary |= ((dataBytes[i + 4] & 0x1F) << 7);
            } else {
                pad++;
            }
            if (i + 5 < dataBytes.length){
                dBinary |= ((dataBytes[i + 5] & 0x1F) << 2);
            } else {
                pad++;
            }

            for(int j=0; j<((int) encodedCount)-pad; j++) {
                byte eBinary = (byte) ((dBinary & 0xFC000000L) >> 26);
                dBinary = dBinary << 6;
                buffer.append(base64Encode[eBinary]);
            }
        }
        //for(int n=0; n<pad; n++){
        //    buffer.append(PADDING);
        //}

        //convert char[] to string
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
        long dBinary = 0L;

        //out
        int outLength = (int) (sourceCount *Math.ceil(inLength/ encodedCount));
        int num = 0;
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream(outLength);
        String decodedStr = null;
        int lastDecodedArrayItem = 0;
        boolean noRead = false;

        for (int i = 0; i < encoded.length; i += ((int) encodedCount)) {
            dBinary = 0L;
            num = 0;
            if (base64Decode[encoded[i + 0]] != -1) {
                dBinary = ((base64Decode[encoded[i + 0]] & 0x3FL) << 34);
                num++;
            }
            if (i + 1 < encoded.length && base64Decode[encoded[i + 1]] != -1){
                dBinary |= ((base64Decode[encoded[i + 1]] & 0x3FL) << 28);
                num++;
            }
            else{
                noRead = true;
            }
            if (i + 2 < encoded.length && base64Decode[encoded[i + 2]] != -1) {
                dBinary |= ((base64Decode[encoded[i + 2]] & 0x3FL) << 22);
                num++;
            }
            else{
                noRead = true;
            }
            if (i + 3 < encoded.length && base64Decode[encoded[i + 3]] != -1) {
                dBinary |= ((base64Decode[encoded[i + 3]] & 0x3FL) << 16);
                num++;
            }
            else{
                noRead = true;
            }
            if (i + 4 < encoded.length && base64Decode[encoded[i + 4]] != -1) {
                dBinary |= ((base64Decode[encoded[i + 4]] & 0x3FL) << 10);
                num++;
            }
            else{
                noRead = true;
            }
            while (num >= 0) {
                cBinary = (int) ((dBinary & 0xF800000000L) >> 35);
                buffer.write((byte) cBinary);
                lastDecodedArrayItem++;
                dBinary <<= 5;
                num--;
            }
        }
        cBinary = (int) ((dBinary & 0xF800000000L) >> 35);
        if(noRead && (cBinary > 0)){
            buffer.write((byte) cBinary);
            lastDecodedArrayItem++;
        }

        byte[] decodedBytes = buffer.toByteArray();
        char[] outputChars = new char[lastDecodedArrayItem];
        for(int j=0; j<lastDecodedArrayItem; j++){
            outputChars[j] = toCAMMAndImageDiskTypeEncode[decodedBytes[j]];
        }
        decodedStr = new String(outputChars);

        return decodedStr;
    }


    public static void main(String[] args){

        //String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        //String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}";
        String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c";
        //String testStr = "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-a0";
        System.out.println("Initial string: "+ testStr);
        System.out.println("Initial string length: "+testStr.length());


        String encodedResult = null;
        try{
            encodedResult = com.kinetix.sandbox.java.strings.B32Encoder.encode(testStr);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException e){
            e.printStackTrace();
        }
        System.out.println("Encoded result: "+ encodedResult);
        System.out.println("Encoded result string length: "+encodedResult.length());

        String decodedStr = null;
        try{
            decodedStr = com.kinetix.sandbox.java.strings.B32Encoder.decode(encodedResult);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException e){
            e.printStackTrace();
        }
        System.out.println("Decoded result: " + decodedStr);
        System.out.println("Decoded result string length: " + decodedStr.length());

    }

}
