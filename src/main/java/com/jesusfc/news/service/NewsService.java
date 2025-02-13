package com.jesusfc.news.service;

import com.jesusfc.news.config.FeignClientsConfig;
import com.jesusfc.news.model.theNewsApi.ApiNewsResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@FeignClient(name = "the-news-api-feign-service", url = "${api-service.the-news-api.url}", configuration = FeignClientsConfig.class)
public interface NewsService {

    @GetMapping(value="/top", consumes = MediaType.APPLICATION_JSON_VALUE)
    ApiNewsResponse getHighlightsNews(@PathParam(value = "locale") String locale);

}
