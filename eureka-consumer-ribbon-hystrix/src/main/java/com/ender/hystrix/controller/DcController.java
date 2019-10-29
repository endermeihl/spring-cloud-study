package com.ender.hystrix.controller;

import com.ender.hystrix.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    private final ConsumerService consumerService;

    public DcController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }


}