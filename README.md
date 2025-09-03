# API Test Automation using RestAssured

This repository contains a collection of automated tests for RESTful APIs using the RestAssured library in Java. The tests are designed to validate the functionality of various API endpoints.

**Disclaimer:** This is a sample project, so may miss some test cases.

## Required Software
- Java JDK 24+
- Maven installed and in your classpath


## Libraries Used
- RestAssured
- JUnit 5
- Owner
- Project Lombok
- Jackson Databind

## Application Under Test

The tests in this repository are designed to interact with the following API:
- OpenWeatherMap API: [https://openweathermap.org/api](https://openweathermap.org/api)

In order to run the tests, you will need to obtain an API key from OpenWeatherMap. You can sign up for a free account and get your API key [here](https://home.openweathermap.org/users/sign_up).

The API key should be set in the `api.properties` file located in the `src/test/resources` directory.

There is an example file named `api.example.properties` that you can copy and rename to `api.properties`, then add your API key.

## Running the Tests

The test suites can be run directly by your IDE or by command line.
To run the tests using Maven, navigate to the project directory and execute the following command:

```
mvn test
```

Running Smoke/Regression suites:
```
mvn -Dtest="com.iwasse.suites.SmokeSuite" test
or
mvn -Dtest="com.iwasse.suites.RegresionSuite" test
```