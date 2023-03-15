package org.stackreporter.methodexecution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MethodExecution {

    private String packageName;
    private String className;
    private String methodName;
    private String input;
    private String output;
    private List<MethodExecution> children = new ArrayList<>();

    public MethodExecution(String packageName, String className, String methodName, String input) {
        this.packageName = packageName;
        this.className = className;
        this.methodName = methodName;
        this.input = input;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getInput() {
        return input;
    }


    public String getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output == null ? null : output.toString();
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public List<MethodExecution> getChildren() {
        return children;
    }

    public String id() {
        return getPackageName() + getClassName() + getMethodName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodExecution that = (MethodExecution) o;
        return Objects.equals(methodName, that.methodName) && Objects.equals(input, that.input) && Objects.equals(output, that.output) && Objects.equals(children, that.children);
    }

    @Override
    public String toString() {
        return "MethodExecution{" +
                "packageName='" + packageName + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", children=" + children +
                '}';
    }
}
