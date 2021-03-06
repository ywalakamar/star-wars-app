package com.ywalakamar.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ywalakamar.server.model.People;

@Service
public class PeopleService {
    @Autowired
    RestTemplate restTemplate;
    private static final String URI = "https://swapi.dev/api/people/";

    /*
     * Get All people service method
     */
    public People getPeople() {
        return restTemplate.exchange(URI, HttpMethod.GET, null,
                new ParameterizedTypeReference<People>() {

                }).getBody();
    }

    /*
     * Use method overloading(polymorphism)
     * Get people per page service method
     */
    public People getPeople(int page) {
        return restTemplate.exchange(URI + "?page=" + page, HttpMethod.GET, null,
                new ParameterizedTypeReference<People>() {

                }).getBody();
    }

    /*
     * Use method overloading(polymorphism)
     * Search person by name service method
     */
    public People getPeople(String name) {
        return restTemplate.exchange(URI + "?search=" + name, HttpMethod.GET, null,
                new ParameterizedTypeReference<People>() {

                }).getBody();
    }
}
