package org.example.hsf301.model.request;

import lombok.Data;
import org.example.hsf301.enums.PaymentMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookingKoiRequest {

    PaymentMethod paymentMethod;
    List<BookingKoiDetailRequest> details;
    float vat;
    LocalDate bookingDate;
    float discountAmount;
}
