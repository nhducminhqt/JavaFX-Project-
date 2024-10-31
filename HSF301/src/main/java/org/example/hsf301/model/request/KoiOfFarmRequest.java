
package org.example.hsf301.model.request;

import lombok.Data;

/**
 * @author KoiOfFarmRequest
 */
@Data
public class KoiOfFarmRequest {
    private Long koiId;

    private Long farmId;

    private int quantity;

    private boolean available;
}
