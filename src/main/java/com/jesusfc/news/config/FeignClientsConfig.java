package com.jesusfc.news.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Configuration
public class FeignClientsConfig implements RequestInterceptor {

    @Value("${api-service.the-news-api.api_token}")
    private String apiToken;

    @Override
    public void apply(RequestTemplate template) {
        template.query("api_token", apiToken);
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignClientsConfig();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


}
