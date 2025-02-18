package com.jesusfc.news.service;

import com.jesusfc.news.database.entity.NewsEntity;

import java.util.List;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
public interface NewsService {

    List<NewsEntity> getNews();
    NewsEntity getNewsById(long id);
    void saveNews(NewsEntity newsEntity);

}
