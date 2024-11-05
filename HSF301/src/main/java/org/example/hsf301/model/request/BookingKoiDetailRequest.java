package org.example.hsf301.model.request;

import lombok.Data;
import org.example.hsf301.pojo.KoiFarms;

@Data
public class BookingKoiDetailRequest {
    Long farmId;
    Long koiId;
    int quantity;
    float unitPrice;
}
