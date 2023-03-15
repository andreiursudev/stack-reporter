package org.stackreporter.methodexecution;

import java.util.LinkedHashMap;
import java.util.Map;

public class RootIdToMethodExecution {

    private static Map<String, MethodExecution> rootToMethodExecution = new LinkedHashMap<>();

    public static MethodExecution getMethodExecutionByRootId(String rootId) {
        return rootToMethodExecution.get(rootId);
    }

    public static void addMethodExecutionTreeToRootMethodExecution(MethodExecution methodExecutionTree, MethodExecution rootMethodExecution) {
        rootToMethodExecution.computeIfAbsent(rootMethodExecution.id(), k -> rootMethodExecution);
        rootToMethodExecution.get(rootMethodExecution.id()).getChildren().add(methodExecutionTree);
    }

    public static void clear(){
        rootToMethodExecution.clear();
    }
}
