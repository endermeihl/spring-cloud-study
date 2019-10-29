package com.ender.product.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    private final DiscoveryClient discoveryClient;

    public DcController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.description();
        System.out.println(services);
        return services;
    }

    @GetMapping("/")
    public String index() {
        String services = "Services: " + discoveryClient.description();
        System.out.println(services);
        return services;
    }

}