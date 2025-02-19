package com.jesusfc.news.model.theNewsApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Builder
@lombok.Data
@NoArgsConstructor
public class Data {

    private String uuid;
    private String title;
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

    @JsonCreator
    public Data(
            @JsonProperty("uuid") String uuid,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("keywords") String keywords,
            @JsonProperty("snippet") String snippet,
            @JsonProperty("url") String url,
            @JsonProperty("image_url") String image_url,
            @JsonProperty("language") String language,
            @JsonProperty("published_at") String published_at,
            @JsonProperty("source") String source,
            @JsonProperty("categories") String[] categories,
            @JsonProperty("relevance_score") String relevance_score,
            @JsonProperty("locale") String locale) {

        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.snippet = snippet;
        this.url = url;
        this.image_url = image_url;
        this.language = language;
        this.published_at = published_at;
        this.source = source;
        this.categories = categories;
        this.relevance_score = relevance_score;
        this.locale = locale;
    }


}
