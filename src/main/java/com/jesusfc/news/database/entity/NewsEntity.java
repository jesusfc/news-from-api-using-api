package com.jesusfc.news.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "news") // En plural, las tablas en plural
@Entity
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 36)
    @Column(name = "uuid")
    private String uuid;

    @Size(max = 150)
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "snippet")
    private String snippet;

    @Column(name = "published_at")
    private String publishedAt;

    @Column(name = "url")
    private String url;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "language")
    private String language;

    @Column(name = "source")
    private String source;

    @Column(name = "relevance_score")
    private String relevanceScore;

    @Column(name = "locale")
    private String locale;

    //@Column(name = "categories")
    //private String[] categories;

}
