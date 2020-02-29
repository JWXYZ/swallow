package com.swallow.eurekaclienthystrix.com.swallow.java.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientHhystrixController {

    /**
     * 访问地址 http://localhost:8762/actuator/hystrix.stream
     * @param args
     */

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String eurekaHystrix(@RequestParam(value = "name" ,defaultValue = "forezp") String name){
        return "hi" + name + ", i am from port :" + port ;
    }

    public String hiError(String name){
        return "hi," + name + ",sorry,error!";
    }

}
