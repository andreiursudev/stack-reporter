package org.stackreporter.logic.logic3and4;

public class Object4 {

    public String doSomethingNew(String param) {
           return param + " 4";
    }

    public String method1(String value) {
        return value + " 1 " + method2(value);
    }

    private String method2(String value) {
        return value + " 2 " + method3(value);
    }

    private String method3(String value) {
        return value + " 3 ";
    }
}
