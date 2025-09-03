package com.iwasse.functional.timemachine;

import com.iwasse.BaseAPI;
import com.iwasse.specs.OneCallSpecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class WeatherDataForTimestampContractTest extends BaseAPI {

    @Test
    @DisplayName("Should validate the contract for the /onecall/timemachine endpoint")
    public void validateWeatherDataForTimestampContract(){
        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
            .queryParam("dt", 1605182400) // Fixed timestamp for consistent contract validation
        .when()
            .get(ONECALL_TIMEMACHINE)
        .then()
            .body(matchesJsonSchemaInClasspath("schemas/weather_data_for_timestamps_schema.json"));
    }

}
