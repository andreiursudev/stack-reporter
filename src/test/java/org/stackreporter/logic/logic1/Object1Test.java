package org.stackreporter.logic.logic1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object1Test {

    @Test
    @Order(1)
    void callMethod1() {
        Object1 object1 = new Object1();
        String value = object1.method1("value");
        assertEquals("value 1 ", value);
    }

    @Test
    @Order(2)
    void callMethod2Scenario1() {
        Object1 object1 = new Object1();
        String value = object1.method2("value1");
        assertEquals("value1 2 ", value);
    }

    @Test
    @Order(3)
    void callMethod2Scenario2() {
        Object1 object1 = new Object1();
        String value = object1.method2("value2");
        assertEquals("value2 2 ", value);
    }

    @Test
    @Order(3)
    void callMethodThatRetursVoid() {
        Object1 object1 = new Object1();
         object1.method3("value2");
    }
}