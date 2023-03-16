package org.stackreporter.methodexecution;

import java.util.ArrayList;
import java.util.List;

public enum MethodExecutionBuilder {

    INSTANCE();

    private List<MethodExecution> methodExecutions;
    private Integer stackDepth = 0;
    private MethodExecution currentMethodExecution;

    MethodExecutionBuilder() {
        methodExecutions = new ArrayList<>();
    }

    public MethodExecution addMethodExecution(MethodExecution methodExecution) {
        if (stackDepth == 0) {
            currentMethodExecution = methodExecution;
            methodExecutions.add(methodExecution);
        } else {
            addMethodExecution(stackDepth, currentMethodExecution, methodExecution);
        }
        return currentMethodExecution;
    }

    private void addMethodExecution(int depth, MethodExecution currentMethodExecution, MethodExecution methodExecution) {
        if (depth == 1) {
            currentMethodExecution.getChildren().add(methodExecution);
        } else {
            MethodExecution lastChild = currentMethodExecution.getChildren().get(currentMethodExecution.getChildren().size() - 1);
            addMethodExecution(depth - 1, lastChild, methodExecution);
        }
    }

    public void increaseTreeDepth() {
        stackDepth++;
    }

    public void decreaseTreeDepth() {
        stackDepth--;
    }

    public Integer getStackDepth() {
        return stackDepth;
    }

    public void clear() {
        this.methodExecutions.clear();
    }

    public boolean isRootDepth() {
        return getStackDepth() == 0;
    }
}
