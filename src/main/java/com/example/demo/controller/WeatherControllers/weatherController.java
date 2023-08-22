package com.example.demo.controller.WeatherControllers;
import com.example.demo.domin.CountryWeather;
import com.example.demo.services.WeatherServices.WeatherService;
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
       return   weatherservice.getWeathersStatus(city);
    }
}
