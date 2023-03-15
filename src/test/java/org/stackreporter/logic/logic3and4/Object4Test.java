package org.stackreporter.logic.logic3and4;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object4Test {

    @Test
    @Order(1)
    void methodCallsInnerMethod() {
        Object4 object4 = new Object4();
        String value = object4.method1("value1");
        assertEquals("value1 1 value1 2 value1 3 ", value);
    }
}