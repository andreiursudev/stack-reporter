package org.stackreporter.logic;

public class Object6 {
    public String method1(Boolean[] value) {
        String result = " 1 ";
        if (value[0]) {
            result += method11(value);
        } else {
            result += method12(value);
        }
        return result;
    }

    public String method12(Boolean[] value) {
        String result = " 12 ";
        if (value[1]) {
            result += method121(value);
        } else {
            result += method122(value);
        }
        return result;
    }

    private String method122(Boolean[] value) {
        String result = " 122 ";
        if (value[2]) {
            result += method1221(value);
        } else {
            result += method1222(value);
        }
        return result;
    }

    private String method1222(Boolean[] value) {
        return " 1222 ";
    }

    private String method1221(Boolean[] value) {
        return " 1221 ";
    }

    private String method121(Boolean[] value) {
        String result = " 121 ";
        if (value[2]) {
            result += method1211(value);
        } else {
            result += method1212(value);
        }
        return result;
    }

    private String method1212(Boolean[] value) {
        return " 1212 ";
    }

    private String method1211(Boolean[] value) {
        return " 1211 ";
    }


    public String method11(Boolean[] value) {
        String result = " 11 ";
        if (value[1]) {
            result += method111(value);
        } else {
            result += method112(value);
        }
        return result;
    }

    private String method112(Boolean[] value) {
        String result = " 112 ";
        if (value[2]) {
            result += method1121(value);
        } else {
            result += method1122(value);
        }
        return result;
    }

    private String method1122(Boolean[] value) {
        return " 1122 ";
    }

    private String method1121(Boolean[] value) {
        return " 1121 ";
    }

    private String method111(Boolean[] value) {
        String result = " 111 ";
        if (value[2]) {
            result += method1111(value);
        } else {
            result += method1112(value);
        }
        return result;
    }

    private String method1112(Boolean[] value) {
        return " 1112 ";
    }

    private String method1111(Boolean[] value) {
        return " 1111 ";
    }


}
