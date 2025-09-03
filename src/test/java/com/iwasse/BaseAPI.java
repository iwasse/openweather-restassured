package com.iwasse;

import com.iwasse.config.Configuration;
import com.iwasse.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.config.JsonPathConfig;
import org.junit.jupiter.api.BeforeAll;

import static com.iwasse.config.ConfigurationManager.getConfiguration;
import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class BaseAPI {

    public static final String ONECALL = "/onecall";
    public static final String ONECALL_TIMEMACHINE = "/onecall/timemachine";
    public static final String ONECALL_OVERVIEW = "/onecall/overview";

    @BeforeAll
    public static void setUp(){

        baseURI = getConfiguration().baseURI();
        basePath = getConfiguration().basePath();

        //Solve the problem with big decimal assertions
        config = newConfig().
                jsonConfig(jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL)).
                sslConfig(new SSLConfig().allowAllHostnames());

        //Set up a default request specification that includes the API key as a query parameter.
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("appid", getConfiguration().apiKey())
                .build();

        //It allows you to focus on testing APIs without being blocked by SSL issues.
        RestAssured.useRelaxedHTTPSValidation();

        determineLog();
    }

    /*
     * if log.all is true in the api.properties file all the request and response information will be logged
     * otherwise it will log only when the test fails
     */
    private static void determineLog() {
        if (ConfigurationManager.getConfiguration().logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        } else {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }
    }

}
