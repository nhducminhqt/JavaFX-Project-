package org.example.hsf301.model.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class DeliveryRequest {
    private String customerName;

    private String reason;

    private LocalDate receiveDate;

    private String healthKoiDescription;

    private String status;

    private String address;
}
