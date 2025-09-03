package com.iwasse.model.response.overview;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OverviewResponse {
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("tz")
    private String tz;
    @JsonProperty("date")
    private String date;
    @JsonProperty("units")
    private String units;
    @JsonProperty("weather_overview")
    private String weatherOverview;
}
