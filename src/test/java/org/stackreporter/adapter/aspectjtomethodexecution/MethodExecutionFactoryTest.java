package org.stackreporter.adapter.aspectjtomethodexecution;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.junit.jupiter.api.Test;
import org.stackreporter.logic.logic1.Object1;
import org.stackreporter.methodexecution.MethodExecution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MethodExecutionFactoryTest {

    @Test
    void getMethodExecution() {
        MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        CodeSignature codeSignature = mock(CodeSignature.class);
        when(codeSignature.getParameterNames()).thenReturn(new String[]{"parameterName"});
        when(codeSignature.getDeclaringType()).thenReturn(Object1.class);
        when(codeSignature.getName()).thenReturn("methodName");
        when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
        when(proceedingJoinPoint.getArgs()).thenReturn(new Object[]{"parameterValue"});

        MethodExecution methodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);

        assertEquals(new MethodExecution("ro.exceptionalbear.stackreporter.logic.logic1", "Object1", "methodName","parameterName = parameterValue"), methodExecution);
    }

    @Test
    void variousInputParameters() {
        String input = MethodExecutionFactory.getInput(new String[]{"parameter1", "parameter2", "parameter3"}, new Object[]{null, "someString", new Person("Andrei", "Ursu")});

        assertEquals("""
                parameter1 = null
                parameter2 = someString
                parameter3 = Person{firstName='Andrei', lastName='Ursu'}""", input);

    }


}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}