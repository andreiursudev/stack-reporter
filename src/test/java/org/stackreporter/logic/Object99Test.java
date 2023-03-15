package org.stackreporter.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object99Test {

    @Test
    @Order(1)
    void complexMethodCallScenario1() {
        Object99 object99 = new Object99();
        String value = object99.method1("true true");
        assertEquals("true true 1 true true 2 true true 3 true true 4 true true 7 true true 71 true true 72 true true 73 true true 74 true true 75 true true 77 true true 6 ", value);
    }

    @Test
    @Order(2)
    void complexMethodCallScenario2() {
        Object99 object99 = new Object99();
        String value = object99.method1("true false");
        assertEquals("true false 1 true false 2 true false 3 true false 4 true false 7 true false 71 true false 72 true false 73 true false 74 true false 76 true false 77 true false 6 ", value);
    }

    @Test
    @Order(3)
    void complexMethodCallScenario3() {
        Object99 object99 = new Object99();
        String value = object99.method1("false true");
        assertEquals("false true 1 false true 2 false true 3 false true 5 false true 8 false true 81 false true 811 false true 812 false true 82 false true 821 false true 822 false true 8221 false true 8222 false true 8223 false true 8225 false true 823 false true 6 ", value);
    }

    @Test
    @Order(4)
    void complexMethodCallScenario4() {
        Object99 object99 = new Object99();
        String value = object99.method1("false false");
        assertEquals("false false 1 false false 2 false false 3 false false 5 false false 8 false false 81 false false 811 false false 812 false false 813 false false 82 false false 821 false false 822 false false 8221 false false 8222 false false 8224 false false 8225 false false 823 false false 6 ", value);
    }
}