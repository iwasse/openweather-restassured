package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Minutely {
    @JsonProperty("dt")
    int dt;

    @JsonProperty("precipitation")
    int precipitation;
}