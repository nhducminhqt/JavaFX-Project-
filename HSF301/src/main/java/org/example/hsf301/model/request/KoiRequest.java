package org.example.hsf301.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author KoiRequest
 */
@Data
public class KoiRequest {
    private String koiName;

    private List<KoiImageRequest> koiImageList;

    private String description;

    private String color;

    private String origin;

}