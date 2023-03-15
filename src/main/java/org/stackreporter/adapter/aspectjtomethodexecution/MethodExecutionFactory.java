package org.stackreporter.adapter.aspectjtomethodexecution;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.stackreporter.methodexecution.MethodExecution;

public class MethodExecutionFactory {

    public MethodExecution getMethodExecution(ProceedingJoinPoint proceedingJoinPoint) {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();
        String input = getInput(codeSignature.getParameterNames(), args);
        String packageName = codeSignature.getDeclaringType().getPackageName();
        String className = codeSignature.getDeclaringType().getSimpleName();
        String methodName = codeSignature.getName();

        if (packageName.equals("jdk.proxy2")) {
            packageName = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getPackageName();
            className = proceedingJoinPoint.getTarget().getClass().getInterfaces()[0].getSimpleName();
        }
        return new MethodExecution(packageName, className, methodName, input);
    }

    public MethodExecution getMethodExecution(JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart) {
        CodeSignature enclosingSignature = (CodeSignature) thisEnclosingJoinPointStaticPart.getSignature();
        return new MethodExecution(enclosingSignature.getDeclaringType().getPackageName(), enclosingSignature.getDeclaringType().getSimpleName(), enclosingSignature.getName(), "");
    }

    public static String getInput(String[] parameterNames, Object[] args) {
        if (parameterNames.length == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parameterNames.length; i++) {
            result.append(parameterNames[i]).append(" = ").append(args[i]).append("\n");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

}
