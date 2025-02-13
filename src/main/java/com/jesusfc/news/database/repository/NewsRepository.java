package com.jesusfc.news.database.repository;

import com.jesusfc.news.database.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}
