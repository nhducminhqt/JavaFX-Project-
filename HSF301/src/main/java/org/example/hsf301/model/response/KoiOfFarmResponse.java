package org.example.hsf301.model.response;

import lombok.Data;

/**
 * @author KoiOfFarmResponse
 */
@Data
public class KoiOfFarmResponse {
    private Long Id;
    private Long farm_id;
    private Long koi_id;
    private String koiName;
    private int quantity;
    private boolean available;
}
