package com.CVsearches.Test.controller.Weatherconteooler;

import com.CVsearches.Test.domin.CountryWeather;
import com.CVsearches.Test.services.weatherservice.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class weatherController {

    @Autowired
    private WeatherService weatherservice;
    @GetMapping("weather/{city}")
    public ResponseEntity<CountryWeather> getweather(@PathVariable String city){
        System.out.println("!!!!!!!!!!!!!!!");
       return   weatherservice.getWeathersStatus(city);
    }
}