package com.example.restcountries.controller;

import com.example.restcountries.service.CountryService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/api/countryInfo")
    public String getCountryInfo(@RequestParam(name = "countryCode") String countryCode) {
        String response = countryService.proxyCall(countryCode);
        return countryService.formatJson(response).toString();
    }
}


