package tests;

import org.testng.TestNG;

import java.util.Collections;

public class ExecutableJAR {
    public static void main(String args[]) throws Exception{
        try {
            TestNG testNG;
            String ts ="testsuites/" + args[0];
            testNG = new TestNG();
            testNG.setTestSuites(Collections.singletonList(ts));
            System.out.println("Executing tests from " + ts);
            testNG.run();
        }catch (Exception e){
            throw new Exception("Unable to execute JAR file due to - " + e.getMessage());
        }
    }
}
