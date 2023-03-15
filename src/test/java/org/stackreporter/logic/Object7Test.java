package org.stackreporter.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object7Test {

    @Test
    @Order(1)
    void sameMethodCallScenario1() {
        Object7 object7 = new Object7();
        String value = object7.method1("value");
        assertEquals("value 1  2  2 ", value);
    }

    @Test
    @Order(2)
    void sameMethodCallScenario2() {
        Object7 object7 = new Object7();
        String value = object7.method3("value");
        assertEquals("value 1  2  2 ", value);
    }
}