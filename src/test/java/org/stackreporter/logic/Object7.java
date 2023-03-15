package org.stackreporter.logic;

public class Object7 {
    public String method1(String value) {
        return value + " 1 " + method2(value) + method2(value);
    }

    private String method2(String value) {
        return " 2 ";
    }

    public String method3(String value) {
        return method1(value);
    }
}
