package org.example.hsf301.model.response;

import org.example.hsf301.model.request.KoiImageRequest;

import java.util.List;

/**
 * @author KoiResponse
 */
public class KoiResponse {
    private Long id;

    private String koiName;

    private List<KoiImageRequest> koiImageList;

    private String description;

    private String color;

    private String origin;

    private boolean isActive;
}
