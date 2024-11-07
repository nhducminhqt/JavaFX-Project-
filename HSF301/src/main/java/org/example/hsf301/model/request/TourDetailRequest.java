package org.example.hsf301.model.request;

import lombok.Data;

@Data
public class TourDetailRequest {
    private Long tourID;
    private Long farmID;
    private String description;
}
