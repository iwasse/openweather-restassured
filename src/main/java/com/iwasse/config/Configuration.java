package com.iwasse.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"})
public interface Configuration extends Config {

    @Key("api.base.path")
    String basePath();

    @Key("api.base.uri")
    String baseURI();

    @Key("api.key")
    String apiKey();

    @Key("log.all")
    boolean logAll();

}
