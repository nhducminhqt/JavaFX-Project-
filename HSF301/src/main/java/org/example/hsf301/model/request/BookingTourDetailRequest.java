package org.example.hsf301.model.request;

import lombok.Data;

@Data
public class BookingTourDetailRequest {
    private Long bookingID;
    private Long tourID;
    private int participant;
}
