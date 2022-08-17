package com.dn.challange.challangeeasybroken.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PropertyService {

    private RestTemplate restTemplate = new RestTemplate();
    @Value("${easybroken.api.key}")
    private String apiKey;

    public List<Property> PageProperty(int page){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Authorization", this.apiKey);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Base> responseEntity = restTemplate.exchange("https://api.stagingeb.com/v1/properties?page="+page+"&limit=10", HttpMethod.GET,request,Base.class);
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(responseEntity.getBody().getContent());
        }else {
            return new ArrayList<>();
        }
    }


    @Data
    public static class Base implements Serializable {
        private Property[] content;
    }

    @Data
    public static class Property implements Serializable {
        private String title;
    }
}
