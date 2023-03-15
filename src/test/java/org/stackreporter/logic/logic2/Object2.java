package org.stackreporter.logic.logic2;

public class Object2 {
    public String doSomething(String param) {
        return param+" 2";
    }

    public String method1(String value) {
        return value + " 1 " + method2(value);
    }

    private String method2(String value) {
        return value + " 2 ";
    }

    public String method3(String value) {
        return value + " 3 " + method4(value) + method5(value);
    }

    private String method4(String value) {
        return value + " 4 ";
    }

    private String method5(String value) {
        return value + " 5 ";
    }
}
