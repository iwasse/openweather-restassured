package com.iwasse.functional.timemachine;

import com.iwasse.BaseAPI;
import com.iwasse.model.response.error.ErrorMessage;
import com.iwasse.specs.OneCallSpecs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataForTimestampTests extends BaseAPI {

    @Test
    @DisplayName("Check status code 200 when request is valid")
    public void shouldReturnStatus200_WhenRequestIsValid(){

        given()
            .spec(OneCallSpecs.validLatLonQueryParamsSpec())
            .queryParam("dt", Instant.now().getEpochSecond())
        .when()
            .get(ONECALL_TIMEMACHINE)
        .then()
            .assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Check status code 400 when timestamp is out of range")
    public void shouldReturnError400_WhenDateTimeIsOutOfRange(){
        ErrorMessage errorMsg =
                given()
                    .spec(OneCallSpecs.validLatLonQueryParamsSpec())
                    .queryParam("dt", Instant.now().getEpochSecond() + Duration.ofDays(6).getSeconds())
                .when()
                    .get(ONECALL_TIMEMACHINE)
                .then()
                    .assertThat().statusCode(400)
                    .extract().body().as(ErrorMessage.class);

        assertEquals("The requested time is out the available range. " +
                "Please check possible time range in the product documentation page", errorMsg.getMessage());
    }


}
