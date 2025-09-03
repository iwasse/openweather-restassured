package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Daily {
    @JsonProperty("dt")
    int dt;

    @JsonProperty("sunrise")
    int sunrise;

    @JsonProperty("sunset")
    int sunset;

    @JsonProperty("moonrise")
    int moonrise;

    @JsonProperty("moonset")
    int moonset;

    @JsonProperty("moon_phase")
    double moon_phase;

    @JsonProperty("summary")
    String summary;

    @JsonProperty("temp")
    Temp temp;

    @JsonProperty("feels_like")
    FeelsLike feels_like;

    @JsonProperty("pressure")
    int pressure;

    @JsonProperty("humidity")
    int humidity;

    @JsonProperty("dew_point")
    double dew_point;

    @JsonProperty("wind_speed")
    double wind_speed;

    @JsonProperty("wind_deg")
    int wind_deg;

    @JsonProperty("wind_gust")
    double wind_gust;

    @JsonProperty("weather")
    ArrayList<Weather> weather;

    @JsonProperty("clouds")
    int clouds;

    @JsonProperty("pop")
    double pop;

    @JsonProperty("rain")
    double rain;

    @JsonProperty("uvi")
    double uvi;
}