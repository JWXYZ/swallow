package com.swallow.feign.hystrixutils.hystriximpl;

import com.swallow.feign.hystrixutils.FeignToEurekaClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeignToEurekaClientHystrix implements FeignToEurekaClient {

    @Override
    public String feignToClient(Map<String, String> map) {
        return "feign 熔断成功！";
    }

    @Override
    public String feignToClientHystrix(Map<String, String> map) {
        return "feign hystrix 熔断成功！";
    }
}
