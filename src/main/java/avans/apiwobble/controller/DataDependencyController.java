package avans.apiwobble.controller;

import org.springframework.web.client.RestTemplate;

public class DataDependencyController {
    public String getExternalCarData(String licensePlate){
        String uri = "https://opendata.rdw.nl/resource/m9d7-ebf2.json?kenteken=" + licensePlate;
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri, String.class);
    }
}
