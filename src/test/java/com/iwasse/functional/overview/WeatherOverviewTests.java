package com.iwasse.functional.overview;

import com.iwasse.BaseAPI;
import com.iwasse.model.response.error.ErrorMessage;
import com.iwasse.model.response.overview.OverviewResponse;
import com.iwasse.specs.OneCallSpecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherOverviewTests extends BaseAPI {

    @Test
    @DisplayName("Check status code 200 for valid latitude and longitude")
    public void shouldReturnStatus200_WhenQueryParamsAreValid() {
        given()
                .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                .when()
                .get(ONECALL_OVERVIEW)
                .then()
                .statusCode(200);
    }

    @ParameterizedTest(name = "units={0} should return status 200 and response in {0} units")
    @ValueSource(strings = {"standard","metric","imperial"})
    public void shouldReturnStatus200_WhenUnitsAreValid(String units) {
        OverviewResponse response = given()
                .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                .queryParam("units", units)
                .when()
                .get(ONECALL_OVERVIEW)
                .then()
                .statusCode(200)
                .extract().body().as(OverviewResponse.class);

        assertEquals(units, response.getUnits());
    }

    @ParameterizedTest(name = "days={0} should return status 200 when date is valid")
    @ValueSource(longs = {0, 1})
    public void shouldReturnStatus200_WhenDateIsValid(long days) {

        String dateToday = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        OverviewResponse response = given()
                .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                .queryParam("date", dateToday)
                .when()
                .get(ONECALL_OVERVIEW)
                .then()
                .statusCode(200)
                .extract().body().as(OverviewResponse.class);

        assertEquals(dateToday, response.getDate());

    }


    @ParameterizedTest(name = "days={0} should return status 400")
    @ValueSource(longs = {-1, 2})
    public void shouldReturnStatus400_WhenDateIsInvalid(long days) {

        LocalDate dateToday = LocalDate.now().plusDays(days);

        ErrorMessage response = given()
                .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                .queryParam("date", dateToday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .when()
                .get(ONECALL_OVERVIEW)
                .then()
                .statusCode(400)
                .extract().body().as(ErrorMessage.class);

        assertTrue(response.getMessage().contains("Invalid data depth"));
        assertEquals("date", response.getParameters().getFirst());

    }
}
