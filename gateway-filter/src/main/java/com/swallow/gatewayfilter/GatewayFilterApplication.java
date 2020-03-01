package com.swallow.gatewayfilter;

import com.swallow.configure.MyTokenFilter;
import com.swallow.configure.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class, args);
    }

 /*   @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes().route(
                r -> r.path("/customer/**")
                    .filters(f -> f.filter(new RequestTimeFilter())
                                    .addRequestHeader("X-Response-Default-Foo","Default-Bar") )
                .uri("http://www.baidu.com")
                .order(0)
                .id("customer_filter_router")
        ).build();
    }*/

    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory(){
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public MyTokenFilter tokenFilter(){
        return new MyTokenFilter();
    }

}
