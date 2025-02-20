package com.jesusfc.news.service;

import com.jesusfc.news.database.entity.NewsEntity;
import com.jesusfc.news.database.repository.NewsRepository;
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
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<NewsEntity> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public NewsEntity getNewsById(long id) {
        return newsRepository.findById(id).orElseThrow(() -> new RuntimeException("News not found"));
    }

    @Override
    public void saveNews(NewsEntity newsEntity) {
        if (!newsRepository.existsByUuidContains(newsEntity.getUuid())) {
            newsRepository.save(newsEntity);
        }
    }

}
