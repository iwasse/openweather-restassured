package com.iwasse.functional.onecall;

import com.iwasse.BaseAPI;
import com.iwasse.model.response.error.ErrorMessage;
import com.iwasse.model.response.onecall.OneCallResponse;
import com.iwasse.specs.OneCallSpecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CurrentAndForecastsWeatherDataTests extends BaseAPI {

    @Test
    @DisplayName("Check status code 200 for valid latitude and longitude")
    public void shouldReturnStatus200_WhenLatitudeAndLongitudeAreValid() {
        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
        .when()
            .get(ONECALL)
        .then()
            .assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Check sizes of arrays in response body")
    public void shouldReturnCorrectArraySizes_WhenLatitudeAndLongitudeAreValid() {
        OneCallResponse responseBody =
                given()
                    .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                .when()
                    .get(ONECALL)
                .then()
                    .assertThat().statusCode(200)
                    .extract().body().as(OneCallResponse.class);

        assertEquals(60, responseBody.getMinutely().size());
        assertEquals(48, responseBody.getHourly().size());
        assertEquals(8, responseBody.getDaily().size());
    }

    @Test
    @DisplayName("Check status code 400 when required query params are missing")
    public void shouldReturnStatus400_WhenRequiredQueryParamsAreMissing() {
        ErrorMessage errorMsg =
                given()
                .when()
                    .get(ONECALL)
                .then()
                    .assertThat().statusCode(400)
                    .extract().body().as(ErrorMessage.class);

        assertEquals("Nothing to geocode", errorMsg.getMessage());
    }

    @ParameterizedTest(name = "Longitude={0} should return 400")
    @ValueSource(strings = {"-180.1", "180.1", "abc", " ", "$3"})
    @DisplayName("Check status code 400 for invalid longitude values")
    void shouldReturnError_WhenLongitudeIsInvalid(String longitude) {
        ErrorMessage errorMsg =
                given()
                    .queryParam("lat", "0")
                    .queryParam("lon", longitude)
                .when()
                    .get(ONECALL)
                .then()
                    .assertThat().statusCode(400)
                    .extract().body().as(ErrorMessage.class);

        assertEquals("wrong longitude", errorMsg.getMessage());
    }

    @ParameterizedTest(name = "Latitude={0} should return 400")
    @ValueSource(strings = {"-90.1", "90.1", "abc", " ", "$3"})
    @DisplayName("Check status code 400 for invalid latitude values")
    public void shouldReturnError_WhenLatitudeIsInvalid(String latitude) {
        ErrorMessage errorMsg =
                given()
                    .queryParam("lat", latitude)
                    .queryParam("lon", "0")
                .when()
                    .get(ONECALL)
                .then()
                    .assertThat().statusCode(400)
                    .extract().body().as(ErrorMessage.class);

        assertEquals("wrong latitude", errorMsg.getMessage());
    }

    @Test
    @DisplayName("Check status code 200 when all weather data parts are excluded")
    public void shouldReturnStatus200_WhenAllWeatherDataPartsAreExcluded() {
        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
            .queryParam("exclude", "current,minutely,hourly,daily,alerts")
        .when()
            .get(ONECALL)
        .then()
            .assertThat().statusCode(200);
    }

    @ParameterizedTest(name = "exclude={0} should return 200 without excluded part")
    @ValueSource(strings = {"current", "minutely", "hourly", "daily", "alerts",})
    @DisplayName("Check status code 200 when one weather data part is excluded")
    void shouldNotReturnExcludedParts_WhenValuesAreExcluded(String parts) {
        OneCallResponse response =
                given()
                    .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                    .queryParam("exclude", parts)
                .when()
                    .get(ONECALL)
                .then()
                    .statusCode(200)
                    .extract().body().as(OneCallResponse.class);

        switch (parts) {
            case "current" -> assertNull(response.getCurrent());
            case "minutely" -> assertNull(response.getMinutely());
            case "hourly" -> assertNull(response.getHourly());
            case "daily" -> assertNull(response.getDaily());
            case "alerts" -> assertNull(response.getAlerts());
            default -> throw new IllegalStateException("Unexpected value: " + parts);
        }
    }

    @ParameterizedTest(name = "Units={0} should return 200")
    @ValueSource(strings = {"metric", "imperial"})
    @DisplayName("Check status code 200 for valid units parameter")
    void shouldReturnStatus200_WhenUnitsParameterIsValid(String units) {
        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
            .queryParam("units", units)
        .when()
            .get(ONECALL)
        .then()
            .statusCode(200);
    }

}
