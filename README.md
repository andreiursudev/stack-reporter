# Stack-Reporter

The Stack-Reporter was created to help you to more easily discover and understand what happens within you software product at runtime.
Using Stack-Reporter can give you new insights over your application business logic, your test cases or serve as a documentation generator.

# Description

Stack-Reporter is a Java library that uses AspectJ in order to log all the methods executions, with their input parameters values and their return values, within a Java program at runtime.
The result log file can then be rendered as a diagram using the [Stack-Viewer](https://github.com/andreiursudev/stack-viewer).

Using Aspect-oriented programming(AOP) concepts and the AspectJ implementation of them, made Stack-Reporter behave as a plugin that can be applied, with minimal effort, to any Java project without requiring modification to the existing code.

One of the biggest challenges when implementing the Stack-Reporter was to combine the call and execute pointcuts and their advices in order to model the method call stack in recursive way.
This helped minimize the amount of data needed to be written to the log file and also the number of times the log file needed to be touched.

# How to use
1. Clone this GitHub repo and install the stack-reporter artefact into your local maven repository using the command:
    ```
    mvn clean install
    ```
2. Add the following stack-reporter maven dependency in your project pom.xml file:
    ```xml
    <dependency>
        <groupId>org.stackreporter</groupId>
        <artifactId>stack-reporter</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```
3. Create aop.xml file under the YourPoject/src/main/resources/META-INF path. The content of aop.xml file should be:
    ```xml
    <aspectj>
        <aspects>
            <concrete-aspect name="your.package.name.MyMethodExecutionAspect" extends="org.stackreporter.aspect.MethodExecutionAspect">
                <pointcut name="methodExecution" expression="execution(* your.package.name..*(..))"/>
            </concrete-aspect>
            <concrete-aspect name="your.package.name.MyMethodCallAspect" extends="org.stackreporter.aspect.MethodCallAspect">
                <pointcut name="methodCall" expression="call(* your.package.name..*(..))"/>
            </concrete-aspect>
        </aspects>
        <weaver options="-Xlint:ignore">
        </weaver>
    </aspectj>
    ```
    Replace
    ```
    your.package.name
    ```
    with the package that contains the methods that you want to be logged by Stack-Reporter. 

    You can look at [To-Do-App](https://github.com/andreiursudev/to-do-app) for an example on how to configure Stack-Reporter for your project.
4. After this changes build the jar for your project.
5. Download the [aspectjweaver.jar](https://repo1.maven.org/maven2/org/aspectj/aspectjweaver/1.9.19/aspectjweaver-1.9.19.jar)
6. Run your project jar together with the aspectjweaver Java agent using the following command line:
    ```shell
    java -javaagent:"d:/aspectjweaver-1.9.19.jar" --add-opens java.base/java.lang=ALL-UNNAMED -jar your-jar-name.jar
    ```
    Specify the path to your `aspectjweaver-1.9.19.jar` file location.
    `--add-opens java.base/java.lang=ALL-UNNAMED` configuration is needed for Java 16+ projects because of the [weaving agent collision with JEP 396](https://github.com/eclipse/org.aspectj/blob/d17189c430a7ffd1ec966759a93b3ed348766650/docs/dist/doc/README-197.html#L71-L79)
7. Start using your application as you normally do. You should see a `stack-report.js` file created next to your .jar file containing the logs of the methods that were executed at runtime.
8. To visualise `stack-report.js` file in a webpage, clone the [Stack-Viewer](https://github.com/andreiursudev/stack-viewer) repo on your local machine and copy the `stack-report.js` file next to the `index.html`. Open whe `index.html` in your web-browser to see the result.
9. If you configure the `maven-surefire-plugin` like this:
    ```xml
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M8</version>
        <configuration>
            <argLine>
                -javaagent:"d:/aspectjweaver-1.9.19.jar" --add-opens java.base/java.lang=ALL-UNNAMED
            </argLine>
            <useSystemClassLoader>true</useSystemClassLoader>
        </configuration>
    </plugin>
    ```
    when running the unit test the method call stack will be logged in the `stack-report.js` file.

# Side effects
If you are using Spring Boot for you application its possible that aspectjweaver library to log some exceptions stack trace in your application log. Also this logs will be duped in `ajcore.*.txt` files.
[This problem](https://github.com/spring-projects/spring-framework/issues/27650) is specific to Spring Boot.
Please ignore the loged stack traces and feel free to remove the `ajcore.*.txt` files.
