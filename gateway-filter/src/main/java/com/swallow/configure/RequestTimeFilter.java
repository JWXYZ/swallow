package com.swallow.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class RequestTimeFilter implements GatewayFilter, Ordered {

    private static final String REQUEST_TIME_REGIN = "requestTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(
                Mono.fromRunnable(() ->{
                    Long startTime = exchange.getAttribute(REQUEST_TIME_REGIN);
                    if (startTime != null){
                        log.info(exchange.getRequest().getURI().getRawPath() + ":" + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
