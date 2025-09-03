package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Hourly {

    @JsonProperty("rain")
    Rain rain;

    @JsonProperty("weather")
    ArrayList<Weather> weather;

    @JsonProperty("dt")
    int dt;

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

    @JsonProperty("pop")
    double pop;

}
