package org.stackreporter.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object9Test {
    @Test
    @Order(1)
    void injectMockScenario2() {
        Object9 mock = Mockito.mock(Object9.class);
        when(mock.method2()).thenReturn(" 3 ");
        Object8 object8 = new Object8(mock);
        String value = object8.method1("value");
        assertEquals("value 1  3 ", value);
    }
}