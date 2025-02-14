package com.jesusfc.news.controller;

import com.jesusfc.news.database.entity.NewsEntity;
import com.jesusfc.news.service.CronService;
import com.jesusfc.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private final CronService cronService;

    @RequestMapping("/getHighlights")
    public ResponseEntity<List<NewsEntity>> getNews() {
        return ResponseEntity.ok(newsService.getNews());
    }

    @RequestMapping("/getNewsTestIA")
    public ResponseEntity<List<NewsEntity>> getNewsTestIA() {
        cronService.addNews();
        return ResponseEntity.ok(newsService.getNews());
    }

}
