package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {

    @JsonProperty("id")
    int id;

    @JsonProperty("main")
    String main;

    @JsonProperty("description")
    String description;

    @JsonProperty("icon")
    String icon;
}
