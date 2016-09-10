:: Point to Selenium directory
:: Compile tests with MAVEN
:: Create environment variable point JAVA_HOME to jdk
:: Create environment variable point MAVEN_HOME to maven
:: Create environment variable point M2_HOME to maven
:: add to PATH %ENVIRONMENT_VARIABLE%\bin;

cd C:\Selenium
mvn clean test
mvn site