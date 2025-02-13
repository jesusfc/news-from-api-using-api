package com.jesusfc.news.model.theNewsApi;

import lombok.Builder;
import lombok.Data;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on feb - 2025
 */
@Data
@Builder
public class Meta {

    private int found;
    private int returned;
    private int limit;
    private int page;

}
