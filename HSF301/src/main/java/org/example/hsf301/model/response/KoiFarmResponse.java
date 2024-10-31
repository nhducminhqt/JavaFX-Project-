package org.example.hsf301.model.response;

import lombok.Data;

import java.util.List;

/**
 * @author KoiFarmResponse
 */
@Data
public class KoiFarmResponse {
    private  Long id;
    private String farmName;
    private String farmPhoneNumber;
    private String farmEmail;
    private String farmAddress;
    private String website;
    private String description;
    private boolean isActive;
    private List<KoiFarmImageResponse> koiFarmImages;
    private List<KoiOfFarmResponse> koiOfFarms;
    private List<KoiResponse> koiResponses;
}
