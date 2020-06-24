package com.demomicro.cartservice.service;

import com.demomicro.cartservice.model.Categorie;
import com.demomicro.cartservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategorieService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCategorieFallback")
    public Categorie getCategories(Product p){
        return restTemplate.getForObject("http://CATEGORIE-SERVICE/categories/"+p.getCategorie_id(),Categorie.class);
    }

    private Categorie getCategorieFallback(Product p){
        return new Categorie(-1,"Categorie error");
    }
}
