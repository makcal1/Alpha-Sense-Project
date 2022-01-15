# Alpha-Sense-Project

The project was created on January 15, 2022.

1-) Front-end and API testing are supported by the project, which has been implemented in a maven project.

2-) The text can be executed in three different ways;

3-) Test classes allow you to run tests by selecting Run All or Run Annotations.

4-) Parallel test execution is available in the /ASenseProject/resources/testrunners/testng.alphaSense.xml file.

5-)If the local plugins are installed, the project can be run from the command line.

* mvn clean test --> Execute All Tests
* mvn test -> Execute a Single Test Class -Dtest="TestClassName" 
* Run multiple test classes based on a name pattern: -Dtest="*ServiceUnitTest" or -Dtest="The*UnitTest" or -Dtest="The*UnitTest"

6-) The test report can be found in the path --> /ASenseProject/build/TestExecutionReport.html after the test execution.
