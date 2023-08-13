package com.CVsearches.Test.domin;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CountryWeather {

    private String country_name;
    private double temp;
    private double main_temp;
    private double feels_like;
    private double humidity;

}
