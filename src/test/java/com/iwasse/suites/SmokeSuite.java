package com.iwasse.suites;


import com.iwasse.functional.onecall.CurrentAndForecastsWeatherDataTests;
import com.iwasse.functional.overview.WeatherOverviewTests;
import com.iwasse.functional.timemachine.WeatherDataForTimestampTests;
import org.junit.platform.suite.api.SelectMethod;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectMethod(type = CurrentAndForecastsWeatherDataTests.class, name = "shouldReturnStatus200_WhenLatitudeAndLongitudeAreValid")
@SelectMethod(type = WeatherOverviewTests.class, name = "shouldReturnStatus200_WhenQueryParamsAreValid")
@SelectMethod(type = WeatherDataForTimestampTests.class, name = "shouldReturnStatus200_WhenRequestIsValid")
public class SmokeSuite {
}