package com.kinetix.sandbox.java.strings;

public class Base16Tests
        extends junit.framework.TestCase{

    public void testNPE(){
        String testStr = null;

        try{
            String result = B16Encoder.encode(testStr);
        }
        catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException urnpbeX){
            System.out.println("Throw exception as expected.");
        }
    }

    public void testInstanceUIDEncoding(){

        String [] list = getInstanceUIDList();

        for(String uid : list){
            try{
                String encodedString = com.kinetix.sandbox.java.strings.B16Encoder.encode(uid);
                System.out.println("Original String: "+uid);
                System.out.println("Encoded String: "+encodedString);
                System.out.println("Encoded length: "+encodedString.length());
                String decodedString = B16Encoder.decode(encodedString);
                assertEquals(uid, decodedString);
            }
            catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException
                    | com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException e){
                e.printStackTrace();
                fail();
            }
        }
    }

    /**
    public void testDocumentRefEncoding(){
        String [] list = getDocumentRefList();

        for(String uid : list){
            try{
                String encodedString = com.kinetix.sandbox.java.strings.B16Encoder.encode(uid);
                String decodedString = B16Encoder.decode(encodedString);
                assertEquals(uid, decodedString);
            }
            catch(com.kinetix.sandbox.java.exceptions.URNPayloadBaseEncodingException
                    | com.kinetix.sandbox.java.exceptions.URNPayloadBaseDecodingException e){
                e.printStackTrace();
                fail();
            }
        }
    }
     **/

    private String[] getInstanceUIDList(){
        String[] list = new String[]{
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.908732184",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.90873218",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321",
                "CM|2|0.1.2.3.4.5.6.7.8.9",
                "VA|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846",
                "VA|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.90873218",
                "CM|2|7",
                "CM|2|1.2.840.10008.5.1.2234.454532.9504938.39.39.10.495.444499394",
                "CM|2|1.2.840.10008.440503.29393.32.3.11.2.343565.674.324.0111.092904",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321840",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321841",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321842",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321843",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321844",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321845",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321846",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321847",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321848",
                "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.0.9087321849"
        };

        return list;

    }

    private String[] getDocumentRefList(){
        String[] list = new String[]{

        };

        return list;
    }
}
