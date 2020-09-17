package com.kinetix.sandbox.java.strings;

import java.io.UnsupportedEncodingException;

public class SixBitEncoder {
    final static public int FOUR_BIT = 4;
    final static public int SIX_BIT = 6;
    final static public int FIVE_BIT = 5;


    int toBase64Value(char ch){
        int chaVal = 0;
        switch(ch){
            case'A':chaVal=0;break; case'B':chaVal=1;break;
            case'C':chaVal=2;break; case'D':chaVal=3;break;
            case'E':chaVal=4;break; case'F':chaVal=5;break;
            case'G':chaVal=6;break; case'H':chaVal=7;break;
            case'I':chaVal=8;break; case'J':chaVal=9;break;
            case'K':chaVal=10;break; case'L':chaVal=11;break;
            case'M':chaVal=12;break; case'N':chaVal=13;break;
            case'O':chaVal=14;break; case'P':chaVal=15;break;
            case'Q':chaVal=16;break; case'R':chaVal=17;break;
            case'S':chaVal=18;break; case'T':chaVal=19;break;
            case'U':chaVal=20;break; case'V':chaVal=21;break;
            case'W':chaVal=22;break; case'X':chaVal=23;break;
            case'Y':chaVal=24;break; case'Z':chaVal=25;break;
            case'a':chaVal=26;break; case'b':chaVal=27;break;
            case'c':chaVal=28;break; case'd':chaVal=29;break;
            case'e':chaVal=30;break; case'f':chaVal=31;break;
            case'g':chaVal=32;break; case'h':chaVal=33;break;
            case'i':chaVal=34;break; case'j':chaVal=35;break;
            case'k':chaVal=36;break; case'l':chaVal=37;break;
            case'm':chaVal=38;break; case'n':chaVal=39;break;
            case'o':chaVal=40;break; case'p':chaVal=41;break;
            case'q':chaVal=42;break; case'r':chaVal=43;break;
            case's':chaVal=44;break; case't':chaVal=45;break;
            case'u':chaVal=46;break; case'v':chaVal=47;break;
            case'w':chaVal=48;break; case'x':chaVal=49;break;
            case'y':chaVal=50;break; case'z':chaVal=51;break;
            case'0':chaVal=52;break; case'1':chaVal=53;break;
            case'2':chaVal=54;break; case'3':chaVal=55;break;
            case'4':chaVal=56;break; case'5':chaVal=57;break;
            case'6':chaVal=58;break; case'7':chaVal=59;break;
            case'8':chaVal=60;break; case'9':chaVal=61;break;
            case'~':chaVal=62;break; case'_':chaVal=63;break;
            default:chaVal=0;
        }
        return chaVal;
    }

    char toBase64Char(int val){
        char ch = ' ';
        switch(val){
            case 0:ch='A';break; case 1:ch='B';break;
            case 2:ch='C';break; case 3:ch='D';break;
            case 4:ch='E';break; case 5:ch='F';break;
            case 6:ch='G';break; case 7:ch='H';break;
            case 8:ch='I';break; case 9:ch='J';break;
            case 10:ch='K';break; case 11:ch='L';break;
            case 12:ch='M';break; case 13:ch='N';break;
            case 14:ch='O';break; case 15:ch='P';break;
            case 16:ch='Q';break; case 17:ch='R';break;
            case 18:ch='S';break; case 19:ch='T';break;
            case 20:ch='U';break; case 21:ch='V';break;
            case 22:ch='W';break; case 23:ch='X';break;
            case 24:ch='Y';break; case 25:ch='Z';break;
            case 26:ch='a';break; case 27:ch='b';break;
            case 28:ch='c';break; case 29:ch='d';break;
            case 30:ch='e';break; case 31:ch='f';break;
            case 32:ch='g';break; case 33:ch='h';break;
            case 34:ch='i';break; case 35:ch='j';break;
            case 36:ch='k';break; case 37:ch='l';break;
            case 38:ch='m';break; case 39:ch='n';break;
            case 40:ch='o';break; case 41:ch='p';break;
            case 42:ch='q';break; case 43:ch='r';break;
            case 44:ch='s';break; case 45:ch='t';break;
            case 46:ch='u';break; case 47:ch='v';break;
            case 48:ch='w';break; case 49:ch='x';break;
            case 50:ch='y';break; case 51:ch='z';break;
            case 52:ch='0';break; case 53:ch='1';break;
            case 54:ch='2';break; case 55:ch='3';break;
            case 56:ch='4';break; case 57:ch='5';break;
            case 58:ch='6';break; case 59:ch='7';break;
            case 60:ch='8';break; case 61:ch='9';break;
            case 62:ch='~';break; case 63:ch='_';break;
            default:ch='A';
        }
        return ch;
    }

    int toInstanceUIDTypeValue(char ch){
        int chaVal = 0;
        switch(ch){
            case'0':chaVal=0;break; case'1':chaVal=1;break;
            case'2':chaVal=2;break; case'3':chaVal=3;break;
            case'4':chaVal=4;break; case'5':chaVal=5;break;
            case'6':chaVal=6;break; case'7':chaVal=7;break;
            case'8':chaVal=8;break; case'9':chaVal=9;break;
            case'V':chaVal=10;break; case'A':chaVal=11;break;
            case'C':chaVal=12;break; case'M':chaVal=13;break;
            case'.':chaVal=14;break; case'|':chaVal=15;break;
            default:chaVal=0;
        }
        return chaVal;
    }

    char toInstanceUIDTypeChar(int val){
        char ch = '0';
        switch(val){
            case 0:ch='0';break; case 1:ch='1';break;
            case 2:ch='2';break; case 3:ch='3';break;
            case 4:ch='4';break; case 5:ch='5';break;
            case 6:ch='6';break; case 7:ch='7';break;
            case 8:ch='8';break; case 9:ch='9';break;
            case 10:ch='V';break; case 11:ch='A';break;
            case 12:ch='C';break; case 13:ch='M';break;
            case 14:ch='.';break; case 15:ch='|';break;
            default:ch='0';
        }
        return ch;
    }

    int toDocumentRefTypeValue(char ch){
        int chaVal = 0;
        switch(ch){
            case'0':chaVal=0;break; case'1':chaVal=1;break;
            case'2':chaVal=2;break; case'3':chaVal=3;break;
            case'4':chaVal=4;break; case'5':chaVal=5;break;
            case'6':chaVal=6;break; case'7':chaVal=7;break;
            case'8':chaVal=8;break; case'9':chaVal=9;break;
            case'X':chaVal=10;break; case'R':chaVal=11;break;
            case'.':chaVal=12;break; case'|':chaVal=13;break;
            case'-':chaVal=14;break; case'_':chaVal=15;break;
            default:chaVal=0;
        }
        return chaVal;
    }

    char toDocumentRefTypeChar(int val){
        char ch = '0';
        switch(val){
            case 0:ch='0';break; case 1:ch='1';break;
            case 2:ch='2';break; case 3:ch='3';break;
            case 4:ch='4';break; case 5:ch='5';break;
            case 6:ch='6';break; case 7:ch='7';break;
            case 8:ch='8';break; case 9:ch='9';break;
            case 10:ch='X';break; case 11:ch='R';break;
            case 12:ch='.';break; case 13:ch='|';break;
            case 14:ch='-';break; case 15:ch='_';break;
            default:ch='0';
        }
        return ch;
    }


    int toCAMMAndImageDiskTypesValue(char ch){
        int chaVal = 0;
        switch(ch){
            case'0':chaVal=0;break; case'1':chaVal=1;break;
            case'2':chaVal=2;break; case'3':chaVal=3;break;
            case'4':chaVal=4;break; case'5':chaVal=5;break;
            case'6':chaVal=6;break; case'7':chaVal=7;break;
            case'8':chaVal=8;break; case'9':chaVal=9;break;
            case'A':chaVal=10;break; case'B':chaVal=11;break;
            case'C':chaVal=12;break; case'D':chaVal=13;break;
            case'E':chaVal=14;break; case'F':chaVal=15;break;

            case'a':chaVal=16;break; case'b':chaVal=17;break;
            case'c':chaVal=18;break; case'd':chaVal=19;break;
            case'e':chaVal=20;break; case'f':chaVal=21;break;
            case'M':chaVal=22;break; case'V':chaVal=23;break;
            case'-':chaVal=24;break; case'|':chaVal=25;break;
            case'{':chaVal=26;break; case'}':chaVal=27;break;
            default:chaVal=0;
        }
        return chaVal;
    }

    char toCAMMAndImageDiskTypeChar(int val){
        char ch = '0';
        switch(val){
            case 0:ch='0';break; case 1:ch='1';break;
            case 2:ch='2';break; case 3:ch='3';break;
            case 4:ch='4';break; case 5:ch='5';break;
            case 6:ch='6';break; case 7:ch='7';break;
            case 8:ch='8';break; case 9:ch='9';break;
            case 10:ch='A';break; case 11:ch='B';break;
            case 12:ch='C';break; case 13:ch='D';break;
            case 14:ch='E';break; case 15:ch='F';break;

            case 16:ch='a';break; case 17:ch='b';break;
            case 18:ch='c';break; case 19:ch='d';break;
            case 20:ch='e';break; case 21:ch='f';break;
            case 22:ch='M';break; case 23:ch='V';break;
            case 24:ch='-';break; case 25:ch='|';break;
            case 26:ch='{';break; case 27:ch='}';break;
            default:ch='0';
        }
        return ch;
    }

    byte[] sixBitEncode(String txt, int bit, String type){
        int length = txt.length();
        float tmpRet1=0,tmpRet2=0;
        if(bit==6){
            tmpRet1=1.0f;
            tmpRet2=1.0f;
        }else if(bit==5){
            tmpRet1=5.0f;
            tmpRet2=6.0f;
        }else if(bit==4){
            tmpRet1=2.0f;
            tmpRet2=3.0f;
        }
        byte encoded[]=new byte[(int)(tmpRet1*Math.ceil(length/tmpRet2))];
        char str[]=new char[length];
        //push string into a char[]
        txt.getChars(0,length,str,0);
        //initialize a few new variables
        int chaVal = 0;
        String temp = null;
        String strBinary = new String("");
        //loop thru char[] and convert each char into an int.
        for (int i = 0;i<length; i++){
            //make final code use a factory
            if(type.equalsIgnoreCase("CAMM")){
                temp = Integer.toBinaryString(toCAMMAndImageDiskTypesValue((str[i])));
            }
            else if(type.equalsIgnoreCase("INSTANCEUID")) {
                temp = Integer.toBinaryString(toInstanceUIDTypeValue((str[i])));
            }
            else if(type.equalsIgnoreCase("DOCUMENT_REF")) {
                temp = Integer.toBinaryString(toDocumentRefTypeValue((str[i])));
            }
            while(temp.length()%bit != 0){
                temp="0"+temp;
            }
            strBinary=strBinary+temp;
        }
        //padding
        while(strBinary.length()%6 != 0){
            strBinary=strBinary+"0";
        }
        Integer tempInt =new Integer(0);
        int strLength = strBinary.length();
        for(int i=0 ; i<strBinary.length()-1;i=i+6){
            tempInt = tempInt.valueOf(strBinary.substring(i,i+6),2);
            encoded[i/6]= tempInt.byteValue();
        }
        return encoded;
    }


    String sixBitDecode(byte[] encoded, int bit, String type){
        String strTemp = new String("");
        String strBinary = new String("");
        String strText = new String("");
        Integer tempInt =new Integer(0);
        int intTemp=0;
        for(int i = 0;i<encoded.length;i++){
            if(encoded[i]<0){
                intTemp = (int)encoded[i]+256;
            }else
                intTemp = (int)encoded[i];
            strTemp = Integer.toBinaryString(intTemp);
            while(strTemp.length()%6 != 0){
                strTemp="0"+strTemp;
            }
            strBinary = strBinary+strTemp;
        }
        for(int i=0 ; i<strBinary.length();i=i+bit){
            tempInt = tempInt.valueOf(strBinary.substring(i,i+bit),2);
            //strText = strText + toBase64Char(tempInt.intValue());
            if(type.equalsIgnoreCase("CAMM")){
                strText = strText + toCAMMAndImageDiskTypeChar(tempInt.intValue());
            }
            else if(type.equalsIgnoreCase("INSTANCEUID")) {
                strText = strText + toInstanceUIDTypeChar(tempInt.intValue());
            }
            else if(type.equalsIgnoreCase("DOCUMENT_REF")) {
                strText = strText + toDocumentRefTypeChar(tempInt.intValue());
            }
        }
        return strText;
    }

    public static void main(String[] args){
        String testStr = "CM|2|1.2.546.35279120364398.4059681234.536.2.5.4.1.1.23.34.9087321846";
        //String testStr = "XR-197198634";
        //String testStr = "CM|1|{34-2c-ca-7f-8e-99-aa-2a}";
        SixBitEncoder encoder = new SixBitEncoder();
        byte[] encodedResult = encoder.sixBitEncode(testStr, FOUR_BIT, "INSTANCEUID");
        String result = null;
        char[] charArray = new char[encodedResult.length];
        try {
            result = new String(encodedResult, 0, encodedResult.length, "UTF-8");
            for (int i=0;i<encodedResult.length; i++){
                charArray[i] = encoder.toBase64Char(encodedResult[i]);
            }
            result = new String(charArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //result = new String(encodedResult);
        System.out.println("Encoded result: "+ result);
        System.out.println("Encoded result string length: "+result.length());


        //String result = new String("zfLx4uVG41J5EgNkOY5AWWgSNOU24uXk4eHiPjTpCHMhhG");
        char[] decodeArray = result.toCharArray();
        byte[] decodeByteArray = new byte[result.length()];
        for(int j=0; j<decodeArray.length; j++){
            decodeByteArray[j] = (byte) encoder.toBase64Value(decodeArray[j]);
        }

        String decodedStr = encoder.sixBitDecode(decodeByteArray, FOUR_BIT, "INSTANCEUID");
        System.out.println("Encoded result: "+ decodedStr);
        System.out.println("Encoded result string length: "+decodedStr.length());


    }
}
