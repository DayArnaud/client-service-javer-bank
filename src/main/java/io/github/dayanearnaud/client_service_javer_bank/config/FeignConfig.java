package io.github.dayanearnaud.client_service_javer_bank.config;

import io.github.dayanearnaud.client_service_javer_bank.exceptions.FeignCustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public FeignCustomErrorDecoder feignCustomErrorDecoder() {
        return new FeignCustomErrorDecoder();
    }
}
