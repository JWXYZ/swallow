package com.swallow.configureclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigureClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigureClientApplication.class, args);
    }

    @RequestMapping(value = "/hi")
    public String hi(){
        return "df";
    }
}
