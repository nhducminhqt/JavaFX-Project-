package org.example.hsf301.model.request;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author KoiRequest
 */
@ToString
@Data
public class KoiRequest {
    private String koiName;

    private String image;

    private String description;

    private String color;

    private String origin;

}
