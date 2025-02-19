package com.jesusfc.news.service;

import com.jesusfc.news.database.entity.NewsEntity;
import com.jesusfc.news.model.theNewsApi.ApiNewsResponse;
import com.jesusfc.news.service.IAService.OpenAIService;
import com.jesusfc.news.service.externalApiNews.TheNewsApiFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@RequiredArgsConstructor
@Transactional
@Service
public class CronServiceImpl implements CronService {

    private final TheNewsApiFeignService theNewsApiFeignService;
    private final NewsService newsService;
    private final OpenAIService openAIService;

    private static final List<String> languages = List.of("us", "en", "es");


    @Override
    public void addNews() {

        ApiNewsResponse apiNewsResponse = theNewsApiFeignService.getHighlightsNews("us");
        List<com.jesusfc.news.model.theNewsApi.Data> dataList = apiNewsResponse.getData();
        dataList.forEach(data -> {

            // Allow only language in the array
            if (languages.contains(data.getLanguage())) {

                // Get new title and news from OpenAI
                //String newTitle = openAIService.getForNewTitle(data.getTitle());
                //String newNews = openAIService.getForNewsResume(data.getDescription());

                String newTitle = data.getTitle();
                String newNews = data.getDescription();

                NewsEntity newsEntity = NewsEntity.builder()
                        .uuid(data.getUuid())
                        .title(newTitle)
                        .description(newNews)
                        .publishedAt(data.getPublished_at())
                        .url(data.getUrl())
                        .imageUrl(data.getImage_url())
                        .language(data.getLanguage())
                        .relevanceScore(data.getRelevance_score())
                        .locale(data.getLocale())
                        .source(data.getSource())
                        .keywords(data.getKeywords())
                        .snippet(data.getSnippet())
                        .build();

                // Save News
                newsService.saveNews(newsEntity);
            }
        });

    }
}
