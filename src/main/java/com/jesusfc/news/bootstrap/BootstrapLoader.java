package com.jesusfc.news.bootstrap;

import com.jesusfc.news.database.entity.NewsEntity;
import com.jesusfc.news.database.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Transactional
@Component
@RequiredArgsConstructor
public class BootstrapLoader implements CommandLineRunner {

    private final NewsRepository newsRepository;

    @Override
    public void run(String... args) {
        loadBasics();
    }

    private void loadBasics() {

        NewsEntity newsEntity = NewsEntity.builder()
                .uuid("9f797f3c-c5ad-4bcc-825c-4ff7a3cddd4b")
                .title("Some DEI programs aren’t worth defending")
                .description("Donald Trump is purging the federal government of all DEI programs. To effectively combat him, Democrats must admit that some diversity programs are misguided.")
                .build();

        newsRepository.save(newsEntity);

    }

}
