package com.demomicro.cartservice.controller;

import com.demomicro.cartservice.model.Categorie;
import com.demomicro.cartservice.model.Product;
import com.demomicro.cartservice.model.ProductItem;
import com.demomicro.cartservice.model.ProductList;
import com.demomicro.cartservice.service.CategorieService;
import com.demomicro.cartservice.service.ProductService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CartController {

    @Autowired
    CategorieService categorieService;

    @Autowired
    ProductService productService;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("carts/{userid}")
    public List<ProductItem> getAll(@PathVariable("userid") int userid) {
        List<ProductItem> productItems = new ArrayList<>();

        productService.getProduct(userid).stream().forEach( p -> {
                    ProductItem pi = new ProductItem();
                    pi.setId(p.getId());
                    pi.setProduct_name(p.getName());

                    Categorie c = categorieService.getCategories(p);
                    pi.setCategory_name(c.getName());
                    productItems.add(pi);
                });

        return productItems;
    }




}
