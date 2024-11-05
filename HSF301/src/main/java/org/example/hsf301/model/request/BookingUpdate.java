package org.example.hsf301.model.request;

import lombok.Data;
import org.example.hsf301.enums.PaymentMethod;

@Data
public class BookingUpdate {
    float vat;
    PaymentMethod paymentMethod;
    float discountAmount;
}
