package com.jesusfc.news.service;

import com.jesusfc.news.database.entity.NewsEntity;
import com.jesusfc.news.model.theNewsApi.ApiNewsResponse;
import com.jesusfc.news.service.IAService.OpenAIService;
import com.jesusfc.news.service.externalApiNews.TheNewsApiFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void addNews() {

        ApiNewsResponse apiNewsResponse = theNewsApiFeignService.getHighlightsNews("us");
        List<com.jesusfc.news.model.theNewsApi.Data> dataList = apiNewsResponse.getData();
        dataList.forEach(data -> {

            // Only English news
            if (data.getLanguage().equals("us")) {

                // Get new title and news from OpenAI
                String newTitle = openAIService.getForNewTitle(data.getTitle());
                String newNews = openAIService.getForNewsResume(data.getDescription());

                NewsEntity newsEntity = NewsEntity.builder()
                        .uuid(data.getUuid())
                        .title(newTitle)
                        .description(newNews)
                        .publishedAt(data.getPublished_at())
                        .bannerImageUrl(data.getImage_url())
                        .source(data.getSource())
                        .sourceDomain(data.getSource_domain())
                        .build();

                // Save News
                newsService.saveNews(newsEntity);
            }
        });

    }
}
