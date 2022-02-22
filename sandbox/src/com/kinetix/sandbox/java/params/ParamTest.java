package com.kinetix.sandbox.java.params;

public class ParamTest {

    public ParamTest() {

    }
    public static void main(String[] args){

        ParamTest paramTest = new ParamTest();
        String input = "ParameterTest";
        String var2 = "";
        paramTest.retValueInParam(input, var2);
        System.out.println("var2 Value: "+var2);

    }

    public Boolean retValueInParam(String var1, String var2){
        var2 = new String(var1);
        return true;
    }
}
