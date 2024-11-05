package org.example.hsf301.model.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingKoiRequest {

    String paymentMethod;
    List<BookingKoiDetailRequest> details;
    float vat;
    LocalDate bookingDate;
    float discountAmount;
}
