package com.jesusfc.news.model.theNewsApi;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Builder
@lombok.Data
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
    private String source_domain;

    private String[] categories;
    private String relevance_score;
    private String locale;
}
