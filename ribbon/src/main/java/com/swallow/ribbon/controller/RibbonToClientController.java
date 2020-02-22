package com.swallow.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class RibbonToClientController {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET , value = "/ribbon")
    public String getPort(@RequestParam(value = "name") String name){
        return restTemplate.getForObject("http://eureka-client/ribbon?name=" + name, String.class);
    }

}
