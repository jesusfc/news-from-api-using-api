package com.jesusfc.news.model.theNewsApi;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Builder
@Data
public class ApiNewsResponse {
    Meta meta;
    List<com.jesusfc.news.model.theNewsApi.Data> data;
}
