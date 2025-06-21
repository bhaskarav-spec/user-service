package com.softwaretechie.service;

import com.softwaretechie.model.Item;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("user-service")
public class UserServiceImpl{

    private static final String catalogApiUrl="http://localhost:8083/catalog/items";

    @Autowired
    private RestTemplate restTemplate;
    @CircuitBreaker(name = "user-service", fallbackMethod = "fallbackForMyService")
    public List<Item> fetchCatalogDetails() {
        return restTemplate.getForObject(catalogApiUrl,List.class);
    }

    public List<Item> fallbackForMyService(Exception e) {
        System.out.println("The fallback method being called" +e.getMessage());
        // Fallback logic when the circuit breaker opens or call fails
        return getAllItemsFromDB();
    }

    private List<Item> getAllItemsFromDB() {
        return Arrays.asList(new Item("1","TV","30000",2),
                new Item("2","TV","30000",2),
                new Item("3","Fridge","40000",1),
                new Item("4","WashingMachine","30000",1),
                new Item("5","AC","30000",2));
    }
}
