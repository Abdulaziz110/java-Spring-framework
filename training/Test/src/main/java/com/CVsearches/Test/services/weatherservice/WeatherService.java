package com.CVsearches.Test.services.weatherservice;

import com.CVsearches.Test.domin.CountryWeather;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {



    public ResponseEntity<CountryWeather> getWeathersStatus(String city){

        String API_KEY = "79aab20a7ca46b0b364ef8b5e0a1ff1a";

        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
        RestTemplate restTemplate =new RestTemplate();
        String weatherData = restTemplate.getForObject(apiUrl, String.class);
        JSONObject jsonResponse = new JSONObject(weatherData);
        JSONObject mainData = jsonResponse.getJSONObject("main");

        double temp = Math.round(mainData.getDouble("temp")-272);
        double main_temp = Math.round(mainData.getDouble("temp_min")-272);
        double feels_like = Math.round(mainData.getDouble("feels_like")-272);
        double humidity = mainData.getDouble("humidity");


       CountryWeather countryWeather = new CountryWeather(city,temp,main_temp,feels_like,humidity);


        return new ResponseEntity<>(countryWeather, HttpStatus.OK);








    }




}
