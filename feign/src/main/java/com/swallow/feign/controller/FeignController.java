package com.swallow.feign.controller;

import com.swallow.feign.hystrixutils.FeignToEurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeignController {

    @Autowired
    private FeignToEurekaClient feignToEurekaClient;

    @RequestMapping(method = RequestMethod.POST,value = "/feign")
    public String feignToEurekaClient(@RequestBody Map<String,String> map){
        return feignToEurekaClient.feignToClient(map);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/feignHystrix")
    public String feignToEurekaClientHystrix(@RequestBody Map<String,String> map){
        return feignToEurekaClient.feignToClientHystrix(map);
    }

}
