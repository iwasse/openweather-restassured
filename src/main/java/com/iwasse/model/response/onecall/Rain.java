package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rain {

    @JsonProperty("1h")
    double _1h;

}
