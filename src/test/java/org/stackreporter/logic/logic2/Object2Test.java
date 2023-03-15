package org.stackreporter.logic.logic2;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object2Test {

    @Test
    @Order(1)
    void methodCallsAnotherMethodScenario1() {
        Object2 object2 = new Object2();
        String value = object2.method1("value1");
        assertEquals("value1 1 value1 2 ", value);
    }

    @Test
    @Order(2)
    void methodCallsAnotherMethodScenario2() {
        Object2 object2 = new Object2();
        String value = object2.method1("value2");
        assertEquals("value2 1 value2 2 ", value);
    }

    @Test
    @Order(3)
    void methodCallsTwoOtherMethodsScenario1() {
        Object2 object2 = new Object2();
        String value = object2.method3("value1");
        assertEquals("value1 3 value1 4 value1 5 ", value);
    }

    @Test
    @Order(4)
    void methodCallsTwoOtherMethodsScenario2() {
        Object2 object2 = new Object2();
        String value = object2.method3("value2");
        assertEquals("value2 3 value2 4 value2 5 ", value);
    }
}