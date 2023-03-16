package org.stackreporter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stackreporter.adapter.aspectjtomethodexecution.MethodExecutionFactory;
import org.stackreporter.adapter.methodexecutiontofile.MethodExecutionPrinter;
import org.stackreporter.methodexecution.MethodExecution;
import org.stackreporter.methodexecution.MethodExecutionBuilder;

@Aspect
public abstract class MethodExecutionAspect {

    private MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();

    @Pointcut()
    abstract void methodExecution();

    @Around("methodExecution()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (isNotToStringMethod(proceedingJoinPoint)) {
            MethodExecution currentMethodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);
            MethodExecution currentMethodExecutionTree = MethodExecutionBuilder.INSTANCE.addMethodExecution(currentMethodExecution);

            MethodExecutionBuilder.INSTANCE.increaseTreeDepth();

            Object output = proceedingJoinPoint.proceed();
            currentMethodExecution.setOutput(methodExecutionFactory.getOutputAsString(output));

            MethodExecutionBuilder.INSTANCE.decreaseTreeDepth();

            if (MethodExecutionBuilder.INSTANCE.isRootDepth()) {
                MethodExecutionPrinter.print(currentMethodExecutionTree);
                MethodExecutionBuilder.INSTANCE.clear();
            }

            return output;
        } else {
            return proceedingJoinPoint.proceed();
        }
    }

    private static boolean isNotToStringMethod(ProceedingJoinPoint proceedingJoinPoint) {
        return !proceedingJoinPoint.getSignature().getName().equals("toString");
    }
}