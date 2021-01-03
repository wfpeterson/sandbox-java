package com.kinetix.sandbox.java.strings;

public class Base64Tests
        extends junit.framework.TestCase{

    public void testNPE(){
        String testStr = null;

        try{
            String result = B64Encoder.encode(testStr);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException urnpbeX){
            System.out.println("Throw exception as expected.");
        }
    }

    public void testBase64Encoding(){

        String [] list = getBase64EncodeList();

        for(String uid : list){
            try{
                String encodedString = com.kinetix.sandbox.java.strings.B64Encoder.encode(uid);
                System.out.println("Original String: "+uid);
                System.out.println("Encoded String: "+encodedString);
                System.out.println("Encoded length: "+encodedString.length());
                String decodedString = B64Encoder.decode(encodedString);
                assertEquals(uid, decodedString);
            }
            catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException
                    | com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException e){
                e.printStackTrace();
                fail();
            }
        }
    }

    private String[] getBase64EncodeList(){
        String[] list = new String[]{
                "This is a test of Base64 encoding/decoding",
                "This is a test of Base64 encoding/decodin",
                "This is a test of Base64 encoding/decodi",
                "This is a test of Base64 encoding/decod",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}",
                "National Broadcasting Television Test",
                "VA",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321840"
        };

        return list;
    }


}
