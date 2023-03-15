package org.stackreporter.logic.logic3and4;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object3Test {

    @Test
    @Order(1)
    void conditionalMethodCallTrue() {
        Object3 object3 = new Object3();
        String value = object3.method1("valueTrue");
        assertEquals("valueTrue 1 valueTrue 2 ", value);
    }

    @Test
    @Order(2)
    void conditionalMethodCallFalse() {
        Object3 object3 = new Object3();
        String value = object3.method1("valueFalse");
        assertEquals("valueFalse 1 valueFalse 3 ", value);
    }
}