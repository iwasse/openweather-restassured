package com.iwasse.model.response.onecall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Alert {

    @JsonProperty("sender_name")
    String sender_name;

    @JsonProperty("event")
    String event;

    @JsonProperty("start")
    int start;

    @JsonProperty("end")
    int end;

    @JsonProperty("description")
    String description;

    @JsonProperty("tags")
    ArrayList<String> tags;
}
