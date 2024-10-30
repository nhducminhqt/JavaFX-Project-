package org.example.hsf301.model.request;

import lombok.Data;

@Data
public class BookingKoiDetailRequest {
    Long koiId;
    int quantity;
    float unitPrice;
}
