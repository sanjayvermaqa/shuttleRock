# shuttleRock
Automation framework for factorial value comparison

Pre-requistes
You’ll need following to start with Automation Testing: -

1. IntelliJ IDEA Community Edition - https://www.jetbrains.com/idea/download/
2. Java 11

Clone a repository
Use these steps to clone from SourceTree, our client for using the repository command-line free. Cloning allows you to work on your files locally SourceTr. If you don't yet havee, download and install first. If you prefer to clone from the command line, see Clone a repository.

You’ll see the clone button under the Source heading. Click that button.
Now click Check out in SourceTree. You may need to create a SourceTree account or log in.
When you see the Clone New dialog in SourceTree, update the destination path and name if you’d like to and then click Clone.
Open the directory you just created to see your repository’s files.

Adding new test
All the Page Objects should be in a new Page Object class under – src/main/java/pageObjects
All the new test class should in a new class under - src/main/java/tests
Any new generic method, should be added in GeneralFunctions class under - src/main/java/utilities/GeneralFunctions.java
Any new global constant variable or method need to be added in Constants class under - src/main/java/utilities/Constants.java
Any config or test data change should be done in default.properties under – src/main/resources/config/

Executing test can be actieved by any of below method -
1. Right click on relevant test suite xml file and click on Run or Debug Create '...xml' testng config.
2. Use terminal/command prompt to execute main class ExecutableJAR.class by providing param value as 'testSuite.xml'
3. Using execuatble jar file from 'target/shuttleRockJar-jar-with-dependencies.jar' using below commands -
  a. Extract test suite file first : jar xf - jar xf shuttleRockJar-jar-with-dependencies.jar testSuites/SmokeTest_SF.xml
  b. Execute test from jar : java -jar shuttleRockJar-jar-with-dependencies.jar testSuite.xml
Note: Intention with this jar file is to be able to test from any machine without need of IDE or Maven. Minium requirement is Java
