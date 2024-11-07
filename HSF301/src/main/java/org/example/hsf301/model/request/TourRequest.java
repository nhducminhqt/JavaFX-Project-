package org.example.hsf301.model.request;

import lombok.Data;

import java.util.Date;
@Data
public class TourRequest {
     private String tourName;
    private float unitPrice;
    private int maxParticipants;
    private String description;
    private Date startTime;
    private Date endTime;
    private String tourImg;
}
