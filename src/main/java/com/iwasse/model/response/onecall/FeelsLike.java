package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeelsLike {
    @JsonProperty("day")
    double day;

    @JsonProperty("night")
    double night;

    @JsonProperty("eve")
    double eve;

    @JsonProperty("morn")
    double morn;
}