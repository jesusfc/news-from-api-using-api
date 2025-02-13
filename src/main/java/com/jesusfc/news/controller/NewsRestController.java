package com.jesusfc.news.controller;

import com.jesusfc.news.model.theNewsApi.ApiNewsResponse;
import com.jesusfc.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/news/")
public class NewsRestController {

    private final NewsService newsService;

    @RequestMapping("/getHighlights")
    public ResponseEntity<ApiNewsResponse> getNews() {
        return ResponseEntity.ok(newsService.getHighlightsNews("us"));
    }

}
