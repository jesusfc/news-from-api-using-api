package com.jesusfc.news.model.theNewsApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Data
@Builder
@NoArgsConstructor
public class Meta {

    @JsonCreator
    public Meta(
            @JsonProperty("found") int found,
            @JsonProperty("returned") int returned,
            @JsonProperty("limit") int limit,
            @JsonProperty("page") int page) {

        this.found = found;
        this.returned = returned;
        this.limit = limit;
        this.page = page;
    }

    private int found;
    private int returned;
    private int limit;
    private int page;

}
