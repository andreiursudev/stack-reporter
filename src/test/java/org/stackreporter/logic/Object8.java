package org.stackreporter.logic;

public class Object8 {
    private Object9 object9;

    public Object8(Object9 object9) {

        this.object9 = object9;
    }

    public String method1(String value) {
        return value + " 1 " + object9.method2();
    }
}
