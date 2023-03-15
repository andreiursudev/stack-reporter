package org.stackreporter.logic.logic1;

import org.stackreporter.logic.logic3and4.Object3;
import org.stackreporter.logic.logic2.Object2;

public class Object1 {

    private Object2 object2 = new Object2();
    private Object3 object3 = new Object3();

    public String simpleMethod(String param) {
        return param + " 1";
    }

    public String methodWithInnerCall(String param) {
        return simpleMethod(param) + " 1";
    }

    public String methodWithDifferentObjectInnerCall(String param) {
        return object2.doSomething(param) + " 1";
    }

    public String methodWithDifferentObjectsInnerCall(String param) {
        String s1 = object2.doSomething(param);
        String s2 = object3.doSomethingElse(param);
        return s1 +" "+ s2;
    }

    public String methodWithMoreDepthDifferentObjectsInnerCall(String param) {
        String s1 = object2.doSomething(param);
        String s2 = object3.doSomethingElseWithObject4(param);
        return s1 +" "+ s2;
    }

    public String methodWithCondition(String value) {
        if(value.equals("value1")){
            return object2.doSomething(value);
        } else {
            return object3.doSomethingElse(value);
        }

    }

    public String method1(String value) {
        return value + " 1 ";
    }

    public String method2(String value) {
        return value + " 2 ";
    }

    @Override
    public String toString() {
        return "Object1{" +
                "object2=" + object2 +
                ", object3=" + object3 +
                '}';
    }

    public void method3(String value2) {

    }
}
