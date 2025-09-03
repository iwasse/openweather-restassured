package com.iwasse.functional.onecall;

import com.iwasse.BaseAPI;
import com.iwasse.specs.OneCallSpecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CurrentAndForecastsWeatherDataContractTest extends BaseAPI {

    @Test
    @DisplayName("Should validate the contract for the /onecall endpoint")
    public void validateWeatherDataForTimestampContract(){
        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
        .when()
            .get(ONECALL)
        .then()
            .body(matchesJsonSchemaInClasspath("schemas/current_and_forecasts_weather_schema.json"));
    }

}
