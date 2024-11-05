package org.example.hsf301.model.request;

import lombok.Data;

@Data
public class BookingUpdate {
    float vat;
    String paymentMethod;
    float discountAmount;
}
