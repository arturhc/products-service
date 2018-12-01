package com.tecgurus.products_service.app.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.tecgurus.products_service.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import lombok.*;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @Setter
//    private ProductService productService;
//
//    @GetMapping("/byCategory/{category}")
//    public ResponseEntity getInventoryProducts(@PathVariable String category) {
//
//        try {
//
//            this.validateCategory(category);
//
//            return ResponseEntity.ok(products.get(category));
//
//        } catch (Exception ex) {
//            return ResponseEntity.badRequest().body(ex.getMessage());
//        }
//
//    }
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Bean
//    private RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("/test")
//    public void something() {
//        discoveryClient.getServices().forEach(System.out::println);
//        discoveryClient.getInstances("user-accounts").forEach(System.out::println);
//
//        ResponseEntity<List<Bookmark>> exchange =
//                this.restTemplate.exchange(
//                        "http://user-accounts/{userId}/bookmarks",
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<List<Bookmark>>() {
//                        },
//                        (Object) "mstine");
//
//        exchange.getBody().forEach(System.out::println);
//
//    }

}