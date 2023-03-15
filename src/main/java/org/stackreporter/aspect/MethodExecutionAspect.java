package org.stackreporter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stackreporter.adapter.methodexecutiontofile.MethodExecutionPrinter;
import org.stackreporter.methodexecution.MethodExecutionBuilder;
import org.stackreporter.methodexecution.RootIdToMethodExecution;
import org.stackreporter.methodexecution.MethodExecution;
import org.stackreporter.adapter.aspectjtomethodexecution.MethodExecutionFactory;

@Aspect
public abstract class MethodExecutionAspect {

    private MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();

    @Pointcut()
    abstract void methodExecution();

    @Around("methodExecution()")
    public Object closeBuildingMethodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodExecution currentMethodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);

        Object output = proceedingJoinPoint.proceed();

        MethodExecution rootMethodExecution = RootIdToMethodExecution.getMethodExecutionByRootId(currentMethodExecution.id());
        if (rootMethodExecution != null) {
            rootMethodExecution.setInput(currentMethodExecution.getInput());
            rootMethodExecution.setOutput(output);
            MethodExecutionPrinter.print(rootMethodExecution);
            RootIdToMethodExecution.clear();
            MethodExecutionBuilder.INSTANCE.clear();
        }

        return output;
    }

}