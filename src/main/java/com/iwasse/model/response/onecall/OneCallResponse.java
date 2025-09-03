package com.iwasse.model.response.onecall;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OneCallResponse {

    @JsonProperty("lat")
    int lat;

    @JsonProperty("lon")
    int lon;

    @JsonProperty("timezone")
    String timezone;

    @JsonProperty("timezone_offset")
    int timezone_offset;

    @JsonProperty("current")
    Current current;

    @JsonProperty("hourly")
    ArrayList<Hourly> hourly;

    @JsonProperty("daily")
    ArrayList<Daily> daily;

    @JsonProperty("minutely")
    ArrayList<Minutely> minutely;

    @JsonProperty("alerts")
    ArrayList<Alert> alerts;
}