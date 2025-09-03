package com.iwasse.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.time.Instant;

public final class OneCallSpecs {

    private OneCallSpecs(){ }

    public static RequestSpecification validLatLonQueryParamsSpec(){
        return new RequestSpecBuilder()
                .addQueryParam("lat", "-16.67")
                .addQueryParam("lon", "-49.25")
                .build();
    }

    public static RequestSpecification onlyLatitudeSpec(){
        return new RequestSpecBuilder()
                .addQueryParam("lat", "-16.67")
                .build();
    }

    public static RequestSpecification onlyLongitudeSpec(){
        return new RequestSpecBuilder()
                .addQueryParam("lon", "-16.67")
                .build();
    }

    public static RequestSpecification onlyDateTimeSpec(){
        return new RequestSpecBuilder()
                .addQueryParam("dt", Instant.now().getEpochSecond())
                .build();
    }

}
