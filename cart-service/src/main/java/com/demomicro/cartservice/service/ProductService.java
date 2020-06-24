package com.demomicro.cartservice.service;

import com.demomicro.cartservice.model.Product;
import com.demomicro.cartservice.model.ProductItem;
import com.demomicro.cartservice.model.ProductList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    RestTemplate restTemplate;


    public List<Product> getProduct(int userid) {
        return restTemplate.getForObject("http://PRODUCT-SERVICE/products/user/" + userid, ProductList.class)
                .getProducts();

    }
}
