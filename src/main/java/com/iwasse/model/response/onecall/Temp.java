package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Temp {
    @JsonProperty("day")
    double day;

    @JsonProperty("min")
    double min;

    @JsonProperty("max")
    double max;

    @JsonProperty("night")
    double night;

    @JsonProperty("eve")
    double eve;

    @JsonProperty("morn")
    double morn;
}
