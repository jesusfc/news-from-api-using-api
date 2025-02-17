package com.jesusfc.news.service;

import com.jesusfc.news.database.entity.NewsEntity;
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

        //ApiNewsResponse apiNewsResponse = theNewsApiFeignService.getHighlightsNews("us");
        //List<Data> dataList = apiNewsResponse.getData();
        List<NewsEntity> news = newsService.getNews();
        for (NewsEntity n : news) {

            System.out.println("News: " + n.getTitle());
            System.out.println("Article: " + n.getDescription());
            String newTitle = openAIService.getForNewTitle(n.getTitle());
            String newNews = openAIService.getForNewsResume(n.getDescription());

            System.out.println("NewTitle: " + newTitle);
            System.out.println("NewArticle: " + newNews);

        }

    }
}
