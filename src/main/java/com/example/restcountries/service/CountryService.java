package com.example.restcountries.service;

import com.example.restcountries.model.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class CountryService {

    public CountryService() {
    }

    public String proxyCall(String countryCode) {
        return new RestTemplate().getForEntity("https://restcountries.com/v3.1/alpha" + "/" + countryCode, String.class).getBody();
    }

    public JSONObject deserializeResponse(String response) {
        response = response.substring(1, response.length() - 1);
        JSONObject responseJson = new JSONObject(response);
        ObjectMapper mapper = new ObjectMapper();
        try {
            responseJson = mapper.readValue(response,
                    JSONObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseJson;
    }

    public JSONObject formatJson(String response) {
        JSONObject jsonObject = deserializeResponse(response);
        Country country = new Country();
        country.setFullName(jsonObject.getJSONObject("name").getString("common"));
        country.setCapital(jsonObject.getJSONArray("capital").getString(0));
        country.setContinents(jsonObject.getJSONArray("continents").toString());
        country.setCurrentTime(formatDateTime(response).toString());
        return new JSONObject(country);
    }

    private ZonedDateTime formatDateTime(String response) {
        JSONObject jsonObject = deserializeResponse(response);
        return ZonedDateTime.now(
                ZoneId.of(jsonObject.getJSONArray("timezones").getString(0))
        );
    }
}
