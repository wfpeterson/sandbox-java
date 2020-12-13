package com.kinetix.sandbox.java.bitz;

public class BitsInLong {

    private void longOperations() {

        long a = (long) 0x00;
        long b = (long) 0xFF;

        long c = 0L;
        System.out.println(Long.toBinaryString(c));
        c |= (b & 0xFF) << 56;
        System.out.println(Long.toBinaryString(c));
        c |= (a & 0xFF) << 48;
        System.out.println(Long.toBinaryString(c));
        c |= (b & 0xFF) << 40;
        System.out.println(Long.toBinaryString(c));
        c |= (a & 0xFF) << 32;
        System.out.println(Long.toBinaryString(c));
        c |= (b & 0xFF) << 24;
        System.out.println(Long.toBinaryString(c));
        c |= (a & 0xFF) << 16;
        System.out.println(Long.toBinaryString(c));
        c |= (b & 0xFF) << 8;
        System.out.println(Long.toBinaryString(c));
        c |= (a & 0xFF);
        System.out.println(Long.toBinaryString(c));
    }

    private void longOperationsTwo(){
        long a = (long) 0x00;
        long b = (long) 0xFF;


        long c = 0L;
        System.out.println(Long.toBinaryString(c));
        c |= (b & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (a & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (b & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (a & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (b & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (a & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (b & 0xFF);
        System.out.println(Long.toBinaryString(c));
        c = c << 8;
        c |= (a & 0xFF);
        System.out.println(Long.toBinaryString(c));

    }

    private void integerOperations() {

        byte a = (byte) 0x00;
        byte b = (byte) 0xFF;

        int c = 0;
        System.out.println(Integer.toBinaryString(c));
        c |= ((b & 0xFF) << 24);
        System.out.println(Integer.toBinaryString(c));
        c |= ((a & 0xFF) << 16);
        System.out.println(Integer.toBinaryString(c));
        c |= ((b & 0xFF) << 8);
        System.out.println(Integer.toBinaryString(c));
        c |= ((a & 0xFF));
        System.out.println(Integer.toBinaryString(c));
    }

    public BitsInLong() {
    }

    public static void main(String[] args)
    {
        String text = "CM|2|1.26.564456725807975.314859.98972835.1.5.4.7.9.2.2.33.54673.128";

        BitsInLong test = new BitsInLong();
        test.integerOperations();
        test.longOperations();
        test.longOperationsTwo();
    }

}
