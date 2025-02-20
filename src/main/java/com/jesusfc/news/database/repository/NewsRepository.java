package com.jesusfc.news.database.repository;

import com.jesusfc.news.database.entity.NewsEntity;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    @Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM NewsEntity n WHERE n.uuid = :uuid")
    boolean existsByUuidContains(@Size(max = 36) String uuid);
}
