package org.stackreporter.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object5Test {

    @Test
    @Order(1)
    void methodCallsInnerConditionMethodScenario1() {
        Object5 object5 = new Object5();
        String value = object5.method1("true true");
        assertEquals("true true 1 true true 2 true true 3 ", value);
    }

    @Test
    @Order(2)
    void methodCallsInnerConditionMethodScenario2() {
        Object5 object5 = new Object5();
        String value = object5.method1("true false");
        assertEquals("true false 1 true false 2 true false 4 ", value);
    }

    @Test
    @Order(3)
    void methodCallsInnerConditionMethodScenario3() {
        Object5 object5 = new Object5();
        String value = object5.method1("false true");
        assertEquals("false true 1 false true 5 false true 6 ", value);
    }

    @Test
    @Order(4)
    void methodCallsInnerConditionMethodScenario4() {
        Object5 object5 = new Object5();
        String value = object5.method1("false false");
        assertEquals("false false 1 false false 5 false false 7 ", value);
    }

}