package org.stackreporter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.stackreporter.methodexecution.MethodExecutionBuilder;
import org.stackreporter.methodexecution.RootIdToMethodExecution;
import org.stackreporter.methodexecution.MethodExecution;
import org.stackreporter.adapter.aspectjtomethodexecution.MethodExecutionFactory;

@Aspect
public abstract class MethodCallAspect {

    private MethodExecutionFactory methodExecutionFactory = new MethodExecutionFactory();

    @Pointcut()
    abstract void methodCall();

    @Around("methodCall()")
    public Object startBuildingMethodExecution(ProceedingJoinPoint proceedingJoinPoint, ProceedingJoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart) throws Throwable {
        MethodExecution currentMethodExecution = methodExecutionFactory.getMethodExecution(proceedingJoinPoint);
        MethodExecution currentMethodExecutionTree = MethodExecutionBuilder.INSTANCE.addMethodExecution(currentMethodExecution);

        MethodExecutionBuilder.INSTANCE.increaseTreeDepth();

        Object output = proceedingJoinPoint.proceed();
        currentMethodExecution.setOutput(output);

        MethodExecutionBuilder.INSTANCE.decreaseTreeDepth();

        if (MethodExecutionBuilder.INSTANCE.isRootDepth()) {
            MethodExecution rootMethodExecution = methodExecutionFactory.getMethodExecution(thisEnclosingJoinPointStaticPart);
            RootIdToMethodExecution.addMethodExecutionTreeToRootMethodExecution(currentMethodExecutionTree, rootMethodExecution);
        }

        return output;
    }




}