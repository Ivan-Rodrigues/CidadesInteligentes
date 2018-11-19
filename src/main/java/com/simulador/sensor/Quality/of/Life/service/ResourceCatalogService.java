package com.simulador.sensor.Quality.of.Life.service;

import com.google.gson.Gson;
import com.simulador.sensor.Quality.of.Life.model.Resources;
import com.simulador.sensor.Quality.of.Life.model.Resource;
import com.simulador.sensor.Quality.of.Life.util.Util;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class ResourceCatalogService {
    private static Gson gson = new Gson();

    public static   List<Resource> getResourcesAll() throws IOException {
        Resources data = null;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response
                = restTemplate.getForEntity(Util.URL_BASE + "/catalog/resources", String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)){
            System.out.println(response.getBody());

             data = gson.fromJson(response.getBody(), Resources.class);
        }else{
            return null;
        }

        return data.getResources();
    }


    public static List<Resource> createResource(Resource resource) throws IOException {
        Resources data = null;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response
                = restTemplate.getForEntity(Util.URL_BASE + "/catalog/resources", String.class);

        if (response.getStatusCode().equals(HttpStatus.OK)){
            System.out.println(response.getBody());

            data = gson.fromJson(response.getBody(), Resources.class);
        }else{
            return null;
        }

        return data.getResources();
    }


    public static void post(){

        RestTemplate restTemplate = new RestTemplate();

        Resource resourceRequest = new Resource();
        HttpEntity<Resource> request = new HttpEntity<>(resourceRequest);
        request.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<Resource> response = restTemplate
                .exchange(Util.URL_BASE, HttpMethod.POST, request, Resource.class);

        if(response.getStatusCode().equals(HttpStatus.CREATED)){
            Resource resource = response.getBody();
        }

    }





}


