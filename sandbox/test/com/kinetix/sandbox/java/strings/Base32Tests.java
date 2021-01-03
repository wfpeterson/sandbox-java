package com.kinetix.sandbox.java.strings;

public class Base32Tests
        extends junit.framework.TestCase{

    public void testNPE(){
        String testStr = null;

        try{
            String result = B32Encoder.encode(testStr);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException urnpbeX){
            System.out.println("Throw exception as expected.");
        }
    }

    public void testImageDiskTypeEncoding(){

        String [] list = getImageDiskTypeList();

        for(String uid : list){
            try{
                String encodedString = com.kinetix.sandbox.java.strings.B32Encoder.encode(uid);
                System.out.println("Original String: "+uid);
                System.out.println("Encoded String: "+encodedString);
                System.out.println("Encoded length: "+encodedString.length());
                String decodedString = B32Encoder.decode(encodedString);
                assertEquals(uid, decodedString);
            }
            catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException
                    | com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException e){
                e.printStackTrace();
                fail();
            }
        }
    }

    private String[] getImageDiskTypeList(){
        String[] list = new String[]{
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae}",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-ae",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-a",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-",
                "CM|2|{25-12-2e-9d-88-b7-01-34-1f-ee-6c-a0",
                "CM|2|{00-00-00-00-00-00-00-00-00-00-00-00}",
                "CM|2|{ff-ff-ff-ff-ff-ff-ff-ff-ff-ff-ff-ff}"
        };

        return list;
    }


}
