package org.example.hsf301.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DepositRequest {
    private float shippingFee;

    private LocalDate deliveryExpectedDate;

    private String shippingAddress;

    private float depositPercentage;

}
