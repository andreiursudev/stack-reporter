package org.stackreporter.logic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Object6Test {

    @Test
    @Order(1)
    void methodCallsTwiceInnerConditionMethodScenario1() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.TRUE, Boolean.TRUE, Boolean.TRUE});
        assertEquals(" 1  11  111  1111 ", value);
    }

    @Test
    @Order(2)
    void methodCallsTwiceInnerConditionMethodScenario2() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.TRUE, Boolean.TRUE, Boolean.FALSE});
        assertEquals(" 1  11  111  1112 ", value);
    }

    @Test
    @Order(3)
    void methodCallsTwiceInnerConditionMethodScenario3() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.TRUE, Boolean.FALSE, Boolean.TRUE});
        assertEquals(" 1  11  112  1121 ", value);
    }

    @Test
    @Order(4)
    void methodCallsTwiceInnerConditionMethodScenario4() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.TRUE, Boolean.FALSE, Boolean.FALSE});
        assertEquals(" 1  11  112  1122 ", value);
    }

    @Test
    @Order(5)
    void methodCallsTwiceInnerConditionMethodScenario5() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.FALSE, Boolean.TRUE, Boolean.TRUE});
        assertEquals(" 1  12  121  1211 ", value);
    }

    @Test
    @Order(6)
    void methodCallsTwiceInnerConditionMethodScenario6() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.FALSE, Boolean.TRUE, Boolean.FALSE});
        assertEquals(" 1  12  121  1212 ", value);
    }

    @Test
    @Order(7)
    void methodCallsTwiceInnerConditionMethodScenario7() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.FALSE, Boolean.FALSE, Boolean.TRUE});
        assertEquals(" 1  12  122  1221 ", value);
    }

    @Test
    @Order(8)
    void methodCallsTwiceInnerConditionMethodScenario8() {
        Object6 object6 = new Object6();
        String value = object6.method1(new Boolean[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE});
        assertEquals(" 1  12  122  1222 ", value);
    }
}