package com.microservice.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    private final Logger log = LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);
    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // pre-processing
            if (config.isPreLogger()) {
                log.info("Pre GatewayFiltter Logging: " + config.getBaseMessage());
                log.info("URI: "+exchange.getRequest().getURI());
                log.info("METHOD: "+exchange.getRequest().getMethod());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                // post-processing
                if (config.isPostLogger()) {
                    log.info("Post GatewayFiltter Logging: " + config.getBaseMessage());
                    log.info("URI: "+exchange.getRequest().getURI());
                    log.info("METHOD: "+exchange.getRequest().getMethod());
                }
            }));
        };
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Config {
        // Specify your configurations
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }
}
