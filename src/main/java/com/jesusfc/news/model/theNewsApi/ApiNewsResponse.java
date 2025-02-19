package com.jesusfc.news.model.theNewsApi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Builder
@Data
@NoArgsConstructor
public class ApiNewsResponse {

    Meta meta;
    List<com.jesusfc.news.model.theNewsApi.Data> data;

    // Constructor con parámetros
    @JsonCreator
    public ApiNewsResponse(@JsonProperty("meta") Meta meta, @JsonProperty("data") List<com.jesusfc.news.model.theNewsApi.Data> data) {
        this.meta = meta;
        this.data = data;
    }
}
