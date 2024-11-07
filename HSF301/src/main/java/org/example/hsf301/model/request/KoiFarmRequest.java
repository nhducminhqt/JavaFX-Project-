
package org.example.hsf301.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author KoiFarmRequest
 */
@Data
public class KoiFarmRequest {
    private String farmName;
    private String farmPhoneNumber;
    private String farmEmail;
    private String farmAddress;
    private String website;
    private String description;
    private boolean active;
    private String images;
}
