package com.swallow.feign.hystrixutils;

import com.swallow.feign.hystrixutils.hystriximpl.FeignToEurekaClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "eureka-client" , fallback = FeignToEurekaClientHystrix.class)
public interface FeignToEurekaClient {

    @RequestMapping(method = RequestMethod.POST , value = "/feign")
    String feignToClient(Map<String, String> map);

    @RequestMapping(method = RequestMethod.POST , value = "/feignHystrix")
    String feignToClientHystrix(Map<String, String> map);
}
