package org.stackreporter.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object8Test {

    @Test
    @Order(1)
    void injectObjectScenario1() {
        Object8 object8 = new Object8(new Object9());
        String value = object8.method1("value");
        assertEquals("value 1  2 ", value);
    }

}