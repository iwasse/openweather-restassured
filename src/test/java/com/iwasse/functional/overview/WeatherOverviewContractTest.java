package com.iwasse.functional.overview;

import com.iwasse.BaseAPI;
import com.iwasse.specs.OneCallSpecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class WeatherOverviewContractTest extends BaseAPI {

    @Test
    @DisplayName("Check contract for valid latitude and longitude")
    public void shouldReturnStatus200_WhenQueryParamsAreValid() {
        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
        .when()
            .get(ONECALL_OVERVIEW)
        .then()
            .body(matchesJsonSchemaInClasspath("schemas/weather_overview_schema.json"));
    }

}
