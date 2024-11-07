package org.example.hsf301.model.request;

import lombok.Data;
import org.example.hsf301.enums.PaymentMethod;

import java.time.LocalDate;
import java.util.List;
@Data

public class BookingTourRequest {
    PaymentMethod paymentMethod;
    List<BookingTourDetailRequest> details;
    float vat;
    LocalDate bookingDate;
    float discountAmount;
}
