package com.iwasse.model.response.error;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ErrorMessage {

    private String cod;
    private String code; // some error responses use "code" instead of "cod"
    private String message;
    private ArrayList<String> parameters;

}
