package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
public class Current {

    @JsonProperty("dt")
    int dt;

    @JsonProperty("sunrise")
    int sunrise;

    @JsonProperty("sunset")
    int sunset;

    @JsonProperty("temp")
    double temp;

    @JsonProperty("feels_like")
    double feels_like;

    @JsonProperty("pressure")
    int pressure;

    @JsonProperty("humidity")
    int humidity;

    @JsonProperty("dew_point")
    double dew_point;

    @JsonProperty("uvi")
    double uvi;

    @JsonProperty("clouds")
    int clouds;

    @JsonProperty("visibility")
    int visibility;

    @JsonProperty("wind_speed")
    double wind_speed;

    @JsonProperty("wind_deg")
    int wind_deg;

    @JsonProperty("wind_gust")
    double wind_gust;

    @JsonProperty("weather")
    ArrayList<Weather> weather;
}