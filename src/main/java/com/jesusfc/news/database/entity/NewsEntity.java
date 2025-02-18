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

    @Column(name = "published_at")
    private String publishedAt;

    @Column(name = "banner_image_url")
    private String bannerImageUrl;

    @Column(name = "source")
    private String source;

    @Column(name = "source_domain")
    private String sourceDomain;

    //@Column(name = "authors")
    //private List<String> authors;

    /*
    private String description;
    private String keywords;
    private String snippet;
    private String url;
    private String image_url;
    private String language;
    private String published_at;
    private String source;
    private String[] categories;
    private String relevance_score;
    private String locale;
*/
}
