package org.example.hsf301.model.request;

import lombok.Data;

import java.util.Date;
@Data
public class DeliveryRequest {
    private String customerName;

    private String reason;

    private Date receiveDate;

    private String healthKoiDescription;

    private String status;

    private String address;
}
