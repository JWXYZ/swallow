package com.swallow.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RibbonToClientController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(method = RequestMethod.GET , value = "/ribbon")
    public String ribbonToClient(@RequestParam(value = "name") String name){
        return name + "获取到的端口：" + port ;

    }

    @RequestMapping(method = RequestMethod.POST , value = "/feign")
    public String feignToClient(@RequestBody Map<String,String> map){
        return map.get("name") + "获取到的端口：" + port ;

    }

    @RequestMapping(method = RequestMethod.POST , value = "/feignHystrix")
    public String feignToClientHystrix(@RequestBody Map<String,String> map){
        return String.valueOf(1/0) ;

    }

}
