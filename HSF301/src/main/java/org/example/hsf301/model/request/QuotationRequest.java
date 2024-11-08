package org.example.hsf301.model.request;

import lombok.Data;

/**
 * @author QuotationRequest
 */
@Data
public class QuotationRequest {
    Long bookingId;
    float amount;
    String description;
}
