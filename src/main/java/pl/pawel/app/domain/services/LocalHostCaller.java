package pl.pawel.app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.pawel.app.domain.models.CorsRecivedModel;

@Component
public class LocalHostCaller implements RestCaller{

    private final String RESOURCE_URL = "http://localhost:8080/cors-server";

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public CorsRecivedModel getForObject(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject(RESOURCE_URL, CorsRecivedModel.class);
    }
}
