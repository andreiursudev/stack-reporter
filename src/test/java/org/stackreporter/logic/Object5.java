package org.stackreporter.logic;

public class Object5 {
    public String method1(String value) {
        String result = value + " 1 ";
        if (value.startsWith("true")) {
            result += method2(value);
        } else {
            result += method5(value);
        }
        return result;
    }

    private String method5(String value) {
        String result = value + " 5 ";
        if (value.endsWith("true")) {
            result += method6(value);
        } else {
            result += method7(value);
        }
        return result;
    }

    private String method7(String value) {
        return value + " 7 ";
    }

    private String method6(String value) {
        return value + " 6 ";
    }

    private String method2(String value) {
        String result = value + " 2 ";
        if (value.endsWith("true")) {
            result += method3(value);
        } else {
            result += method4(value);
        }
        return result;
    }

    private String method4(String value) {
        return value + " 4 ";
    }

    private String method3(String value) {
        return value + " 3 ";
    }
}
